package Entidades;

import Entidades.Objetos.Excepcion;
import Entidades.Objetos.Movimiento;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Utilidades {
    
    public static boolean IsNullOrEmpty(String parametro) {
        return  (parametro == null || 
                (parametro != null && parametro.equals(Constantes.EMPTY))
                );
    }
    
    public static boolean IsNotANumber(String parametro) {
        try { 
            Integer.parseInt(parametro); 
            return false;
        } catch(NumberFormatException nfe) { 
            return true; 
        }
    }
    
    public static boolean IsNotABigDecimal(String parametro) {
        try {
            new BigDecimal(parametro); 
            return false;
        } catch(Exception nfe) { 
            return true; 
        }
    }
	
    public static boolean IsNull(Object objeto) {
            return (objeto == null);
    }
    
    public static Calendar DateToCalendar(Date date){ 
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
    
    public static List<Movimiento> GetMovimientosEntreDosFechas(List<Movimiento> listaOriginal, Date inicio, Date fin) {
        List<Movimiento> aux = listaOriginal;
        for(int i = 0; i < aux.size(); i++) {
            boolean isBetweenBothDates = 
                    ((aux.get(i).getFechaMov().after(inicio) || aux.get(i).getFechaMov().equals(inicio)) &&
                    (aux.get(i).getFechaMov().before(fin) || aux.get(i).getFechaMov().equals(fin)));

            if(!isBetweenBothDates) {
                aux.remove(i);
                i--;
            }
        }
        
        return aux;
    }
    
    public static String ObtenerExcepcionesStr(List<Excepcion> excepciones, Integer trimSize) {
        String retorno = Constantes.EMPTY;
                
        if(excepciones.size() > 0) {
            for(int i = 0; i < excepciones.size(); i++) {
                retorno += excepciones.get(i).getNombre() + ", ";
            }
        }

        if(retorno != Constantes.EMPTY) retorno = retorno.substring(0, retorno.length() - 1);
        
        //Trim size para no sobrepasar un largo especifico
        if(trimSize != null) {
            if(retorno.length() > trimSize)
                return retorno.substring(0, trimSize);
        }
        return retorno;
    }
}
