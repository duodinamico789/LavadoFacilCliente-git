package android.duodinamico.dialogs;

/**
 * Created by Usuario on 29/2/2016.
 */
import android.app.Dialog;
import android.content.Context;
import android.duodinamico.lavadofacilclienteandroid.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CustomDialog extends Dialog {
    Button btnAceptar;
    Button btnCancelar;

    public CustomDialog(Context context) {
        super(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_add_excepcion);

        btnAceptar = (Button)findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAceptar_Click();
            }
        });
        btnCancelar = (Button)findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCancelar_Click();
            }
        });
    }

    private void btnCancelar_Click() {
        Toast.makeText(getContext(), "Aceptado!", Toast.LENGTH_SHORT).show();
        dismiss();
    }

    private void btnAceptar_Click() {
        Toast.makeText(getContext(), "Cancelado!", Toast.LENGTH_SHORT).show();
        dismiss();
    }
}