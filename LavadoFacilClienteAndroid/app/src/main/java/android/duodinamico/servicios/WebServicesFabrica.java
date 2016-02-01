package android.duodinamico.servicios;

import android.duodinamico.servicios.Impl.WebServices;
import android.duodinamico.servicios.Interface.IWebServices;

public class WebServicesFabrica {
    //create an object of SingleObject
    private static WebServicesFabrica instance = new WebServicesFabrica();

    //make the constructor private so that this class cannot be
    //instantiated
    private WebServicesFabrica(){}

    //Get the only object available
    public static WebServicesFabrica getInstance(){
        if(instance == null) instance = new WebServicesFabrica();
        return instance;
    }

    public IWebServices getWebServices() {
        return new WebServices();
    }


}
