package com.gynguide.jandrei.model;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by jandrei on 02/09/16.
 */

public class ExercicioTreinoExecucao {
    public static final String TABLE_NAME_PROJECTS = "exercicio_treino_execucao";

    public static final String FIELD_NAME_ID = "id";
    public static final String FIELD_NAME_NRO_REPETICAO = "nroRepeticao";
    public static final String FIELD_NAME_VLR_PESO = "vlrPeso";
    public static final String FIELD_NAME_NRO_SERIE = "nroSerie";

    public static final String FIELD_NAME_TREINO = "treino";
    public static final String FIELD_NAME_EXERCICIO = "exercicio";


    @DatabaseField(columnName = FIELD_NAME_ID, generatedId = true)
    private int id;

    @DatabaseField(columnName = FIELD_NAME_NRO_REPETICAO)
    private Integer nroRepeticao;

    @DatabaseField(columnName = FIELD_NAME_VLR_PESO)
    private Integer vlrPeso;

    @DatabaseField(columnName = FIELD_NAME_NRO_SERIE)
    private Integer nroSerie;

    @DatabaseField(columnName = FIELD_NAME_TREINO, foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private Treino treino;

    @DatabaseField(columnName = FIELD_NAME_EXERCICIO, foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private Exercicio exercicio;


    public ExercicioTreinoExecucao() {
    }

    /**
     * Getters & Setters
     **/

    public int getId() {
        return id;
    }

    public ExercicioTreinoExecucao setId(final int id) {
        this.id = id;
        return this;
    }


    public Integer getNroRepeticao() {
        return nroRepeticao;
    }

    public ExercicioTreinoExecucao setNroRepeticao(Integer nroRepeticao) {
        this.nroRepeticao = nroRepeticao;
        return this;
    }

    public Integer getVlrPeso() {
        return vlrPeso;
    }

    public ExercicioTreinoExecucao setVlrPeso(Integer vlrPeso) {
        this.vlrPeso = vlrPeso;
        return this;
    }

    public Integer getNroSerie() {
        return nroSerie;
    }

    public ExercicioTreinoExecucao setNroSerie(Integer nroSerie) {
        this.nroSerie = nroSerie;
        return this;
    }

    public Treino getTreino() {
        return treino;
    }

    public ExercicioTreinoExecucao setTreino(Treino treino) {
        this.treino = treino;
        return this;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public ExercicioTreinoExecucao setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
        return this;
    }

    @Override
    public String toString() {
        return this.id + "-" + this.vlrPeso + " - " + nroSerie;
    }

}
