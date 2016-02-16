package android.duodinamico.servicios.Impl;

import android.duodinamico.servicios.Interface.IWebServices;
import android.util.Log;

import Entidades.Objetos.Cliente;
import Entidades.Objetos.Empleado;
import Entidades.Objetos.Persona;
import Entidades.Objetos.Ubicacion;
import Logica.Clases.FabricaLogica;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.ksoap2.serialization.PropertyInfo;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class WebServices implements IWebServices {
    static String tag = "WebServices";

    /**
     Se utilizó el servidor Glassfish porque tomcat complicó un poco.
     Se debe hacer deploy del LavadoFacilWebServices en netbeans para subir localmente y
     poder probar.
     Averiguar IP local con comando ipconfig en CMD y cambiar la variable currentIpPlusPort
     (solo la IP, no cambiar puerto!)

     NAMESPACE: Namespace is the targetNamespace in the WSDL.
     URL: The WSDL URL. Its value is the location attribute of the soap:address element
     for a port element in a WSDL. Unless the web service is also hosted on the Android
     device, the hostname should not be specified as localhost, because the application
     runs on the Android device while the web service is hosted on the localhost server.
     Specify hostname as the IP address of the server hosting the web service.
     METHOD_NAME: The name of the web service operation, which may be obtained form the WSDL.
     SOAP_ACTION: NAMESPACE+METHOD_NAME specified as a String literal.

     Info sacada de:
     http://www.ibm.com/developerworks/library/ws-android/
     */

    private static final String currentIpPlusPort = "192.168.1.41:8080";

    private static final String NAMESPACE = "http://LavadoFacilWebServices/";
    private static String URL = "http://" +
                                currentIpPlusPort +
                                "/LavadoFacilWebServices/AndroidWebServices?wsdl";

    @Override
    public Persona BuscarPersona(String ced) throws Exception {
        try {
            final String METHOD_NAME = "BuscarPersona";
            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            request.addProperty("ced", ced);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.setOutputSoapObject(request);
            envelope.addMapping(NAMESPACE, "Persona", Persona.class);
            envelope.addMapping(NAMESPACE, "Cliente", Cliente.class);
            envelope.addMapping(NAMESPACE, "Empleado", Empleado.class);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            androidHttpTransport.call(NAMESPACE + METHOD_NAME, envelope);
            return ParseUtils.getPersonaFromResponse(
                    Enumeraciones.TipoPersona.Cliente,
                   (SoapObject)envelope.getResponse(),
                    true);
        } catch (IOException e) {
            String msj = "Ha ocurrido un error de conexión con el servidor. Intente nuevamente más tarde.";
            Log.e(tag, msj, e);
            throw new IOException(msj);
        }
    }


    @Override
    public Cliente LoginCliente (String ced, String passw)throws Exception {
        //return FabricaLogica.getInstancia().getILogicaPersonas().LoginCliente(ced, passw);
        try {
            final String METHOD_NAME = "LoginCliente";
            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            request.addProperty("ced", ced);
            request.addProperty("passw", passw);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

            envelope.setOutputSoapObject(request);
            envelope.addMapping(NAMESPACE, "Cliente", Cliente.class);
            envelope.addMapping(NAMESPACE, "Ubicacion", Ubicacion.class);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            androidHttpTransport.call(NAMESPACE + METHOD_NAME, envelope);
            return (Cliente)ParseUtils.getPersonaFromResponse(
                    Enumeraciones.TipoPersona.Cliente,
                    (SoapObject)envelope.getResponse(),
                    false);
        } catch (IOException e) {
            String msj = "Ha ocurrido un error de conexión con el servidor. Intente nuevamente más tarde.";
            Log.e(tag, msj, e);
            throw new IOException(msj);
        }
    }
}
