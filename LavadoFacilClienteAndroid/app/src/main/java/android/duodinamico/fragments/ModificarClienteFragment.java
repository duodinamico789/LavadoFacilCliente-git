package android.duodinamico.fragments;

import android.app.Activity;
import android.duodinamico.actividades.MainActivity;
import android.duodinamico.interfaces.MenuInstanciadoEventListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.duodinamico.lavadofacilclienteandroid.R;

public class ModificarClienteFragment extends Fragment implements MenuInstanciadoEventListener {
    MainActivity parent;
    private static final String ARG_SECTION_NUMBER = "section_number";

    //region Singleton
    private static ModificarClienteFragment instance = null;
    protected ModificarClienteFragment() {
        // Exists only to defeat instantiation.
    }
    public static ModificarClienteFragment getInstance() {
        if(instance == null) {
            instance = new ModificarClienteFragment();
        }
        return instance;
    }
    //endregion

    ////Variables
    //private ProgressBar pbarLoading;
    //private ListView lvEstaciones;
    //private AsynctaskGetEstaciones tarea;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_modificar_cliente, container, false);

        //Agregamos esta instancia como escucha del evento del menu
        parent = (MainActivity)this.getActivity();
        parent.addMenuInstanciadoEventListener(this);

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

    public static ModificarClienteFragment singleInstance(int sectionNumber) {
        ModificarClienteFragment fragment = getInstance();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        if(!fragment.isVisible()) {
            fragment.setArguments(args);
        }
        return fragment;
    }

    @Override
    public void MenuInstanciadoEvent(Object args) {
        parent.mostrarGroupMenu(false, false);
    }
}
