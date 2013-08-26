package org.fiteagle.interactors.sfa.allocate;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.fiteagle.adapter.common.ResourceAdapter;
import org.fiteagle.adapter.common.ResourceAdapterStatus;
import org.fiteagle.adapter.stopwatch.StopwatchAdapter;
import org.fiteagle.core.ResourceAdapterManager;
import org.fiteagle.core.groupmanagement.Group;
import org.fiteagle.core.groupmanagement.GroupDBManager;
import org.fiteagle.core.groupmanagement.SQLiteGroupDatabase.GroupNotFound;
import org.fiteagle.core.util.URN;
import org.fiteagle.core.util.URN.URNParsingException;
import org.fiteagle.interactors.sfa.common.AMCode;
import org.fiteagle.interactors.sfa.common.AMResult;
import org.fiteagle.interactors.sfa.common.Authorization;
import org.fiteagle.interactors.sfa.common.GENISliverAllocationState;
import org.fiteagle.interactors.sfa.common.GENISliverOperationalState;
import org.fiteagle.interactors.sfa.common.GENI_CodeEnum;
import org.fiteagle.interactors.sfa.common.GeniSlivers;
import org.fiteagle.interactors.sfa.common.ListCredentials;
import org.fiteagle.interactors.sfa.common.SFAv3RequestProcessor;
import org.fiteagle.interactors.sfa.describe.DescribeResult;
import org.fiteagle.interactors.sfa.describe.DescribeValue;
import org.fiteagle.interactors.sfa.rspec.NodeContents;
import org.fiteagle.interactors.sfa.rspec.ObjectFactory;
import org.fiteagle.interactors.sfa.rspec.RSpecContents;
import org.fiteagle.interactors.sfa.rspec.Resource;
import org.fiteagle.interactors.sfa.rspec.SFAv3RspecTranslator;

public class AllocateRequestProcessor extends SFAv3RequestProcessor {

	private ResourceAdapterManager resourceManager;

	public AllocateResult processRequest(String urn,
			ListCredentials credentials, RSpecContents requestRspec,
			AllocateOptions allocateOptions) {
		// TODO:get user name from credentials and correct this
		AllocateResult result = getResult(urn, credentials, requestRspec,
				"testUser");
		return result;
	}

