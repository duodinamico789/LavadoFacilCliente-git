package LavadoFacilWebServices;

import Entidades.Objetos.Prenda;
import Entidades.Utilidades;
import java.util.LinkedList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.soap.SOAPFaultException;
import org.w3c.dom.Attr;

@WebService(serviceName = "AndroidWebServices")
public class AndroidWebServices {
    
    @WebMethod(operationName = "BuscarPersona")
    public Entidades.Objetos.Persona BuscarPersona(
            @WebParam(name = "ced") String ced) throws WebServiceException {
        try {
            return Logica.Clases.FabricaLogica.getInstancia()
                    .getILogicaPersonas().BuscarPersona(ced);
        } catch (Exception e) {
            throw new WebServiceException(
                    e.getClass().getName(), 
                    e.getMessage());
        }
    }
    
    @WebMethod(operationName = "LoginCliente")
    public Entidades.Objetos.Persona LoginCliente(
            @WebParam(name = "ced") String ced,
            @WebParam(name = "passw") String passw) throws WebServiceException {
        try {
            return Logica.Clases.FabricaLogica.getInstancia()
                    .getILogicaPersonas().LoginCliente(ced, passw);
        } catch (Exception e) {
            throw new WebServiceException(
                    e.getClass().getName(), 
                    e.getMessage());
        }
    }
    
    @WebMethod(operationName = "ListarPrendas")
    public LinkedList<Entidades.Objetos.Prenda> ListarPrendas() throws WebServiceException {
        try {
            return Logica.Clases.FabricaLogica.getInstancia()
                    .getILogicaPrenda().ListarPrendas();
        } catch (Exception e) {
            throw new WebServiceException(
                    e.getClass().getName(), 
                    e.getMessage());
        }
    }
}
