package android.duodinamico.asynctasks;

import android.app.Activity;
import android.duodinamico.lavadofacilclienteandroid.R;
import android.duodinamico.servicios.WebServicesFabrica;
import android.duodinamico.utils.Utils;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;

import java.util.LinkedList;
import java.util.List;

import Entidades.Objetos.Excepcion;
import Entidades.Objetos.Prenda;

public class LoadSpinnerExcepcionesAsyncTask extends AsyncTask<Void, Void, List<Excepcion>> {
    private Activity activity;
    private Spinner spnExcValue;
    private ProgressBar pbLoader;
    private Exception exception;
    List<Excepcion> excepcionesDb;

    public LoadSpinnerExcepcionesAsyncTask(Activity _activity,
                                           ProgressBar _pbLoader,
                                           Spinner _spnExcValue) {
        try {
            this.activity = _activity;
            this.exception = null;
            this.pbLoader = _pbLoader;
            this.spnExcValue = _spnExcValue;
            this.excepcionesDb = new LinkedList<>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPreExecute() {
        pbLoader.setVisibility(View.VISIBLE);
    }

    @Override
    protected List<Excepcion> doInBackground(Void... voids) {
        try {
            //Cargo las prendas que agrega el user, no las que traigo del server.
            excepcionesDb = WebServicesFabrica.getInstance().getWebServices().ListarExcepciones();
        } catch (Exception ex) {
            exception = ex;
        }
        return excepcionesDb;
    }

    @Override
    protected void onPostExecute(List<Excepcion> excepciones) {
        try {
            if (exception != null)
                throw exception;

            //Cargar spinner
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(activity,
                    android.R.layout.simple_spinner_item, getSpinnerItems(excepcionesDb));
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnExcValue.setAdapter(dataAdapter);

        } catch (Exception ex) {
            Utils.MostrarMensajeException(activity, ex);
            ex.printStackTrace();
        }
        pbLoader.setVisibility(View.GONE);
    }

    private List<String> getSpinnerItems(List<Excepcion> lista) {
        List<String> result = new LinkedList<>();
        result.add(activity.getString(R.string.seleccione_item));
        for(Excepcion exc : lista) {
            result.add(String.valueOf(exc.getid()) + "-" + exc.getNombre());
        }
        return result;
    }


}
