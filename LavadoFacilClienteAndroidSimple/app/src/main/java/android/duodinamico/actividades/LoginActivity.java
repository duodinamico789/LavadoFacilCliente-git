package android.duodinamico.actividades;

import android.content.Intent;
import android.duodinamico.asynctasks.BuscarPersonaAsyncTask;
import android.duodinamico.lavadofacilclienteandroid.R;
import android.duodinamico.servicios.Impl.WebServices;
import android.duodinamico.servicios.WebServicesFabrica;
import android.duodinamico.utils.SessionUsuarioUtils;
import android.duodinamico.utils.Utils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import Entidades.Objetos.Cliente;
import Entidades.Objetos.Empleado;
import Entidades.Objetos.Persona;

public class LoginActivity extends ActionBarActivity {
    String tag = "LoginActivity";
    EditText txtCedula;
    EditText txtPassw;
    Button btnLoguearse;
    Button btnRegistrar;

    //region Eventos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            CargarVariables();


        } catch(Exception ex) {
            Log.e(tag, getString(R.string.logging_application_exception) + ex.getMessage());
        }
    }

    //Evento creado en CargarVariables()
    private void btnLoguearse_Click(View v) {
        try {
            if (ValidarLogin()) {
                //Cualquier excepcion sera arrojada desde persistencia
                BuscarPersonaAsyncTask a = new BuscarPersonaAsyncTask(LoginActivity.this);
                a.execute(txtCedula.getText().toString());
            }
        } catch(Exception ex) {
            Utils.MostrarMensajeException(this, ex);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
    //endregion

    //region Metodos auxiliares
    private void CargarVariables() {
        //Variables
        txtCedula = (EditText) findViewById(R.id.txtCedula);
        txtPassw = (EditText) findViewById(R.id.txtPassw);
        btnLoguearse = (Button) findViewById(R.id.btnLoguearse);
        //btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

        //Eventos botones
        btnLoguearse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { btnLoguearse_Click(v); }
        });
    }

    private boolean ValidarLogin() {
        //Valida que no haya campos vacíos
        boolean valido = true;

        if(txtCedula.getText().toString().trim().length() == 0) {
            valido = false;
            Utils.MostrarMensaje(this,
                    getString(R.string.alert_dialog_error_title),
                    getString(R.string.error_insert_user));
        } else if (txtPassw.getText().toString().trim().length() == 0) {
            valido = false;
            Utils.MostrarMensaje(this,
                    getString(R.string.alert_dialog_error_title),
                    getString(R.string.error_insert_password));
        }

        return valido;
    }

    public void RedirigirMainMenu() {
        try {
            //Creamos intent
            this.finish();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } catch(Exception ex) {
            Utils.MostrarMensaje(this, getString(R.string.alert_dialog_error_title), ex.getMessage());
        }
    }
    //endregion
}