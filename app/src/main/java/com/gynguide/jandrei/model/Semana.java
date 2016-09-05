package com.gynguide.jandrei.model;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by jandrei on 02/09/16.
 */

public class Semana {
    public static final String TABLE_NAME_PROJECTS = "semana";

    public static final String FIELD_NAME_ID = "id";
    public static final String FIELD_NAME_NAME = "txtSemana";
    public static final String FIELD_NAME_CICLO = "ciclo";

    @DatabaseField(columnName = FIELD_NAME_ID, generatedId = true)
    private int id;

    @DatabaseField(columnName = FIELD_NAME_NAME)
    private String txtSemana;

    @DatabaseField(columnName = FIELD_NAME_CICLO, foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private Ciclo ciclo;

    public Semana() {
    }

    /**
     * Getters & Setters
     **/

    public int getId() {
        return id;
    }

    public Semana setId(final int id) {
        this.id = id;
        return this;
    }

    public String getTxtSemana() {
        return txtSemana;
    }

    public Semana setTxtSemana(final String name) {
        txtSemana = name;
        return this;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public Semana setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
        return this;
    }

    @Override
    public String toString() {
        return this.id + "-" + this.txtSemana;
    }

}
