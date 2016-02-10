package LavadoFacilWebServices;

import javax.xml.ws.WebFault;
 
@WebFault(name = "WebServiceException", targetNamespace = "LavadoFacilWebServices")
public class WebServiceException extends Exception {
    private String errorDetails;
    
    public WebServiceException(String reason, String errorDetails) {
        super(reason);
        this.errorDetails = errorDetails;
    }
    
    public String getFaultInfo() {
        return errorDetails;
    }
}