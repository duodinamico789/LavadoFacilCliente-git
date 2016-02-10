package android.duodinamico.listadapters;

import android.app.Activity;
import android.duodinamico.lavadofacilclienteandroid.R;
import android.duodinamico.utils.Utils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;
import Entidades.Datatypes.PrendaExtended;

public class PrendasListAdapter extends ArrayAdapter<PrendaExtended> {
    //Variables que se van a utilizar
    private List<PrendaExtended> items;
    private int layoutResourceId;
    private Activity activity;

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
                TextView txtNomPrenda       = (TextView) v.findViewById(R.id.txtNomPrenda);
                TextView txtCantidad        = (TextView) v.findViewById(R.id.txtCantidad);
                RelativeLayout rlRowContent = (RelativeLayout) v.findViewById(R.id.rlRowContent);

                //Obtenemos los valores de x registro
                String nomPrenda = String.valueOf(prendaExt.getPrenda().getTipo());
                int cantidad = prendaExt.getCantPrendas();

                //Cargamos en respectivos TextViews
                if (nomPrenda != null) {
                    txtNomPrenda.setText(nomPrenda);
                }
                txtCantidad.setText(cantidad);

                //endregion

                //todo: Ejecutar una accion cuando se haga click en la fila
                /*if(rlRowContent != null) {
                    rlRowContent.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                //Implementar algun codigo
                            } catch(Exception ex) {
                                ex.getMessage();
                            }
                        }
                    });
                }*/
            }

            //Retornamos la vista
            return v;
        } catch(Exception es) {
            Utils.MostrarMensajeException(activity, es);
            return null;
        }
    }
}

