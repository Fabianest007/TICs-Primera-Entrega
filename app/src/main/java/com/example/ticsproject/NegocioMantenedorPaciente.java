package com.example.ticsproject;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class NegocioMantenedorPaciente extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "clinica.db";
    private static final String PACIENTE_TABLE = "CREATE TABLE pacientes (" +
            "rut TEXT PRIMARY KEY UNIQUE, "+
            "nombres TEXT NOT NULL, " +
            "apellido_paterno TEXT NOT NULL, " +
            "apellido_materno TEXT NOT NULL)";

    public NegocioMantenedorPaciente(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PACIENTE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + PACIENTE_TABLE + "'");
    }

    //CRUD PACIENTE

    public void insertPaciente(Paciente paciente){
        SQLiteDatabase db = getWritableDatabase();

        if(db != null){
            String querySQL = "INSERT INTO pacientes " +
                    "(rut, nombres, apellido_paterno, apellido_materno) VALUES ('" +
                    paciente.getRut() + "','"+
                    paciente.getNombres() + "','"+
                    paciente.getApellido_paterno() + "','"+
                    paciente.getApellido_materno() + "');";
            db.execSQL(querySQL);
        }
    }

    public void updatePaciente(Paciente paciente){
        SQLiteDatabase db = getWritableDatabase();

        if(db != null){
            String querySQL = "UPDATE pacientes " +
                    " SET " +
                    " nombres = '" + paciente.getNombres() + "'," +
                    " apellido_paterno = '" + paciente.getApellido_paterno() + "'," +
                    " apellido_materno = '" + paciente.getApellido_materno() +
                    "' WHERE rut = '" + paciente.getRut()+"';";
            db.execSQL(querySQL);
        }
    }

    public void deletePaciente(String rut){
        SQLiteDatabase db = getWritableDatabase();

        if(db != null){
            String querySQL = "DELETE FROM pacientes " +
                    " WHERE rut = '" + rut+"';";
            db.execSQL(querySQL);
        }
    }

    public Paciente readPaciente(String rut){
        SQLiteDatabase db = getWritableDatabase();

        if(db != null){

            Cursor cursor = db.rawQuery("SELECT * FROM pacientes " +
                    " WHERE rut = '" + rut+"';",null);

            //Si el cursor tiene datos, se mueve al primer registro


            if(!cursor.moveToFirst()){
                return null;
            }

            Paciente paciente = new Paciente(cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3));
            return paciente;
        }
        return null;
    }

    public List<Paciente> readAllPacientes(){
        SQLiteDatabase db = getWritableDatabase();
        List<Paciente> listPacientes = new ArrayList<>();

        if(db != null) {
            Cursor cursor = db.rawQuery("SELECT * FROM pacientes ",null);
            cursor.moveToFirst();

            do {
                Paciente paciente = new Paciente(cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3));
                listPacientes.add(paciente);
            } while (cursor.moveToNext());
            cursor.close();
        }
        db.close();
        return listPacientes;
    }
}
