package com.gynguide.jandrei;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.gynguide.jandrei.adapters.ProgramaAdapter;
import com.gynguide.jandrei.carga.CargaInicial;
import com.gynguide.jandrei.model.Programa;
import com.j256.ormlite.dao.Dao;


public class MainActivity extends Activity {

    private ProgramaAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Script", "onCreate()");
        Dao<Programa,Integer> dao = null;
        try {
            DatabaseHelper.getInstance(this);
            new CargaInicial(this).criaCargaInicial();
            dao = DatabaseHelper.getInstance(this).getProgramaDao();
            adaptador = new ProgramaAdapter(getApplication(),R.layout.layout_programa_lista,dao.queryBuilder().orderBy(Programa.FIELD_NAME_NAME,true).query());
        } catch (Exception e) {
            e.printStackTrace();
        }

        ListView listView = (ListView)findViewById(R.id.listView1);
        listView.setAdapter(adaptador);
        listView.setOnItemClickListener(adaptador);
        
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("Script", "onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("Script", "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("Script", "onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("Script", "onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("Script", "onDestroy()");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("Script", "onSaveInstanceState()");
    }
}
