package android.duodinamico.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.duodinamico.actividades.LoginActivity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;

import Entidades.Objetos.Cliente;
import Entidades.Objetos.Ubicacion;

public class SessionUsuarioUtils {
    //create an object of SingleObject
    private static SessionUsuarioUtils instance = null;


    //Get the only object available
    public static SessionUsuarioUtils getInstance(Context context){
        if(instance == null) instance = new SessionUsuarioUtils(context);
        return instance;
    }

    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "LavaderoPref";

    //DateFormat para parsear Date to String y viceversa
    String dateFormat;

    //region All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // Llaves cliente
    public static final String KEY_CEDULA = "key_cedula";
    public static final String KEY_PASSW = "key_passw";
    public static final String KEY_NOMBRE = "key_nombre";
    public static final String KEY_TELEFONO = "key_telefono";
    public static final String KEY_CELULAR = "key_celular";
    public static final String KEY_FECHA_OLVIDO_PASS = "key_fecha_olvido_pass";
    public static final String KEY_FECHA_REG = "key_fecha_reg";
    public static final String KEY_FECHA_ULTIMA_ENTRADA = "key_fecha_ultima_entrada";
    public static final String KEY_UBICACION_ID = "key_ubicacion_id";
    public static final String KEY_UBICACION_BARRIO = "key_ubicacion_barrio";
    public static final String KEY_UBICACION_CIUDAD = "key_ubicacion_ciudad";
    public static final String KEY_UBICACION_DIRECCION = "key_ubicacion_direccion";
    //endregion

    // Constructor
    private SessionUsuarioUtils(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        dateFormat = "dd/MM/yyyy HH:mm:ss";
    }

    /**
     * Create login session
     * */
    public void createLoginSession(Cliente c){
        DateFormat df = new SimpleDateFormat(dateFormat, Locale.ENGLISH);

        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        if(c == null)
            throw new NullPointerException("Parámetro 'c' de tipo Cliente no fue inicializado!");

        // Storing names in pref
        editor.putString(KEY_CEDULA, c.getCedula());
        editor.putString(KEY_PASSW, c.getPassw());
        editor.putString(KEY_NOMBRE, c.getNombre());
        editor.putString(KEY_TELEFONO, c.getTelefono());
        editor.putString(KEY_CELULAR, c.getCelular());
        editor.putInt(KEY_UBICACION_ID, c.getUbicacion().getId());
        editor.putString(KEY_UBICACION_BARRIO, c.getUbicacion().getBarrio());
        editor.putString(KEY_UBICACION_CIUDAD, c.getUbicacion().getCiudad());
        editor.putString(KEY_UBICACION_DIRECCION, c.getUbicacion().getDireccion());

        // commit changes
        editor.commit();

        //
    }

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     * */
    public void checkLogin(){
        // Check login status
        if(!this.isLoggedIn()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, LoginActivity.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);
        }

    }



    /**
     * Get stored session data
     * */
    public Cliente getDetailsCliente() throws ParseException {
        DateFormat df = new SimpleDateFormat(dateFormat, Locale.ENGLISH);
        HashMap<String, Object> user = new HashMap<>();

        Cliente c = new Cliente(
                pref.getString(KEY_CEDULA,null),
                pref.getString(KEY_PASSW, null),
                pref.getString(KEY_NOMBRE, null),
                pref.getString(KEY_TELEFONO, null),
                pref.getString(KEY_CELULAR, null),
                null, //df.parse(pref.getString(KEY_FECHA_REG, null)),
                null//df.parse(pref.getString(KEY_FECHA_ULTIMA_ENTRADA, null)));;
                );
        Ubicacion ub = new Ubicacion();
        ub.setId(pref.getInt(KEY_UBICACION_ID, 0));
        ub.setBarrio(pref.getString(KEY_UBICACION_BARRIO, null));
        ub.setCiudad(pref.getString(KEY_UBICACION_CIUDAD, null));
        ub.setDireccion(pref.getString(KEY_UBICACION_DIRECCION, null));

        c.setUbicacion(ub);

        //c.setfechaOlvidoPass(df.parse(pref.getString(KEY_FECHA_OLVIDO_PASS, null)));

        // return user
        return c;
    }

    /**
     * Clear session details
     * */
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(_context, LoginActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);
    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}