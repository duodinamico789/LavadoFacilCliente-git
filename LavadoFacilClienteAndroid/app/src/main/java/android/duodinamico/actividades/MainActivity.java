package android.duodinamico.actividades;

import android.app.Activity;
import android.content.DialogInterface;
import android.duodinamico.fragments.AltaSolicitudStepOneFragment;
import android.duodinamico.fragments.AltaSolicitudStepTwoFragment;
import android.duodinamico.fragments.ComoUsarAppFragment;
import android.duodinamico.fragments.ModificarClienteFragment;
import android.duodinamico.interfaces.MenuInstanciadoEventListener;
import android.duodinamico.interfaces.NavigateEventListener;
import android.duodinamico.utils.Enumerations;
import android.duodinamico.utils.SessionUsuarioUtils;
import android.duodinamico.utils.Utils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.duodinamico.lavadofacilclienteandroid.R;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {
    static String tag = "MainActivity";
    Menu menu;

    static int currentPosition = -1;
    static boolean userSelectedAltaSolicitud  = false;

    private NavigationDrawerFragment mNavigationDrawerFragment;
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onBackPressed() {
        this.moveTaskToBack(false);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        //Dejamos mediante un booleano que estamos en alta solicitud lavado
        userSelectedAltaSolicitud = (
            Enumerations.Paginas.valueOf(position) == Enumerations.Paginas.ALTA_SOLICITUD_1 ||
            Enumerations.Paginas.valueOf(position) == Enumerations.Paginas.ALTA_SOLICITUD_2);

        boolean currentSelectedIsAltaSolicitud = (
            Enumerations.Paginas.valueOf(currentPosition) == Enumerations.Paginas.ALTA_SOLICITUD_1 ||
            Enumerations.Paginas.valueOf(currentPosition) == Enumerations.Paginas.ALTA_SOLICITUD_2);

        //Si quiere moverse para otra opcion mientras esta realizando un alta solicitud
        //Pedimos confirmacion
        if(currentSelectedIsAltaSolicitud && !userSelectedAltaSolicitud) {
            ShowConfirmationDialogLeavingAltaSolicitud(position);
        }
        else {
            switchToPosition(position);
        }
    }

    private void switchToPosition(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();

        //Las posiciones empiezan en 0
        currentPosition = position;
        switch (Enumerations.Paginas.valueOf(position)) {
            case COMO_USAR_LA_APP:
                //Como usar la App
                fragmentManager.beginTransaction()
                        .replace(R.id.container,
                                ComoUsarAppFragment.singleInstance(position + 1))
                        .commit();
                break;
            case ALTA_SOLICITUD_1:
                //AltaSolicitudStepOneFragment
                fragmentManager.beginTransaction()
                        .replace(R.id.container,
                                AltaSolicitudStepOneFragment.singleInstance(position + 1))
                        .commit();
                mostrarGroupMenu(false, true);
                break;
            case MODIFICAR_CLIENTE:
                //Modificar cliente
                fragmentManager.beginTransaction()
                        .replace(R.id.container,
                                ModificarClienteFragment.singleInstance(position + 1))
                        .commit();
                break;
            case CERRAR_SESION:
                try {
                    ShowConfirmationDialogLogout();
                } catch(Exception ex) {
                    Utils.MostrarMensaje(
                            MainActivity.this,
                            getString(R.string.alert_dialog_error_title), ex.getMessage());
                }
                break;
            case ALTA_SOLICITUD_2:
                //AltaSolicitudStepTwoFragment
                fragmentManager.beginTransaction()
                        .replace(R.id.container,
                                AltaSolicitudStepTwoFragment.singleInstance(position + 1))
                        .commit();
                mostrarGroupMenu(true, true);
                break;
        }
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_como_usar_app);
                break;
            case 2:
            case 6:
                mTitle = getString(R.string.title_alta_solicitud_lavado);
                break;
            case 3:
                mTitle = getString(R.string.title_modificar_cliente);
                break;
            case 4:
                mTitle = getString(R.string.title_logout);
                break;
            case 5:
                mTitle = "5";
                break;
        }
    }

    private void ShowConfirmationDialogLogout() {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.dialog_confirmation_title))
                .setMessage(getString(R.string.logout_dialog_confirmation_message))
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        //Fin de la app
                        try {
                            SessionUsuarioUtils.getInstance(
                                    MainActivity.this.getApplicationContext()).logoutUser();
                        } catch(Exception ex) {
                            Utils.MostrarMensaje(MainActivity.this,
                                                 getString(R.string.alert_dialog_error_title),
                                                 ex.getMessage());
                        }
                    }})
                .setNegativeButton(android.R.string.no, null)
                .show();
    }

    private void ShowConfirmationDialogLeavingAltaSolicitud(final int position) {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.dialog_confirmation_title))
                .setMessage(getString(R.string.leaving_alta_solicitud_confirmation_message))
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        //Fin de la app
                        try {
                            //Accion
                            switchToPosition(position);
                            MainActivity.this.getActionBar().setTitle(mTitle);
                            mostrarGroupMenu(false, false);
                        } catch (Exception ex) {
                            Utils.MostrarMensaje(MainActivity.this,
                                    getString(R.string.alert_dialog_error_title),
                                    ex.getMessage());
                        }
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        mNavigationDrawerFragment.selectItem(currentPosition);
                    }
                })
                .show();
    }
    //mNavigationDrawerFragment

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        try {
            if (!mNavigationDrawerFragment.isDrawerOpen()) {
                // Only show items in the action bar relevant to this screen
                // if the drawer is not showing. Otherwise, let the drawer
                // decide what to show in the action bar.
                if(this.menu == null)
                    this.menu = menu;

                getMenuInflater().inflate(R.menu.main, menu);
                restoreActionBar();
                MenuInstanciadoEvent(null);
                return true;
            }
        } catch (Exception e) {
            Log.e(tag, e.getMessage());
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    //region Mis Eventos ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- --
    public void mostrarGroupMenu(boolean showBefore, boolean showNext) {
        if(menu == null)
            return;

        menu.setGroupVisible(R.id.action_before_group, showBefore);
        menu.setGroupVisible(R.id.action_next_group, showNext);
    }
    //endregion ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- -----

    //region Listeners ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- -----
    private List<MenuInstanciadoEventListener> listeners;

    //Metodos para el manejo del evento personalizado
    public void addMenuInstanciadoEventListener(MenuInstanciadoEventListener toAdd) {
        if(listeners == null)
            listeners = new LinkedList<>();
        listeners.add(toAdd);
    }

    public void MenuInstanciadoEvent(Object args) {
        // Notify everybody that may be interested.
        for (MenuInstanciadoEventListener list : listeners)
            list.MenuInstanciadoEvent(args);
    }
    //endregion ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- -----

    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }
}
