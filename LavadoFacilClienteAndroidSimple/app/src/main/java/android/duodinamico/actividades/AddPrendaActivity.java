package android.duodinamico.actividades;

import android.app.FragmentTransaction;
import android.duodinamico.asynctasks.LoadSpinnerPrendasAsyncTask;
import android.duodinamico.dialogs.CustomDialog;
import android.duodinamico.fragments.AddExcepcionDialogFragment;
import android.duodinamico.lavadofacilclienteandroid.R;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

public class AddPrendaActivity extends AppCompatActivity {
    final String tag = "AddExcepcionDialogFragment";
    ImageButton btnAdd;
    AddExcepcionDialogFragment addExcepcionDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_prenda);

        btnAdd = (ImageButton)findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAdd_Click();
            }
        });

        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this
                .findViewById(android.R.id.content)).getChildAt(0);

        LoadSpinnerPrendasAsyncTask task = new LoadSpinnerPrendasAsyncTask(this, viewGroup);
        task.execute();
    }

    private void btnAdd_Click() {
        try {
            /*final CustomDialog dialog = new CustomDialog(AddPrendaActivity.this);
            dialog.setContentView(R.layout.dialog_add_excepcion);
            dialog.setTitle(R.string.add_excepcion_title);
            dialog.show();*/
            showAddExcepcionDialogFragment();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_prenda, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //Aca se codifica cada botón que hace
        switch(item.getItemId()) {
            case R.id.action_accept:
                Toast.makeText(this.getApplicationContext(), "Se seleccionó action_accept", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_cancel:
                Toast.makeText(this.getApplicationContext(), "Se seleccionó action_cancel", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showAddExcepcionDialogFragment() {
        try {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            addExcepcionDialog = new AddExcepcionDialogFragment();
            addExcepcionDialog.setCancelable(false);
            addExcepcionDialog.setDialogTitle(getString(R.string.select_excepcion_dialog_title));
            addExcepcionDialog.show(fragmentManager, tag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*void showDialog() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        // Create and show the dialog.
        DialogFragment newFragment = MyDialogFragment.newInstance(mStackLevel);
        newFragment.show(ft, "dialog");
    }*/
}
