package com.gynguide.jandrei.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by jandrei on 02/09/16.
 */
public class Mensagem {
    public static void erro(Context context, Exception e) {
        Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG).show();
    }

    public static void mensagem(Context context, Object obj) {
        Toast.makeText(context,obj.toString(),Toast.LENGTH_LONG).show();
    }
}
