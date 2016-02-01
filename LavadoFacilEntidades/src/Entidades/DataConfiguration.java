package Entidades;

import Entidades.Datatypes.CategoriaOpcion;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DataConfiguration {
    /*
    //Opciones
    1 = 'Lavado completo'
    2 = 'Lavado de blancos'
    3 = 'Lavado delicado'
    4 = 'Lavado a mano'
    5 = 'Secado'
    6 = 'Planchado'
    'Perfumado' esta incluido en los lavados, pero no se puede solo 
    seleccionar perfumado por lo que en bd no va a existir.
    
    //Ver tema de agua fria y agua caliente
    
    //Excepciones
    1 = 'Omitir perfumado'
    2 = 'Omitir secado'
    3 = 'Omitir planchado'
    */
    
    //Habran opciones y excepciones fijas que no podran editarse (al menos su nombre)
    private static List<Integer> IdsOpcionesSoloLectura    = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
    private static List<Integer> IdsOpcionesTipoLavado     = Arrays.asList(1, 2, 3, 4);
    private static List<Integer> IdsExcepcionesSoloLectura = Arrays.asList(1, 2, 3);
    
    /**
    * Retorna las categorias de subopciones válidas.
    * @param  idOpcion  Cargar en caso de que se quiera traer subopciones de este id. 
    * Setear en null en caso de que se quieran traer todas las categorias de 
    * todas las opciones.
    */
    public static List<CategoriaOpcion> getCategoriasOpciones(Integer idOpcion) {
        List<CategoriaOpcion> filteredList = getCategoriasOpcionesCompleta();
        
        if(idOpcion != null) {
            
            //Filtramos por idOpcion
            for(int i = 0; i < filteredList.size(); i++) {
                if(filteredList.get(i).getIdOpcion() != idOpcion) {
                    filteredList.remove(i);
                    i--;
                }
            }
        }
        
        return filteredList;
    }
    
    private static List<CategoriaOpcion> getCategoriasOpcionesCompleta() {
        List<CategoriaOpcion> cats = new LinkedList<CategoriaOpcion>();
        
        //Los 4 lavados incluyen lavado, secado, planchado y perfumado.
        cats.add(new CategoriaOpcion(1, 5));
        cats.add(new CategoriaOpcion(1, 6));
        cats.add(new CategoriaOpcion(2, 5));
        cats.add(new CategoriaOpcion(2, 6));
        cats.add(new CategoriaOpcion(3, 5));
        cats.add(new CategoriaOpcion(3, 6));
        cats.add(new CategoriaOpcion(4, 5));
        cats.add(new CategoriaOpcion(4, 6));
        
        return cats;
    }
    
    public static boolean IsOpcionSoloLectura(int idOpcion) {
        return IdsOpcionesSoloLectura.contains(idOpcion);
    }
    
    public static boolean IsExcepcionSoloLectura(int idExcepcion) {
        return IdsExcepcionesSoloLectura.contains(idExcepcion);
    }
    
    public static boolean IsOpcionTipoLavado(int idOpcion) {
        return IdsOpcionesTipoLavado.contains(idOpcion);
    }
}

