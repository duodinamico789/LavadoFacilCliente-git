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

public class ComoUsarAppFragment extends Fragment implements MenuInstanciadoEventListener {
    private static final String ARG_SECTION_NUMBER = "section_number";
    MainActivity parent;

    //region Singleton
    private static ComoUsarAppFragment instance = null;
    protected ComoUsarAppFragment() {
        // Exists only to defeat instantiation.
    }
    public static ComoUsarAppFragment getInstance() {
        if(instance == null) {
            instance = new ComoUsarAppFragment();
        }
        return instance;
    }
    //endregion

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_como_usar_app, container, false);

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

    public static ComoUsarAppFragment singleInstance(int sectionNumber) {
        ComoUsarAppFragment fragment = getInstance();
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
