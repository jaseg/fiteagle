package org.fiteagle.interactors.sfa.common;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.zip.Deflater;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.fiteagle.adapter.common.ResourceAdapter;
import org.fiteagle.interactors.sfa.rspec.ObjectFactory;
import org.fiteagle.interactors.sfa.rspec.RSpecContents;
import org.fiteagle.interactors.sfa.rspec.SFAv3RspecTranslator;


public abstract class SFAv3RequestProcessor {
  
  public AMCode runTimeReturnCode;
  public String outPutString = "";

	public abstract AMResult processRequest(ListCredentials credentials,
			Object... specificArgs);
	
	public  byte[] compress(String toCompress) {
		String inputString = toCompress;
		byte[] input;
		int compressedDataLength = 0;
		byte[] output = null;
		
		try {
			input = inputString.getBytes("UTF-8");
			// Compress the bytes
			output = new byte[input.length];
			Deflater compresser = new Deflater();
			compresser.setInput(input);
			compresser.finish();
			compressedDataLength = compresser.deflate(output);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return output;
	}
	
	protected AMCode getSuccessReturnCode() {
    AMCode succesReturnCode = new AMCode();
    succesReturnCode.setGeni_code(GENI_CodeEnum.SUCCESS);
    return succesReturnCode;
  }
	
	public RSpecContents parseRSpecContents(String str){
    InputStream fromIs = new ByteArrayInputStream(str.getBytes());
    RSpecContents rSpec = new RSpecContents();
    JAXBContext jc;
    try {
//      jc = JAXBContext.newInstance( "org.fiteagle.interactors.sfa.rspec" );
      jc = JAXBContext.newInstance(RSpecContents.class);
      Unmarshaller u = jc.createUnmarshaller();
      JAXBElement obj = (JAXBElement) u.unmarshal(fromIs);
      rSpec=(RSpecContents)obj.getValue();
    } catch (JAXBException e) {
      e.printStackTrace();
    }
    return rSpec;
	}
	
	
	 public String getRSpecString(RSpecContents rspec) {
	    String advertisedRspecSTR = "";
	    

	    JAXBElement<RSpecContents> rspecElem = new ObjectFactory()
	        .createRspec(rspec);

	    try {
	      advertisedRspecSTR = getString(rspecElem);
	    } catch (JAXBException e) {
	       setRuntimeReturnCode(GENI_CodeEnum.ERROR);
	       setOutput("Internal Server Error!");
	    }

	    // result.setValue(advertisedRspecSTR);
	    return advertisedRspecSTR;
	  }
	  
	   private String getString(Object jaxbObject) throws JAXBException {
	      JAXBContext context = JAXBContext
	          .newInstance("org.fiteagle.interactors.sfa.rspec");
	      Marshaller marshaller = context.createMarshaller();
	      StringWriter stringWriter = new StringWriter();
	      marshaller.marshal(jaxbObject, stringWriter);

	      return stringWriter.toString();

	    }
	   
	   private void setOutput(String string) {
	     this.outPutString = string;
	     
	   }

	   private void setRuntimeReturnCode(GENI_CodeEnum error) {
	     runTimeReturnCode = new AMCode();
	     runTimeReturnCode.setGeni_code(error);
	     
	   }
	   
	   public RSpecContents getAdvertisedRSpec(List<ResourceAdapter> resourceAdapters) {
	     RSpecContents advertisedRspec = getRSpecFromAdapters(resourceAdapters);
	     advertisedRspec.setType("advertisement");
	     return advertisedRspec;
	   }
	   
	   public RSpecContents getManifestRSpec(List<ResourceAdapter> resourceAdapters) {
	     RSpecContents manifestRspec = getRSpecFromAdapters(resourceAdapters);
	     manifestRspec.setType("manifest");
	     return manifestRspec;
	   }
	   
	   
	   
	   
	   public RSpecContents getRSpecFromAdapters(List<ResourceAdapter> resourceAdapters) {
	     RSpecContents advertisedRspec = new RSpecContents();

	     List<Object> rspecContentElements = advertisedRspec
	         .getAnyOrNodeOrLink();
	     SFAv3RspecTranslator translator = new SFAv3RspecTranslator();
	     
	     for(ResourceAdapter resourceAdapter: resourceAdapters){
	       Object fiteagleResource = translator.translateToFITeagleResource(resourceAdapter);
	       rspecContentElements.add(fiteagleResource);
	     }
	     return advertisedRspec;
	   }
	
	
	

	
}
