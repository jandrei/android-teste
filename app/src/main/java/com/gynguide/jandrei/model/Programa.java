package com.gynguide.jandrei.model;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by jandrei on 02/09/16.
 */

public class Programa {
    public static final String TABLE_NAME_PROJECTS = "programa";

    public static final String FIELD_NAME_ID = "id";
    public static final String FIELD_NAME_NAME = "txtPrograma";

    @DatabaseField(columnName = FIELD_NAME_ID, generatedId = true)
    private int id;

    @DatabaseField(columnName = FIELD_NAME_NAME)
    private String txtPrograma;

    public Programa() {
    }

    /**
     * Getters & Setters
     **/

    public int getId() {
        return id;
    }

    public Programa setId(final int id) {
        this.id = id;
        return this;
    }

    public String getTxtPrograma() {
        return txtPrograma;
    }

    public Programa setTxtPrograma(final String name) {
        txtPrograma = name;
        return this;
    }

    @Override
    public String toString() {
        return this.id + "-" + this.txtPrograma;
    }

}
