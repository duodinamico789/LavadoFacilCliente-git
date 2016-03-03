package android.duodinamico.fragments;

import android.app.Activity;
import android.duodinamico.actividades.MainActivity;
import android.duodinamico.interfaces.MenuInstanciadoEventListener;
import android.duodinamico.utils.SessionUsuarioUtils;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.duodinamico.lavadofacilclienteandroid.R;
import android.widget.TextView;

import Entidades.Objetos.Cliente;

public class AltaSolicitudStepOneFragment extends Fragment implements MenuInstanciadoEventListener {
    private static final String ARG_SECTION_NUMBER = "section_number";
    MainActivity parent;
    static String tag = "AltaSolicitudStepOneFragment";

    //region Singleton
    private static AltaSolicitudStepOneFragment instance = null;
    private TextView txtValorCedula;
    private TextView txtValorNombre;
    private TextView txtValorCelular;
    private TextView txtValorTelefono;
    private TextView txtValorBarrio;
    private TextView txtValorDir;
    private TextView txtValorCiudad;

    public AltaSolicitudStepOneFragment() {
        // Exists only to defeat instantiation.
    }
    public static AltaSolicitudStepOneFragment getInstance() {
        if(instance == null) {
            instance = new AltaSolicitudStepOneFragment();
        }
        return instance;
    }
    //endregion

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_alta_solicitud_step_one, container, false);

        //Agregamos esta instancia como escucha del evento del menu
        parent = (MainActivity)this.getActivity();
        parent.addMenuInstanciadoEventListener(this);

        try {
            Cliente c = SessionUsuarioUtils.getInstance(parent.getApplicationContext()).getDetailsCliente();
            txtValorCedula = (TextView)rootView.findViewById(R.id.txtValorCedula);
            txtValorCedula.setText(c.getCedula());
            txtValorNombre = (TextView)rootView.findViewById(R.id.txtValorNombre);
            txtValorNombre.setText(c.getNombre());
            txtValorCelular = (TextView)rootView.findViewById(R.id.txtValorCelular);
            txtValorCelular.setText(c.getCelular());
            txtValorTelefono = (TextView)rootView.findViewById(R.id.txtValorTelefono);
            txtValorTelefono.setText(c.getTelefono());
            txtValorBarrio = (TextView)rootView.findViewById(R.id.txtValorBarrio);
            txtValorBarrio.setText(c.getUbicacion().getBarrio());
            txtValorDir = (TextView)rootView.findViewById(R.id.txtValorDir);
            txtValorDir.setText(c.getUbicacion().getDireccion());
            txtValorCiudad = (TextView)rootView.findViewById(R.id.txtValorCiudad);
            txtValorCiudad.setText(c.getUbicacion().getCiudad());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rootView;
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

    public static AltaSolicitudStepOneFragment singleInstance(int sectionNumber) {
        AltaSolicitudStepOneFragment fragment = getInstance();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        if(!fragment.isVisible()) {
            fragment.setArguments(args);
        }
        return fragment;
    }

    @Override
    public void MenuInstanciadoEvent(Object args) {
        parent.mostrarGroupMenu(false, true);
    }
}
