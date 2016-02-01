package android.duodinamico.servicios.Impl;

import android.duodinamico.lavadofacilclienteandroid.R;
import android.duodinamico.servicios.Interface.IWebServices;
import android.util.Log;

import Entidades.Objetos.Cliente;
import Entidades.Objetos.Persona;
import Logica.Clases.FabricaLogica;

public class WebServices implements IWebServices {
    static String tag = "WebServices";

    //Se utilizará Lógica... pero la idea es utilizar los web services acá

    @Override
    public Persona BuscarPersona(String cedula) throws Exception {
        return FabricaLogica.getInstancia().getILogicaPersonas().BuscarPersona(cedula);
    }

    @Override
    public Cliente LoginCliente (String usu, String pass)throws Exception {
        return FabricaLogica.getInstancia().getILogicaPersonas().LoginCliente(usu, pass);
    }
}
