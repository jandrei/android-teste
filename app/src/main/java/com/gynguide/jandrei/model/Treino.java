package com.gynguide.jandrei.model;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by jandrei on 02/09/16.
 */

public class Treino {
    public static final String TABLE_NAME_PROJECTS = "treino";

    public static final String FIELD_NAME_ID = "id";
    public static final String FIELD_NAME_NAME = "txtTreino";
    public static final String FIELD_NAME_SEMANA = "semana";

    @DatabaseField(columnName = FIELD_NAME_ID, generatedId = true)
    private int id;

    @DatabaseField(columnName = FIELD_NAME_NAME)
    private String txtTreino;

    @DatabaseField(columnName = FIELD_NAME_SEMANA, foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private Semana semana;

    public Treino() {
    }

    /**
     * Getters & Setters
     **/

    public int getId() {
        return id;
    }

    public Treino setId(final int id) {
        this.id = id;
        return this;
    }

    public String getTxtTreino() {
        return txtTreino;
    }

    public Treino setTxtTreino(final String name) {
        txtTreino = name;
        return this;
    }

    public Semana getSemana() {
        return semana;
    }

    public Treino setSemana(Semana semana) {
        this.semana = semana;
        return this;
    }

    @Override
    public String toString() {
        return this.id + "-" + this.txtTreino;
    }

}
