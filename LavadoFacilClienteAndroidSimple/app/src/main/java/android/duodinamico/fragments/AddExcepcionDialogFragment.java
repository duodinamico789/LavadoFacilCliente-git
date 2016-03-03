package android.duodinamico.fragments;

import android.app.DialogFragment;
import android.duodinamico.actividades.AddPrendaActivity;
import android.duodinamico.asynctasks.LoadSpinnerExcepcionesAsyncTask;
import android.duodinamico.asynctasks.LoadSpinnerPrendasAsyncTask;
import android.duodinamico.lavadofacilclienteandroid.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.LinkedList;

import Entidades.Objetos.Excepcion;

public class AddExcepcionDialogFragment extends DialogFragment {
    private String DialogboxTitle;
    private Spinner spnExcepciones;
    private Button btnAceptar;
    private Button btnCancelar;

    //---empty constructor required
    public AddExcepcionDialogFragment() {

    }
    //---set the title of the dialog window
    public void setDialogTitle(String title) {
        DialogboxTitle = title;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(
                R.layout.dialog_add_excepcion, container);

        try {
            //---get the EditText and Button views
            spnExcepciones = (Spinner) view.findViewById(R.id.spnExcValue);
            btnAceptar = (Button) view.findViewById(R.id.btnAceptar);
            btnCancelar = (Button) view.findViewById(R.id.btnCancelar);

            //---Manejador de eventos para botones
            btnAceptar.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) { btnAceptar_Click(); }
            });
            btnCancelar.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    btnCancelar_Click();
                }
            });

            spnExcepciones.requestFocus();

            //---set the title for the dialog
            getDialog().setTitle(DialogboxTitle);

            LoadSpinnerExcepcionesAsyncTask task =
                    new LoadSpinnerExcepcionesAsyncTask
                        (this.getActivity(),
                        (ProgressBar)view.findViewById(R.id.pbLoader),
                        (Spinner)view.findViewById(R.id.spnExcValue));
            task.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    private void btnCancelar_Click() {
        //todo: codigo cuando cancelamos
        Toast.makeText(this.getActivity().getApplicationContext(), "Se seleccionó cancelar", Toast.LENGTH_SHORT).show();
        //---dismiss the alert
        dismiss();
    }

    private void btnAceptar_Click() {
        //todo: codigo cuando aceptamos
        Toast.makeText(this.getActivity().getApplicationContext(), "Se seleccionó accept", Toast.LENGTH_SHORT).show();
        //---dismiss the alert
        dismiss();
    }
}
