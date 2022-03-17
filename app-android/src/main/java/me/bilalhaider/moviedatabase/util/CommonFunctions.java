package me.bilalhaider.moviedatabase.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

public class CommonFunctions {

    public static boolean isNetworkAvailable(Context context) {
        try {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = Objects.requireNonNull(connectivityManager).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return false;
    }

    public static Snackbar showSnackbar(View view, String message) {
        try {
            Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
            snackbar.show();
            return snackbar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
