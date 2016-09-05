package com.gynguide.jandrei.model;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by jandrei on 02/09/16.
 */

public class Exercicio {
    public static final String TABLE_NAME_PROJECTS = "exercicio";

    public static final String FIELD_NAME_ID = "id";
    public static final String FIELD_NAME_NAME = "txtExercicio";

    @DatabaseField(columnName = FIELD_NAME_ID, generatedId = true)
    private int id;

    @DatabaseField(columnName = FIELD_NAME_NAME)
    private String txtExercicio;

    public Exercicio() {
    }

    /**
     * Getters & Setters
     **/

    public int getId() {
        return id;
    }

    public Exercicio setId(final int id) {
        this.id = id;
        return this;
    }

    public String getTxtExercicio() {
        return txtExercicio;
    }

    public Exercicio setTxtExercicio(final String name) {
        txtExercicio = name;
        return this;
    }

    @Override
    public String toString() {
        return this.id + "-" + this.txtExercicio;
    }

}
