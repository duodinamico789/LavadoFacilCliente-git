package android.duodinamico.servicios.Interface;

import android.duodinamico.servicios.Impl.WebServices;

import Entidades.Objetos.Cliente;
import Entidades.Objetos.Persona;

public interface IWebServices {
    Persona BuscarPersona(String cedula) throws Exception;
    Cliente LoginCliente (String usu, String pass)throws Exception;
}
