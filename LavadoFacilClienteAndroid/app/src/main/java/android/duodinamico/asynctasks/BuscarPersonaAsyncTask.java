package android.duodinamico.asynctasks;

import android.app.Activity;
import android.duodinamico.actividades.LoginActivity;
import android.duodinamico.lavadofacilclienteandroid.R;
import android.duodinamico.servicios.WebServicesFabrica;
import android.duodinamico.utils.SessionUsuarioUtils;
import android.duodinamico.utils.Utils;
import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import Entidades.Objetos.Cliente;
import Entidades.Objetos.Empleado;
import Entidades.Objetos.Persona;

public class BuscarPersonaAsyncTask extends AsyncTask<String, Void, Persona> {
    private LoginActivity activity;
    private Exception exception;
    private final EditText txtPassw;
    private final EditText txtCedula;
    private ProgressBar pbLoader;

    public BuscarPersonaAsyncTask(LoginActivity activity) {
        this.activity = activity;
        this.exception = null;
        this.txtPassw = (EditText) activity.findViewById(R.id.txtPassw);
        this.txtCedula = (EditText) activity.findViewById(R.id.txtCedula);
        this.pbLoader = (ProgressBar) activity.findViewById(R.id.pbLoader);
    }

    @Override
    protected void onPreExecute() {
        pbLoader.setVisibility(View.VISIBLE);
    }

    @Override
    protected Persona doInBackground(String... strings) {
        String cedula = strings[0];
        Persona p = null;
        try {
            p = WebServicesFabrica.getInstance().getWebServices().BuscarPersona(cedula);
            if(p == null || p instanceof Empleado) {
                exception = new Exception(
                        activity.getString(R.string.error_user_or_password_invalid));
            }
        } catch (Exception e) {
            exception = e;
        }
        return p;
    }

    @Override
    protected void onPostExecute(Persona persona) {
        try {
            pbLoader.setVisibility(View.GONE);

            if(exception != null)
                throw exception;

            String cedula = txtCedula.getText().toString();
            String passw = txtPassw.getText().toString();

            //todo: probar esto
            LoginClienteAsyncTask a = new LoginClienteAsyncTask(activity);
            a.execute(cedula, passw);
        } catch (Exception ex) {
            Utils.MostrarMensajeException(activity, ex);
        }
    }
}
