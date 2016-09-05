package com.gynguide.jandrei;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.gynguide.jandrei.model.Ciclo;
import com.gynguide.jandrei.model.Exercicio;
import com.gynguide.jandrei.model.ExercicioTreinoExecucao;
import com.gynguide.jandrei.model.Programa;
import com.gynguide.jandrei.model.Semana;
import com.gynguide.jandrei.model.Treino;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "ormlite_gynguide.db";
    private static final int DATABASE_VERSION = 16;

    private Dao<Programa, Integer> programaDao = null;
    private Dao<Ciclo, Integer> cicloDao = null;
    private Dao<Semana, Integer> semanaDao = null;
    private Dao<Treino, Integer> treinoDao = null;
    private Dao<Exercicio, Integer> exercicioDao = null;
    private Dao<ExercicioTreinoExecucao, Integer> exercicioExecucaoDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Programa.class);
            TableUtils.createTable(connectionSource, Ciclo.class);
            TableUtils.createTable(connectionSource, Semana.class);
            TableUtils.createTable(connectionSource, Treino.class);
            TableUtils.createTable(connectionSource, Exercicio.class);
            TableUtils.createTable(connectionSource, ExercicioTreinoExecucao.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Programa.class, true);
            TableUtils.dropTable(connectionSource, Ciclo.class, true);
            TableUtils.dropTable(connectionSource, Semana.class, true);
            TableUtils.dropTable(connectionSource, Treino.class, true);
            TableUtils.dropTable(connectionSource, Exercicio.class, true);
            TableUtils.dropTable(connectionSource, ExercicioTreinoExecucao.class, true);

            onCreate(db);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Dao<Programa, Integer> getProgramaDao() throws SQLException {
        if (programaDao == null) {
            programaDao = getDao(Programa.class);
        }
        return programaDao;
    }

    public Dao<Ciclo, Integer> getCicloDao() throws SQLException {
        if (cicloDao == null) {
            cicloDao = getDao(Ciclo.class);
        }
        return cicloDao;
    }

    public Dao<Semana, Integer> getSemanaDao() throws SQLException {
        if (semanaDao == null) {
            semanaDao = getDao(Semana.class);
        }
        return semanaDao;
    }

    public Dao<Treino, Integer> getTreinoDao() throws SQLException {
        if (treinoDao == null) {
            treinoDao = getDao(Treino.class);
        }
        return treinoDao;
    }

    public Dao<Exercicio, Integer> getExercicioDao() throws SQLException {
        if (exercicioDao == null) {
            exercicioDao = getDao(Exercicio.class);
        }
        return exercicioDao;
    }

    public Dao<ExercicioTreinoExecucao, Integer> getExercicioTreinoExecucaoDao() throws SQLException {
        if (exercicioExecucaoDao == null) {
            exercicioExecucaoDao = getDao(ExercicioTreinoExecucao.class);
        }
        return exercicioExecucaoDao;
    }


    @Override
    public void close() {
        programaDao = null;
        cicloDao = null;
        semanaDao = null;
        treinoDao = null;
        exercicioDao = null;
        exercicioExecucaoDao = null;

        super.close();
    }

    private static DatabaseHelper sDatabaseHelper;

    public static DatabaseHelper getInstance(Context context) {
        if (sDatabaseHelper == null) {
            sDatabaseHelper = new DatabaseHelper(context.getApplicationContext());
        }

        return sDatabaseHelper;
    }

//    public static DatabaseHelper getInstance() {
//        return sDatabaseHelper;
//    }
}