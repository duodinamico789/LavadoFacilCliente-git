package android.duodinamico.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.duodinamico.lavadofacilclienteandroid.R;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.NetworkOnMainThreadException;
import android.util.Log;
import android.view.Menu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ConnectException;

import Entidades.Constantes;

public class Utils {
    private static final String tag = "Utils";

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
            Log.e(tag, ex.getMessage(), ex);
        }
    }

    public static void MostrarMensajeException(Activity activity, Exception exception) {
        //Utiliza AlertDialog para mostrar mensajes de cualquier tipo.
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setCancelable(true);

            builder.setTitle("Error: ");

            String message = getExceptionMessage(activity, exception);
            builder.setMessage(message);

            builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();
        } catch(Exception ex) {
            Log.e(tag, ex.getMessage(), ex);
        }
    }

    private static String getExceptionMessage(Activity activity, Exception exception) {
        String e = String.valueOf(exception.getClass().getSimpleName());

        if(exception instanceof NullPointerException) {
            return activity.getString(R.string.exception_nullpointerexception);
        }
        else if(exception instanceof NetworkOnMainThreadException) {
            return activity.getString(R.string.exception_networkonmainthreadexception);
        }
        else if(exception instanceof ConnectException) {
            return activity.getString(R.string.exception_connectexception);
        }
        else {
            return exception.getMessage();
        }
    }

    /*private static boolean isNetworkAvailable(Activity activity) {
        try {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Exception ex) {
            Log.e(tag, ex.getMessage(), ex);
            throw ex;
        }
    }*/
}
