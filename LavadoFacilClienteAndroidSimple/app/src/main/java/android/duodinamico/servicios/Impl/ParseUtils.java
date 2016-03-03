package android.duodinamico.servicios.Impl;
import android.util.Log;

import org.ksoap2.serialization.SoapObject;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import Entidades.Datatypes.PrendaExtended;
import Entidades.Objetos.Cliente;
import Entidades.Objetos.Empleado;
import Entidades.Objetos.Excepcion;
import Entidades.Objetos.Persona;
import Entidades.Objetos.Prenda;
import Entidades.Objetos.Ubicacion;

public class ParseUtils {

    public static Persona getPersonaFromResponse(WebServices.TipoPersona personType, SoapObject response) {
        boolean isCliente = (personType == WebServices.TipoPersona.Cliente);
        Persona p = isCliente ? new Cliente() : new Empleado();
        p.setCedula(response.getProperty(0).toString());
        p.setTelefono(response.getProperty(1).toString());
        p.setNombre(response.getProperty(2).toString());
        p.setPassw(response.getProperty(3).toString());
        p.setCelular(response.getProperty(4).toString());
        //Ubicacion
        SoapObject so = (SoapObject) response.getProperty(5);
        p.setUbicacion(new Ubicacion());
        p.getUbicacion().setBarrio(so.getProperty(0).toString());
        p.getUbicacion().setCiudad(so.getProperty(1).toString());
        p.getUbicacion().setDireccion(so.getProperty(2).toString());
        p.getUbicacion().setId(Integer.parseInt(so.getProperty(3).toString()));

        /*if(isCliente) {
            //cargo atributos cliente
        } else {
            //cargo atributos empleado
        }*/
        return p;
    }

    public static LinkedList<Prenda> getPrendaListFromResponse(Vector<SoapObject> response) {
        LinkedList<Prenda> result = new LinkedList<>();
        String tag = "ParseUtils";
        Log.e(tag, "Entre a getPrendaListFromResponse");
        for(SoapObject so : response) {
            /*
             <return>
            <idpda>1</idpda>
            <tintoreria>true</tintoreria>
            <tipo>AcolchadoPlumas</tipo>
         </return>
         <return>
            <idpda>2</idpda>
            <tintoreria>true</tintoreria>
            <tipo>AcolchadoWata</tipo>
         </return>
            ...
            */
            Prenda p = new Prenda();
            p.setIdpda(Integer.parseInt(so.getProperty(0).toString()));
            p.setTintoreria(Boolean.valueOf(so.getProperty(1).toString()));
            p.setTipo(so.getProperty(2).toString());
            result.add(p);
        }
        Log.e(tag, "Salgo de getPrendaListFromResponse");
        return result;
    }

    public static LinkedList<Excepcion> getExcepcionListFromResponse(Vector<SoapObject> response) {
        LinkedList<Excepcion> result = new LinkedList<>();
        String tag = "ParseUtils";
        Log.e(tag, "Entre a getExcepcionListFromResponse");
        for(SoapObject so : response) {
            /*
             <return>
            <nombre>Omitir perfumado</nombre>
            <id>1</id>
         </return>
         <return>
            <nombre>Omitir planchado</nombre>
            <id>2</id>
         </return>
            ...
            */
            Excepcion exc = new Excepcion();
            exc.setNombre(so.getProperty(0).toString());
            exc.setid(Integer.parseInt(so.getProperty(1).toString()));
            result.add(exc);
        }
        Log.e(tag, "Salgo de getExcepcionListFromResponse");
        return result;
    }
}
