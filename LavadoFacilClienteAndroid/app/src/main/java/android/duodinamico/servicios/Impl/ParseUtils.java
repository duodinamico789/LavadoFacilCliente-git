package android.duodinamico.servicios.Impl;
import org.ksoap2.serialization.SoapObject;

import Entidades.Objetos.Cliente;
import Entidades.Objetos.Empleado;
import Entidades.Objetos.Persona;
import Entidades.Objetos.Ubicacion;

public class ParseUtils {
    public static Persona getPersonaFromResponse(Enumeraciones.TipoPersona personType, SoapObject response, boolean existsUbicacionInResponse) {
        boolean isCliente = (personType == Enumeraciones.TipoPersona.Cliente);
        Persona p = isCliente ? new Cliente() : new Empleado();
        p.setCedula(response.getProperty(0).toString());
        p.setTelefono(response.getProperty(1).toString());
        p.setNombre(response.getProperty(2).toString());
        p.setPassw(response.getProperty(3).toString());
        p.setCelular(response.getProperty(4).toString());
        //Ubicacion
        if(existsUbicacionInResponse) {
            SoapObject so = (SoapObject) response.getProperty(5);
            p.setUbicacion(new Ubicacion());
            p.getUbicacion().setBarrio(so.getProperty(0).toString());
            p.getUbicacion().setDireccion(so.getProperty(1).toString());
            p.getUbicacion().setDireccion(so.getProperty(2).toString());
            p.getUbicacion().setId(Integer.parseInt(so.getProperty(3).toString()));
        }

        /*if(isCliente) {
            //cargo atributos cliente
        } else {
            //cargo atributos empleado
        }*/
        return p;
    }
}
