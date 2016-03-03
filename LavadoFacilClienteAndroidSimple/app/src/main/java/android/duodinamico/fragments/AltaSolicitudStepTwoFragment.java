package android.duodinamico.fragments;

import android.app.Activity;
import android.content.Intent;
import android.duodinamico.actividades.AddPrendaActivity;
import android.duodinamico.actividades.MainActivity;
import android.duodinamico.asynctasks.LoadSpinnerPrendasAsyncTask;
import android.duodinamico.interfaces.MenuInstanciadoEventListener;
import android.duodinamico.utils.Utils;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.duodinamico.lavadofacilclienteandroid.R;
import android.widget.ImageButton;

import java.util.LinkedList;
import java.util.List;

import Entidades.Datatypes.PrendaExtended;

public class AltaSolicitudStepTwoFragment extends Fragment implements MenuInstanciadoEventListener {
    private static final String ARG_SECTION_NUMBER = "section_number";
    MainActivity parent;
    static String tag = "AltaSolicitudStepTwoFragment";
    ImageButton btnAddPrenda;

    //Estas son las prendas que seleccionó el usuario
    List<PrendaExtended> prendas;

    public List<PrendaExtended> getPrendasUser() {
        return prendas;
    }

    //region Singleton
    private static AltaSolicitudStepTwoFragment instance = null;
    public AltaSolicitudStepTwoFragment() {
        // Exists only to defeat instantiation.
    }
    public static AltaSolicitudStepTwoFragment getInstance() {
        if(instance == null) {
            instance = new AltaSolicitudStepTwoFragment();
        }
        return instance;
    }
    //endregion

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try {
            View rootView = inflater.inflate(R.layout.fragment_alta_solicitud_step_two, container, false);

            //Agregamos esta instancia como escucha del evento del menu
            parent = (MainActivity)this.getActivity();
            parent.addMenuInstanciadoEventListener(this);

            btnAddPrenda = (ImageButton)rootView.findViewById(R.id.btnAddPrenda);
            btnAddPrenda.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    btnAddPrenda_Click(view);
                }
            });

            prendas = new LinkedList<>();

            return rootView;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    private void btnAddPrenda_Click(View v) {
        try {
            //Creamos intent
            Intent intent = new Intent(parent, AddPrendaActivity.class);
            startActivity(intent);
        } catch(Exception ex) {
            Utils.MostrarMensaje(parent, getString(R.string.alert_dialog_error_title), ex.getMessage());
        }
    }


    @Override
    public void onAttach(Activity activity) {
        try {
            super.onAttach(activity);

            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        } catch(Exception ex) {
            Log.e("Exception", "Exception in attaching fragment to activity");
        }
    }

    public static AltaSolicitudStepTwoFragment singleInstance(int sectionNumber) {
        AltaSolicitudStepTwoFragment fragment = getInstance();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        if(!fragment.isVisible()) {
            fragment.setArguments(args);
        }
        return fragment;
    }

    @Override
    public void MenuInstanciadoEvent(Object args) {
        parent.mostrarGroupMenu(true, true);
    }
}
