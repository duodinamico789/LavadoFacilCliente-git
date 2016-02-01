package Entidades;

import java.util.LinkedList;

public class Constantes {
    public static String EMPTY = "";
    
    // <editor-fold desc="Columnas titulos">
    public static String[] excepciones_titulosColumnas = new String [] { "Nom. Excepción" };
    public static String[] opciones_titulosColumnas    = new String [] { "Nom. opción", "Precio" };
    public static String[] movimientos_titulosColumnas      = new String [] { "Fecha Mov.", "Nombre Mov.", "Monto", "Descripción" };    
    public static String[] gastos_titulosColumnas      = new String [] { "Fecha Gto.", "Nombre Gto.", "Monto", "Descripción" };    
    public static String[] ingresos_titulosColumnas      = new String [] { "Fecha Ing.", "Nombre Ing.", "Monto", "Descripción" };    
    public static String[] prendasExtended_titulosColumnas      = new String [] { "Prenda", "Cantidad", "Excepciones" };    
    public static String[] brechas_titulosColumnas     = 
            new String [] { "H. Inicio", "H. Fin", "Dias Vigencia", "Limite. Sol", "No disp." };
    public static String[] contabs_titulosColumnas     = 
            new String [] { "Sucursal", "Fecha", "Márgen ganancia" };
    // </editor-fold>
    
    //Mensajes de error y exito:
    
    // <editor-fold desc="strings excepciones">
    public static String excepcion_ProcesandoAlta   = "Procesando alta de la excepción...";
    public static String excepcion_ExitoAlta        = "La excepción ha sido agregada exitosamente.";
    public static String excepcion_ErrorAlta_m1     = "Ocurrió un error al intentar agregar la excepción a la BD. Pruebe con otro nombre.";
    public static String excepcion_ProcesandoModif  = "Procesando modificación de la excepción...";
    public static String excepcion_ExitoModif       = "La excepción ha sido modificada exitosamente.";
    public static String excepcion_ErrorModif_m1     = "Ocurrió un error al intentar agregar la excepción a la BD. Pruebe nuevamente.";
    public static String excepcion_ErrorModif_m2     = "Ocurrió un error al intentar modificar la excepción a la BD. El nombre ingresado "
            + "ya existe en la base de datos. Pruebe con otro nombre.";
    public static String excepcion_ProcesandoBaja   = "Procesando baja de la excepción...";
    public static String excepcion_ExitoBaja        = "La excepción ha sido eliminada exitosamente.";
    public static String excepcion_ErrorBaja_m1     = "Ocurrió un error al intentar borrar la excepción a la BD. Pruebe nuevamente.";
    
    public static String 
            excepciones_Error_seleccioneExcepcion   = "Por favor, seleccione una excepción para poder modificar o eliminar. ";
    public static String 
            excepciones_Error_ExcepcionNoCapturadaCorrect = "La excepción no ha podido ser capturada correctamente. Por favor,"
                                                            + "inténtelo de nuevo. ";
    public static String excepciones_Error_ExcepcionSoloLectura = 
            "La excepcion seleccionada es de solo-lectura. No se puede editar o eliminar. ";
    // </editor-fold>
	
    // <editor-fold desc="strings gastos">
    public static String gasto_ExitoAlta        = "El gasto ha sido agregada exitosamente.";
    public static String gasto_ErrorAlta_m1     = "Ocurrió un error al intentar agregar la gasto a la BD. Pruebe con otro nombre.";
	public static String gasto_ErrorAlta_m2     = "Ocurrió un error al intentar agregar la gasto a la BD. "
	+ "El gasto ya existe en el sistema. ";
    public static String gasto_ExitoModif       = "El gasto ha sido modificada exitosamente.";
    public static String gasto_ErrorModif_m1     = "Ocurrió un error al intentar modificar el gasto a la BD. Pruebe nuevamente.";
	public static String gasto_ErrorModif_m2     = "Ocurrió un error al intentar modificar el gasto a la BD. " 
	+ "El registro no existe más en el sistema. ";
    public static String gasto_ExitoBaja        = "El gasto ha sido eliminada exitosamente.";
    public static String gasto_ErrorBaja_m1     = "Ocurrió un error al intentar borrar la gasto a la BD. Pruebe nuevamente.";
    public static String 
            gastos_Error_seleccionegasto   = "Por favor, seleccione una gasto para poder modificar o eliminar. ";
    
