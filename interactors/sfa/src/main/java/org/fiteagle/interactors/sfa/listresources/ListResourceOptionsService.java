package org.fiteagle.interactors.sfa.listresources;

import org.fiteagle.interactors.sfa.common.AMCode;
import org.fiteagle.interactors.sfa.common.GENI_CodeEnum;
import org.fiteagle.interactors.sfa.common.GeniAvailableOption;
import org.fiteagle.interactors.sfa.common.SFAOptionsService;
import org.fiteagle.interactors.sfa.rspec.SFAv3RspecTranslator;

public class ListResourceOptionsService extends SFAOptionsService {

	private ListResourceOptions options;
	private boolean optionsValid = true;
	private String errorOutput = "";
	
	private AMCode amCode;
	public ListResourceOptionsService(ListResourceOptions options) {
		this.options = options;
	}

	
	 private boolean optionsAreValid() {

		return true;
	}

	
	 private boolean optionsComplete() {
		
		return true;
	}

	private  boolean isExpectedRSpecVersion() {
		return this.options.getGeni_rspec_version().getVersion().compareTo(new SFAv3RspecTranslator().getVersion())==0;
	}

	private boolean areOptionsSupported(){
		GeniAvailableOption availableOption = (GeniAvailableOption) options.getOptions().get(0);
		boolean returnValue = true;
		if(availableOption != null)
			returnValue = !availableOption.getValue();
		
		return returnValue;
		
	}
	


	public boolean areOptionsValid() {
		return optionsValid;
	}


	public void checkOptions() {
		amCode = new AMCode();
		if(!isExpectedRSpecVersion()){
			amCode.setGeni_code(GENI_CodeEnum.BADVERSION);
			optionsValid = false;
			errorOutput = GENI_CodeEnum.BADVERSION.getDescription();
		}
		if(!areOptionsSupported()){
			amCode.setGeni_code(GENI_CodeEnum.UNSUPPORTED);
			optionsValid = false;
			errorOutput = "Geni available option is not supported yet!";
		}
		if(!optionsAreValid() && !optionsComplete()){
			amCode.setGeni_code(GENI_CodeEnum.BADARGS);
			optionsValid = false;
			errorOutput  = GENI_CodeEnum.BADARGS.getDescription();
		}
		
		
	}
	
	public AMCode getErrorCode(){
		return this.amCode;
	}


	public String getErrorOutput() {
		
		return errorOutput;
	}

	
	
}