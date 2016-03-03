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
import Entidades.Objetos.Prenda;

public class LoadSpinnerPrendasAsyncTask extends AsyncTask<Void, Void, List<Prenda>> {
    private Spinner spnPrendasValue;
    private ProgressBar pbLoader;
    private Activity activity;
    private Exception exception;
    List<Prenda> prendasDb;

    public LoadSpinnerPrendasAsyncTask(Activity activity, View view) {
        try {
            this.activity = activity;
            this.exception = null;

            if(view != null) {
                this.pbLoader = (ProgressBar) view.findViewById(R.id.pbLoader);
                this.spnPrendasValue = (Spinner) view.findViewById(R.id.spnPrendasValue);
            } else {
                this.pbLoader = (ProgressBar) activity.findViewById(R.id.pbLoader);
                this.spnPrendasValue = (Spinner) activity.findViewById(R.id.spnPrendasValue);
            }

            this.prendasDb = new LinkedList<>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPreExecute() {
        pbLoader.setVisibility(View.VISIBLE);
    }

    @Override
    protected List<Prenda> doInBackground(Void... voids) {
        try {
            //Cargo las prendas que agrega el user, no las que traigo del server.
            prendasDb = WebServicesFabrica.getInstance().getWebServices().ListarPrendas();
        } catch (Exception ex) {
            exception = ex;
        }
        return prendasDb;
    }

    @Override
    protected void onPostExecute(List<Prenda> prendas) {
        try {
            if (exception != null)
                throw exception;

            //Cargar spinner
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(activity,
                    android.R.layout.simple_spinner_item, getSpinnerItems(prendasDb));
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnPrendasValue.setAdapter(dataAdapter);

        } catch (Exception ex) {
            Utils.MostrarMensajeException(activity, ex);
            ex.printStackTrace();
        }
        pbLoader.setVisibility(View.GONE);
    }

    private List<String> getSpinnerItems(List<Prenda> lista) {
        List<String> result = new LinkedList<>();
        result.add(activity.getString(R.string.seleccione_item));
        for(Prenda p : lista) {
            result.add(String.valueOf(p.getIdpda()) + "-" + p.getTipo());
        }
        return result;
    }
}