    public static String 
            gastos_Error_ingreseNombreGasto   = "Por favor, ingrese un nombre de gasto a buscar. ";
    public static String 
            gastos_MontoErrorFormato   = "Por favor, ingrese un monto válido. ";
	
	
    public static String 
            gastos_Error_gastoNoCapturadaCorrect = "El gasto no ha podido ser capturada correctamente. Por favor,"
                                                            + "inténtelo de nuevo. ";
    public static String 
            movs_Error_movNoCapturadoCorrect = "El movimiento no ha podido ser capturado correctamente. Por favor,"
                                                            + "inténtelo de nuevo. ";
    // </editor-fold>

    // <editor-fold desc="strings ingresos">
    public static String ingreso_ExitoAlta        = "El ingreso ha sido agregada exitosamente.";
    public static String ingreso_ErrorAlta_m1     = "Ocurrió un error al intentar agregar el ingreso a la BD. Pruebe con otro nombre.";
	public static String ingreso_ErrorAlta_m2     = "Ocurrió un error al intentar agregar el ingreso a la BD. "
	+ "El ingreso ya existe en el sistema. ";
    public static String ingreso_ExitoModif       = "El ingreso ha sido modificada exitosamente.";
    public static String ingreso_ErrorModif_m1     = "Ocurrió un error al intentar modificar el ingreso a la BD. Pruebe nuevamente.";
	public static String ingreso_ErrorModif_m2     = "Ocurrió un error al intentar modificar el ingreso a la BD. " 
	+ "El registro no existe más en el sistema. ";
    public static String ingreso_ExitoBaja        = "El ingreso ha sido eliminada exitosamente.";
    public static String ingreso_ErrorBaja_m1     = "Ocurrió un error al intentar borrar el ingreso a la BD. Pruebe nuevamente.";
    public static String 
            ingresos_Error_seleccioneingreso   = "Por favor, seleccione un ingreso para poder modificar o eliminar. ";
    
    public static String 
            ingresos_Error_ingreseNombreIngreso   = "Por favor, ingrese un nombre de ingreso a buscar. ";
    public static String 
            ingresos_MontoErrorFormato   = "Por favor, ingrese un monto válido. ";
	
	
    public static String 
            ingresos_Error_ingresoNoCapturadaCorrect = "El ingreso no ha podido ser capturado correctamente. Por favor,"
                                                            + "inténtelo de nuevo. ";
    // </editor-fold>
    
    // <editor-fold desc="strings opciones">
    public static String opcion_ProcesandoAlta   = "Procesando alta de la opción...";
    public static String opcion_ExitoAlta        = "La opción ha sido agregada exitosamente.";
    public static String opcion_ErrorAlta_m1     = "Ocurrió un error al intentar agregar la opción a la BD. Pruebe con otro nombre.";
    public static String opcion_ProcesandoModif  = "Procesando modificación de la opción...";
    public static String opcion_ExitoModif       = "La opción ha sido modificada exitosamente.";
    public static String opcion_ErrorModif_m1    = "Ocurrió un error al intentar agregar la opción a la BD. Pruebe nuevamente.";
    public static String opcion_ProcesandoBaja   = "Procesando baja de la opción...";
    public static String opcion_ExitoBaja        = "La opción ha sido eliminada exitosamente.";
    public static String opcion_ErrorBaja_m1     = "Ocurrió un error al intentar borrar la opción a la BD. Pruebe nuevamente.";
    public static String 
            opciones_Error_seleccioneOpcion   = "Por favor, seleccione una opción para poder modificar o eliminar. ";
    public static String 
            opciones_Error_OpcionNoCapturadaCorrect = "La opción no ha podido ser capturada correctamente. Por favor,"
                                                            + "inténtelo de nuevo. ";
    public static String opciones_Error_OpcionSoloLectura = 
            "La opción seleccionada es de solo-lectura. No se puede eliminar. ";
    // </editor-fold>
    
