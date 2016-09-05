package com.gynguide.jandrei.model;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by jandrei on 02/09/16.
 */

public class Ciclo {
    public static final String TABLE_NAME_PROJECTS = "ciclo";

    public static final String FIELD_NAME_ID = "id";
    public static final String FIELD_NAME_NAME = "txtCiclo";
    public static final String FIELD_NAME_PROGRAMA = "programa";

    @DatabaseField(columnName = FIELD_NAME_ID, generatedId = true)
    private int id;

    @DatabaseField(columnName = FIELD_NAME_NAME)
    private String txtCiclo;

    @DatabaseField(columnName = FIELD_NAME_PROGRAMA, foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private Programa programa;

    public Ciclo() {
    }

    /**
     * Getters & Setters
     **/

    public int getId() {
        return id;
    }

    public Ciclo setId(final int id) {
        this.id = id;
        return this;
    }

    public String getTxtCiclo() {
        return txtCiclo;
    }

    public Ciclo setTxtCiclo(final String name) {
        txtCiclo = name;
        return this;
    }

    public Programa getPrograma() {
        return programa;
    }

    public Ciclo setPrograma(Programa programa) {
        this.programa = programa;
        return this;
    }

    @Override
    public String toString() {
        return this.id + "-" + this.txtCiclo;
    }

}
