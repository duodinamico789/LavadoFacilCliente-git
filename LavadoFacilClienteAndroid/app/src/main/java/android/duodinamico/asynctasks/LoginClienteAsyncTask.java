package android.duodinamico.asynctasks;

import android.duodinamico.actividades.LoginActivity;
import android.duodinamico.lavadofacilclienteandroid.R;
import android.duodinamico.servicios.WebServicesFabrica;
import android.duodinamico.utils.SessionUsuarioUtils;
import android.duodinamico.utils.Utils;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import Entidades.Objetos.Cliente;
import Entidades.Objetos.Empleado;
import Entidades.Objetos.Persona;

public class LoginClienteAsyncTask extends AsyncTask<String, Void, Persona> {
    private LoginActivity activity;
    private Exception exception;
    private ProgressBar pbLoader;

    public LoginClienteAsyncTask(LoginActivity activity) {
        this.activity = activity;
        this.exception = null;
        this.pbLoader = (ProgressBar) activity.findViewById(R.id.pbLoader);
    }

    @Override
    protected void onPreExecute() {
        pbLoader.setVisibility(View.VISIBLE);
    }

    @Override
    protected Persona doInBackground(String... strings) {
        String cedula = strings[0];
        String passw = strings[1];
        Persona p = null;
        try {
            p = WebServicesFabrica.getInstance().getWebServices().LoginCliente(cedula, passw);
            if (p == null || !p.getPassw().equals(passw)) {
                throw new Exception(activity.getString(R.string.error_user_or_password_invalid));
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

            SessionUsuarioUtils.getInstance(activity.getApplicationContext())
                    .createLoginSession((Cliente) persona);
            activity.RedirigirMainMenu();
        } catch (Exception e) {
            Utils.MostrarMensajeException(activity, e);
        }
    }
}