    // <editor-fold desc="strings Brechas">
    public static String Brecha_ProcesandoAlta   = "Procesando alta de la brecha horaria...";
    public static String Brecha_ExitoAlta        = "La brecha horaria ha sido agregada exitosamente.";
    public static String Brecha_ErrorAlta_m1     = "Ocurrió un error al intentar agregar la brecha horaria a la BD. Pruebe con otro nombre.";
    public static String Brecha_ErrorAlta_m2     = "Ocurrió un error al intentar agregar la brecha horaria a la BD. Ya existe una brecha horaria con ese mismo horario.";
    public static String Brecha_ProcesandoModif  = "Procesando modificación de la brecha horaria...";
    public static String Brecha_ExitoModif       = "La brecha horaria ha sido modificada exitosamente.";
    public static String Brecha_ErrorModif_m1    = "Ocurrió un error al intentar modificar la brecha horaria a la BD. Pruebe nuevamente.";
    public static String Brecha_ErrorModif_m2     = "Ocurrió un error al intentar modificar la brecha horaria a la BD. Ya existe una brecha horaria con ese mismo horario.";
    public static String Brecha_ProcesandoBaja   = "Procesando baja de la brecha horaria...";
    public static String Brecha_ExitoBaja        = "La brecha horaria ha sido eliminada exitosamente.";
    public static String Brecha_ErrorBaja_m1     = "Ocurrió un error al intentar borrar la brecha horaria a la BD. Pruebe nuevamente.";
    public static String 
            Brechaes_Error_seleccioneBrecha   = "Por favor, seleccione una brecha horaria para poder modificar o eliminar. ";
    public static String 
            Brechaes_Error_HoraInicioVacio   = "Por favor, ingrese una hora de inicio. ";
    public static String 
            Brechaes_Error_HoraFinVacio   = "Por favor, ingrese una hora de fin. ";
    public static String 
            Brechaes_Error_LimiteVacio   = "Por favor, ingrese un límite. ";
    public static String 
            Brechaes_Error_DiasNoSeleccionados   = "Por favor, seleccione al menos uno de los días en el que va a estar vigente la brecha. ";
    public static String 
            Brechaes_Error_BrechaNoCapturadaCorrect = "La brecha horaria no ha podido ser capturada correctamente. Por favor,"
                                                            + "inténtelo de nuevo. ";
    public static String Brechaes_Error_HorasIncorrectas = "Horas incorrectas. La hora inicio debe ser anterior a la hora de fin. ";
    // </editor-fold>
    
    // <editor-fold desc="strings compartidos">
    //Mensaje errores:
    public static String 
            compartido_Error_NombreVacio            = "Por favor, ingrese un nombre. ";
    public static String 
            compartido_Error_FormatoNumero          = "Por favor, ingrese un número válido. ";
    public static String 
            compartido_Error_FormatoHora            = "Por favor, ingrese una hora válida.  Ejemplo: '14:30'. ";
    public static String compartido_ErrorInesperado = "Ocurrió un error inesperado. "
            + "Por favor, intente nuevamente o contacte a su administrador.";
    public static String 
            compartido_ErrorInesperadoNullPointer   = "Ocurrió un error inesperado al cargar esta ventana. Esto se debe a que el servidor no está accesible. "
            + "Por favor, inténtelo de nuevo. ";
    
    public static String 
            compartido_ErrorInesperadoCargaMenu   = "Ocurrió un error inesperado al cargar el menú principal. Esto se debe a que el servidor no puede "
            + "no estar accesible o por un incidente en el sistema. "
            + "Por favor, inténtelo de nuevo. ";
    public static String 
            compartido_Error_TodosCamposObligatorios   = "Todos los campos son obligatorios. ";
    public static String 
            compartido_Error_FormatoDel   = "Error en el formato del ";
			
    public static String
                    compartido_ProcesandoBuscar   = "Realizando busqueda... ";
    public static String
                    compartido_ProcesandoAlta   = "Procesando alta del registro... ";
    public static String
                    compartido_ProcesandoModificar   = "Procesando modificación del registro... ";
    public static String
                    compartido_ProcesandoEliminar   = "Procesando eliminación del registro... ";
    public static String
                    compartido_ErrorConexion   = "Hubo un error de conexión con el servidor. Por favor, intente mas tarde y si "
            + "el error persiste comuníquese con el administrador del sistema. ";
    // </editor-fold>
    
    public static String
                    sql_error_unreachable_connection   = "ERROR! El servidor no se encuentra disponible por el momento. Por favor, intente más tarde. ";    
    
    public static int row_count_ingresos_contab_viewer = 8;
    public static int row_count_gastos_contab_viewer = 8;
    
    public static LinkedList<String> getStepsSolicitudLavado() {
        LinkedList<String> steps = new LinkedList<>();
        steps.add("mantSolicitudesWizardPaso1");
        steps.add("mantSolicitudesWizardPaso2");
        steps.add("mantSolicitudesWizardPaso3");
        steps.add("mantSolicitudesWizardPaso4");
        return steps;
    }
}
