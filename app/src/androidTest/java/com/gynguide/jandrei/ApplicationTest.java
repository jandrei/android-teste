package com.gynguide.jandrei;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.gynguide.jandrei.model.Programa;
import com.j256.ormlite.dao.Dao;

import java.util.List;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }


    public void testaSeIncluiPrograma() throws Exception {
        DatabaseHelper db = DatabaseHelper.getInstance(this.getContext());
        Dao<Programa, Integer> pDAo = db.getProgramaDao();

        Programa p = new Programa().setTxtPrograma("teste123");
        pDAo.create(p);

        assertTrue(p.getId() > 0);
    }

    public void testeSeConsultaPrograma() throws Exception {
        DatabaseHelper db = DatabaseHelper.getInstance(this.getContext());
        Dao<Programa, Integer> pDAo = db.getProgramaDao();

        Programa p = new Programa().setTxtPrograma("teste123");
        List<Programa> lista = pDAo.queryForEq(Programa.FIELD_NAME_NAME, "teste123");

        assertTrue(lista.size() > 0);
    }

    public void testeSeExecluiPrograma() throws Exception {
        DatabaseHelper db = DatabaseHelper.getInstance(this.getContext());
        Dao<Programa, Integer> pDAo = db.getProgramaDao();

        pDAo.deleteBuilder().delete();

        Programa p = new Programa().setTxtPrograma("teste123");
        List<Programa> lista = pDAo.queryForEq(Programa.FIELD_NAME_NAME, "teste123");

        assertTrue(lista.size() == 0);
    }


}