	private AllocateResult getResult(String urn, ListCredentials credentials,
			RSpecContents requestRspec, String groupOwnerId) {
		String value = "";
		String output = "";
		AMCode returnCode = null;
		AllocateValue allocateValue = new AllocateValue();
		AllocateResult result = new AllocateResult();
		boolean validArguments = true;
		URN sliceURN = null;
		try {
			sliceURN = new URN(urn);
		} catch (URNParsingException e) {
			
			returnCode = getReturnCode(GENI_CodeEnum.BADARGS);
			validArguments = false;
		}

		// TODO CHECK OTHER ARGS
		if (validArguments) {
			Group group = null;
			boolean groupFound = true;
			try {
				group = GroupDBManager.getInstance().getGroup(
						sliceURN.getSubjectAtDomain());

			} catch (GroupNotFound e) {
				groupFound = false;
				returnCode = getReturnCode(GENI_CodeEnum.SEARCHFAILED);
				
			}
			if (groupFound) {
				Authorization auth = new Authorization();

				auth.checkCredentialsList(credentials);

				if (!auth.areCredentialTypeAndVersionValid()) {
					returnCode = auth.getReturnCode();
					output = auth.getAuthorizationFailMessage();
					result.setCode(returnCode);
					result.setOutput(output);
					return result;
				}

				SFAv3RspecTranslator translator = new SFAv3RspecTranslator();
				List<Object> rspecRequestedResources = requestRspec
						.getAnyOrNodeOrLink();

				ArrayList<ResourceAdapter> resourcesList = new ArrayList<ResourceAdapter>();

				boolean allocationSuccess = true;
				for (Iterator iterator = rspecRequestedResources.iterator(); iterator
						.hasNext();) {
					Object object = (Object) iterator.next();
					if (JAXBElement.class.isAssignableFrom(object.getClass())) {
						JAXBElement jaxbElem = (JAXBElement) object;
						ResourceAdapter resource = null;
						if (Resource.class.isAssignableFrom(jaxbElem.getValue()
								.getClass())) {
							resource = translator
									.translateResourceToResourceAdapter((Resource) jaxbElem
											.getValue());
							resourceManager
									.addResourceAdapterInstance(resource);
						}
						if (NodeContents.class.isAssignableFrom(jaxbElem
								.getValue().getClass())) {
							NodeContents node = (NodeContents) jaxbElem
									.getValue();
							String id = "";
							if (node.getComponentId().contains("+")) {
								String[] splitted = node.getComponentId()
										.split("\\+");
								id = splitted[splitted.length - 1];
							} else {
								id = node.getComponentId();
							}
							resource = resourceManager
									.getResourceAdapterInstance(id);
						}
						if (resource != null
								&& !(resource.isExclusive() && !resource
										.getStatus().equals(ResourceAdapterStatus.Available))) {
							resource.getProperties()
									.put("operational_status",
											GENISliverOperationalState.geni_pending_allocation
													.toString());
							resource.getProperties().put(
									"allocation_status",
									GENISliverAllocationState.geni_allocated
											.toString());
							resource.setStatus(ResourceAdapterStatus.Reserved);
							Date allocationExpirationTime = Calendar.getInstance().getTime();
							allocationExpirationTime.setTime(allocationExpirationTime.getTime() + 10 * 1000 * 60);
							resource.setExpirationTime(allocationExpirationTime);
							resourceManager.setExpires(resource.getId(), allocationExpirationTime);
							resourcesList.add(resource);
						} else {
							allocationSuccess = false;
							break;
						}
					}

				}
				if (allocationSuccess) {

					for (ResourceAdapter rs : resourcesList) {
						group.addResource(rs);
						GroupDBManager.getInstance().updateGroup(group);
					}

					returnCode = getReturnCode(GENI_CodeEnum.SUCCESS);
					allocateValue = getValue(urn);

				} else {
					returnCode = getReturnCode(GENI_CodeEnum.BUSY);

				}
			}
		}
		result.setCode(returnCode);
		result.setValue(allocateValue);
		return result;
	}

	private AllocateValue getValue(String urn) {
		SFAv3RspecTranslator translator = new SFAv3RspecTranslator();
		AllocateValue resultValue = new AllocateValue();
		Group group = GroupDBManager.getInstance().getGroup(
				new URN(urn).getSubjectAtDomain());
		ArrayList<GeniSlivers> slivers = new ArrayList<GeniSlivers>();

		List<String> resourceIds = group.getResources();
		List<ResourceAdapter> resources = resourceManager
				.getResourceAdapterInstancesById(resourceIds);
		for (Iterator iterator = resources.iterator(); iterator.hasNext();) {
			ResourceAdapter resourceAdapter = (ResourceAdapter) iterator.next();
			GeniSlivers tmpSliver = new GeniSlivers();
			tmpSliver.setGeni_sliver_urn(translator
					.translateResourceIdToSliverUrn(resourceAdapter.getId(),
							urn));
			tmpSliver.setGeni_allocation_status((String) resourceAdapter
					.getProperties().get("allocation_status"));
			tmpSliver
					.setGeni_expires(getFormatedDate(resourceAdapter.getExpirationTime()));
			slivers.add(tmpSliver);
		}
		resultValue.setGeni_slivers(slivers);

		RSpecContents manifestRSpec = getManifestRSpec(resources);
		String geni_rspec = getRSpecString(manifestRSpec);
		resultValue.setGeni_rspec(geni_rspec);

		return resultValue;
	}

	private String getFormatedDate(Date expirationTime) {
	 SimpleDateFormat rfc3339 = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ");
		return rfc3339.format(expirationTime);
	}

	@Override
	public AMResult processRequest(ListCredentials credentials,
			Object... specificArgs) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResourceAdapterManager getResourceManager() {
		return resourceManager;
	}

	public void setResourceManager(ResourceAdapterManager resourceManager) {
		this.resourceManager = resourceManager;
	}

}
