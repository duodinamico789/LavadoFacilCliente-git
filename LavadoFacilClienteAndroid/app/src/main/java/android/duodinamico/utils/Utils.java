package android.duodinamico.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.duodinamico.lavadofacilclienteandroid.R;
import android.util.Log;
import android.view.Menu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Entidades.Constantes;

public class Utils {
    public static void MostrarMensaje(Activity activity, String title, String message) {
        //Utiliza AlertDialog para mostrar mensajes de cualquier tipo.
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setCancelable(true);
            builder.setTitle(title);
            builder.setMessage(message);
            builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();
        } catch(Exception ex) {
            Log.i("BRUNO", "[LAVADOFACIL-EXCEPTION]" + ex.getMessage());
        }
    }

    public static void MostrarMensajeException(Activity activity, Exception exception) {
        //Utiliza AlertDialog para mostrar mensajes de cualquier tipo.
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setCancelable(true);

            builder.setTitle("Error: ");

            String message;
            if(exception instanceof NullPointerException) {
                message = activity.getString(R.string.exception_null_pointer);
            } else {
                message = exception.getMessage();
            }
            builder.setMessage(message);

            builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();
        } catch(Exception ex) {
            Log.i("BRUNO", "[LAVADOFACIL-EXCEPTION]" + ex.getMessage());
        }
    }

    //Este metodo no fue probado. Probarlo cuando se pueda
    /*public static void Loggear(String text) {
        File logFile = new File("sdcard/log.file");
        if (!logFile.exists())
        {
            try
            {
                logFile.createNewFile();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        try
        {
            //BufferedWriter for performance, true to set append to file flag
            BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true));
            buf.append(text);
            buf.newLine();
            buf.close();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/
}
