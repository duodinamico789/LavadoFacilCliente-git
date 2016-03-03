package android.duodinamico.listadapters;

import android.app.Activity;
import android.app.Dialog;
import android.duodinamico.lavadofacilclienteandroid.R;
import android.duodinamico.utils.Utils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;
import Entidades.Datatypes.PrendaExtended;

public class PrendasListAdapter extends ArrayAdapter<PrendaExtended> implements NumberPicker.OnValueChangeListener {
    private final int layoutResourceId;
    //Variables que se van a utilizar
    private List<PrendaExtended> items;
    private Activity activity;

    private TextView txtNomPrenda;
    private TextView txtCantidad;
    private RelativeLayout rlCantColumna;
    //private RelativeLayout rlRowContent;

    //Constructor
    public PrendasListAdapter(Activity _activity, int _layoutResourceId, List<PrendaExtended> _items) {
        //Constructor del List Adapter
        super(_activity.getApplicationContext(), _layoutResourceId, _items);
        this.layoutResourceId = _layoutResourceId;
        this.activity = _activity;
        this.items = _items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi;
                vi = LayoutInflater.from(activity.getApplicationContext());
                v = vi.inflate(R.layout.list_item_datos_prendas, null);
            }

            final PrendaExtended prendaExt = getItem(position);
            if (prendaExt != null) {

                //region Carga de datos
                txtNomPrenda = (TextView) v.findViewById(R.id.txtNomPrenda);
                txtCantidad = (TextView) v.findViewById(R.id.txtCantidad);
                //rlRowContent = (RelativeLayout) v.findViewById(R.id.rlRowContent);
                rlCantColumna = (RelativeLayout) v.findViewById(R.id.rlCantColumna);

                //Obtenemos los valores de x registro
                String nomPrenda = String.valueOf(prendaExt.getPrenda().getTipo());
                int cantidad = prendaExt.getCantPrendas();

                //Cargamos en respectivos TextViews
                if (nomPrenda != null) {
                    txtNomPrenda.setText(nomPrenda);
                }
                txtCantidad.setText(String.valueOf(cantidad));


                rlCantColumna.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showNumberSelectionDialog(prendaExt.getIndex());
                    }
                });
                //endregion
            }

            //Retornamos la vista
            return v;
        } catch(Exception es) {
            Utils.MostrarMensajeException(activity, es);
            return null;
        }
    }

    public void showNumberSelectionDialog(final int index)
    {
        try {
            final Dialog d = new Dialog(PrendasListAdapter.this.activity);
            d.setTitle(R.string.seleccione_cantidad);
            d.setContentView(R.layout.dialog_select_number_prendas);
            Button b1 = (Button) d.findViewById(R.id.button1);
            Button b2 = (Button) d.findViewById(R.id.button2);
            final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPicker1);
            np.setMaxValue(50); // max value 50
            np.setMinValue(0);   // min value 0
            np.setWrapSelectorWheel(false);
            np.setOnValueChangedListener(this);
            b1.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    for(PrendaExtended pe : items) {
                        if(pe.getIndex() == index)
                            pe.setCantPrendas(np.getValue()); //set the value to object
                    }
                    //Refrescamos el listView
                    notifyDataSetChanged();
                    d.dismiss();
                }
            });
            b2.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    d.dismiss(); // dismiss the dialog
                }
            });
            d.show();
        } catch (Exception e) {
            Utils.MostrarMensajeException(activity, e);
            e.printStackTrace();
        }
    }

    @Override
    public void onValueChange(NumberPicker numberPicker, int i, int i1) {

    }

    /*@Override
    public void onValueChange(NumberPicker numberPicker, int oldValue, int newValue) {
        numberOfPrendasSelected = i1;
        for(PrendaExtended pe : items) {
            if(pe.getIndex() == )
        }
    }*/
}

