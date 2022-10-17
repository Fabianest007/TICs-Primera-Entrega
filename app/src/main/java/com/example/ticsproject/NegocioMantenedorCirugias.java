package com.example.ticsproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class NegocioMantenedorCirugias extends SQLiteOpenHelper {
      private static final int DATABASE_VERSION = 1;
      private static final String DATABASE_NAME = "clinica.db";
      private static final String CIRUGIA_TABLE = "CREATE TABLE cirugias (" +
               "id INTEGER PRIMARY KEY AUTOINCREMENT, "+
               "nombre TEXT NOT NULL, " +
               "descripcion TEXT NOT NULL, " +
               "fecha TEXT NOT NULL, " +
               "hora TEXT NOT NULL, " +
               "rut_paciente TEXT NOT NULL, " +
               "estado_cirugia_id INTEGER NOT NULL, " +
               "FOREIGN KEY (rut_paciente) REFERENCES pacientes(rut)," +
               "FOREIGN KEY (estado_cirugia_id) REFERENCES estado_cirugias(id))";

      public NegocioMantenedorCirugias(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
      }

      @Override
      public void onCreate(SQLiteDatabase db) {
         db.execSQL(CIRUGIA_TABLE);
      }

      @Override
      public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         db.execSQL("DROP TABLE IF EXISTS '" + CIRUGIA_TABLE + "'");
      }

      //CRUD CIRUGIA

      public void insertCirugia(Cirugia cirugia){
         SQLiteDatabase db = getWritableDatabase();

         if(db != null){
            String querySQL = "INSERT INTO cirugias " +
                     "(nombre, descripcion, fecha, hora, rut_paciente, estado_cirugia_id) VALUES ('" +
                     cirugia.getNombre() + "','"+
                     cirugia.getDescripcion() + "','"+
                     cirugia.getFecha() + "','"+
                     cirugia.getHora() + "','"+
                     cirugia.getRut_paciente() + "',"+
                     cirugia.getEstado_cirugia_id() + ");";
            db.execSQL(querySQL);
         }
      }

      public void updateCirugia(Cirugia cirugia){
         SQLiteDatabase db = getWritableDatabase();

         if(db != null){
            String querySQL = "UPDATE cirugias " +
                     " SET " +
                     " nombre = '" + cirugia.getNombre() + "," +
                     " descripcion = '" + cirugia.getDescripcion() + "," +
                     " fecha = '" + cirugia.getFecha() + "," +
                     " hora = '" + cirugia.getHora() + "," +
                     " rut_paciente = '" + cirugia.getRut_paciente() + "," +
                     " estado_cirugia_id = '" + cirugia.getEstado_cirugia_id() +
                     " WHERE id = '" + cirugia.getId()+"';";
            db.execSQL(querySQL);
         }
      }
      

      public void deleteCirugia(Integer id){
         SQLiteDatabase db = getWritableDatabase();

         if(db != null){
            String querySQL = "DELETE FROM cirugias WHERE id = " + id + ";";
            db.execSQL(querySQL);
         }
      }

      public ArrayList<Cirugia> selectCirugias(){
         ArrayList<Cirugia> cirugias = new ArrayList<Cirugia>();
         SQLiteDatabase db = getReadableDatabase();

         if(db != null){
            String querySQL = "SELECT * FROM cirugias;";
            Cursor cursor = db.rawQuery(querySQL, null);

            if(cursor.moveToFirst()){
               do{
                  Cirugia cirugia = new Cirugia();
                  cirugia.setId(cursor.getInt(0));
                  cirugia.setNombre(cursor.getString(1));
                  cirugia.setDescripcion(cursor.getString(2));
                  cirugia.setFecha(cursor.getString(3));
                  cirugia.setHora(cursor.getString(4));
                  cirugia.setRut_paciente(cursor.getString(5));
                  cirugia.setEstado_cirugia_id(cursor.getInt(6));
                  cirugias.add(cirugia);
               }while(cursor.moveToNext());
            }
         }
         return cirugias;
      }

      public Cirugia selectCirugia(Integer id){
         Cirugia cirugia = new Cirugia();
         SQLiteDatabase db = getReadableDatabase();

         if(db != null){
            String querySQL = "SELECT * FROM cirugias WHERE id = " + id + ";";
            Cursor cursor = db.rawQuery(querySQL, null);

            if(cursor.moveToFirst()){
               do{
                  cirugia.setId(cursor.getInt(0));
                  cirugia.setNombre(cursor.getString(1));
                  cirugia.setDescripcion(cursor.getString(2));
                  cirugia.setFecha(cursor.getString(3));
                  cirugia.setHora(cursor.getString(4));
                  cirugia.setRut_paciente(cursor.getString(5));
                  cirugia.setEstado_cirugia_id(cursor.getInt(6));
               }while(cursor.moveToNext());
            }
         }
         return cirugia;
      }

}
