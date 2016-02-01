package Impl;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "AndroidWebServices")
public class AndroidWebServices {
    
    /**
     * Web service operation
     * @param ced
     * @return 
     * @throws java.lang.Exception 
     */
    @WebMethod(operationName = "BuscarPersona")
    public Entidades.Objetos.Persona BuscarPersona(
            @WebParam(name = "ced") String ced) throws Exception {
        return Logica.Clases.FabricaLogica.getInstancia()
                .getILogicaPersonas().BuscarPersona(ced);
    }
    
    
}
