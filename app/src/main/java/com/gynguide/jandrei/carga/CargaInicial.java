package com.gynguide.jandrei.carga;

import android.content.Context;

import com.gynguide.jandrei.DatabaseHelper;
import com.gynguide.jandrei.model.Ciclo;
import com.gynguide.jandrei.model.Exercicio;
import com.gynguide.jandrei.model.ExercicioTreinoExecucao;
import com.gynguide.jandrei.model.Programa;
import com.gynguide.jandrei.model.Semana;
import com.gynguide.jandrei.model.Treino;
import com.j256.ormlite.dao.Dao;

/**
 * Created by jandrei on 02/09/16.
 */
public class CargaInicial {
    private Context context = null;

    private Dao<Programa, Integer> programaDao = null;
    private Dao<Ciclo, Integer> cicloDao = null;
    private Dao<Semana, Integer> semanaDao = null;
    private Dao<Treino, Integer> treinoDao = null;
    private Dao<Exercicio, Integer> exercicioDao = null;
    private Dao<ExercicioTreinoExecucao, Integer> exercicioExecucaoDao = null;


    public CargaInicial(Context context) {
        this.context = context;
        DatabaseHelper db = DatabaseHelper.getInstance(this.context);

        try {
            programaDao = db.getProgramaDao();
            cicloDao = db.getCicloDao();
            semanaDao = db.getSemanaDao();
            treinoDao = db.getTreinoDao();
            exercicioDao = db.getExercicioDao();
            exercicioExecucaoDao = db.getExercicioTreinoExecucaoDao();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void criaCargaInicial() throws Exception{
        if (programaDao.countOf() > 0){
            return;
        }
        Programa programaArnold = new Programa().setTxtPrograma("Programa Arnold");
        programaDao.create(programaArnold);

        Ciclo ciclo1 = new Ciclo().setTxtCiclo("Ciclo 1").setPrograma(programaArnold);
        cicloDao.create(ciclo1);

        Semana semana1 = new Semana().setTxtSemana("Semana 1").setCiclo(ciclo1);
        semanaDao.create(semana1);

        Treino treino1 = new Treino().setTxtTreino("Treino A(Segunda,Quinta)");
        treinoDao.create(treino1);

        Exercicio exercicio1 = new Exercicio().setTxtExercicio("Supino Reto");
        exercicioDao.create(exercicio1);

        ExercicioTreinoExecucao execucao1 = new ExercicioTreinoExecucao()
                .setExercicio(exercicio1)
                .setNroRepeticao(8)
                .setNroSerie(1)
                .setTreino(treino1)
                .setVlrPeso(20);
        ExercicioTreinoExecucao execucao2 = new ExercicioTreinoExecucao()
                .setExercicio(exercicio1)
                .setNroRepeticao(8)
                .setNroSerie(2)
                .setTreino(treino1)
                .setVlrPeso(20);
        ExercicioTreinoExecucao execucao3 = new ExercicioTreinoExecucao()
                .setExercicio(exercicio1)
                .setNroRepeticao(10)
                .setNroSerie(3)
                .setTreino(treino1)
                .setVlrPeso(30);
        ExercicioTreinoExecucao execucao4 = new ExercicioTreinoExecucao()
                .setExercicio(exercicio1)
                .setNroRepeticao(8)
                .setNroSerie(4)
                .setTreino(treino1)
                .setVlrPeso(30);

        exercicioExecucaoDao.create(execucao1);
        exercicioExecucaoDao.create(execucao2);
        exercicioExecucaoDao.create(execucao3);
        exercicioExecucaoDao.create(execucao4);

        //-------------------------------------------------------------------
        Programa programaPhisical = new Programa().setTxtPrograma("Programa Phisical");
        programaDao.create(programaPhisical);

        Ciclo ciclo2 = new Ciclo().setTxtCiclo("Ciclo 1").setPrograma(programaArnold);
        cicloDao.create(ciclo2);

        Semana semana2 = new Semana().setTxtSemana("Semana 1").setCiclo(ciclo1);
        semanaDao.create(semana2);

        Treino treino2 = new Treino().setTxtTreino("Treino A(Segunda,Quinta)");
        treinoDao.create(treino2);

        Exercicio exercicio2 = new Exercicio().setTxtExercicio("Supino Reto");
        exercicioDao.create(exercicio2);

        ExercicioTreinoExecucao execucao11 = new ExercicioTreinoExecucao()
                .setExercicio(exercicio2)
                .setNroRepeticao(8)
                .setNroSerie(1)
                .setTreino(treino2)
                .setVlrPeso(20);
        ExercicioTreinoExecucao execucao22 = new ExercicioTreinoExecucao()
                .setExercicio(exercicio2)
                .setNroRepeticao(8)
                .setNroSerie(2)
                .setTreino(treino2)
                .setVlrPeso(20);
        ExercicioTreinoExecucao execucao33 = new ExercicioTreinoExecucao()
                .setExercicio(exercicio2)
                .setNroRepeticao(10)
                .setNroSerie(3)
                .setTreino(treino2)
                .setVlrPeso(30);
        ExercicioTreinoExecucao execucao44 = new ExercicioTreinoExecucao()
                .setExercicio(exercicio2)
                .setNroRepeticao(8)
                .setNroSerie(4)
                .setTreino(treino2)
                .setVlrPeso(30);

        exercicioExecucaoDao.create(execucao11);
        exercicioExecucaoDao.create(execucao22);
        exercicioExecucaoDao.create(execucao33);
        exercicioExecucaoDao.create(execucao44);

    }

}
