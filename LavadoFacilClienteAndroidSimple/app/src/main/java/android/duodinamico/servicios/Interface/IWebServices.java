package android.duodinamico.servicios.Interface;

import android.duodinamico.servicios.Impl.WebServices;

import java.util.LinkedList;

import Entidades.Datatypes.PrendaExtended;
import Entidades.Objetos.Cliente;
import Entidades.Objetos.Excepcion;
import Entidades.Objetos.Persona;
import Entidades.Objetos.Prenda;

public interface IWebServices {
    Persona BuscarPersona(String cedula) throws Exception;
    Cliente LoginCliente (String usu, String pass)throws Exception;
    LinkedList<Prenda> ListarPrendas() throws Exception;
    LinkedList<Excepcion> ListarExcepciones() throws Exception;
}
