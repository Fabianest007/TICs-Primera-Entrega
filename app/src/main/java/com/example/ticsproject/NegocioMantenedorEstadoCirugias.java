package com.example.ticsproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class NegocioMantenedorEstadoCirugias extends SQLiteOpenHelper {
   private static final int DATABASE_VERSION = 1;
   private static final String DATABASE_NAME = "clinica.db";
   private static final String ESTADO_CIRUGIAS_TABLE = "CREATE TABLE estado_cirugias (" +
         "id INTEGER PRIMARY KEY AUTOINCREMENT, "+
         "nombre TEXT NOT NULL)";
   //estados seeder (1, 'Pendiente'), (2, 'En Proceso'), (3, 'Finalizada'), (4, 'Cancelada')
   private static final String SEEDER = "INSERT INTO estado_cirugias (id, nombre)" + 
         "VALUES (1, 'Pendiente')," +
         "(2, 'En Proceso')," +
         "(3, 'Finalizada')," +
         "(4, 'Cancelada')";

   public NegocioMantenedorEstadoCirugias(Context context) {
      super(context, DATABASE_NAME, null, DATABASE_VERSION);
   }

   @Override
   public void onCreate(SQLiteDatabase db) {
      db.execSQL(ESTADO_CIRUGIAS_TABLE);
      db.execSQL(SEEDER);
   }

   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL("DROP TABLE IF EXISTS '" + ESTADO_CIRUGIAS_TABLE + "'");
   }

   //CRUD ESTADO CIRUGIA

   public void insertEstadoCirugia(EstadoCirugias estadoCirugia){
      SQLiteDatabase db = getWritableDatabase();

      if(db != null){
         String querySQL = "INSERT INTO estado_cirugias " +
               "(nombre) VALUES ('" +
               estadoCirugia.getNombre() + "');";
         db.execSQL(querySQL);
      }
   }

   public void updateEstadoCirugia(EstadoCirugias estadoCirugia){
      SQLiteDatabase db = getWritableDatabase();

      if(db != null){
         String querySQL = "UPDATE estado_cirugias " +
               "SET nombre = '" + estadoCirugia.getNombre() + "' " +
               "WHERE id = " + estadoCirugia.getId() + ";";
         db.execSQL(querySQL);
      }
   }

   public void deleteEstadoCirugia(Integer id){
      SQLiteDatabase db = getWritableDatabase();

      if(db != null){
         String querySQL = "DELETE FROM estado_cirugias " +
               "WHERE id = " + id + ";";
         db.execSQL(querySQL);
      }
   }

   public EstadoCirugias getEstadoCirugia(Integer id){
      SQLiteDatabase db = getReadableDatabase();
      EstadoCirugias estadoCirugia = new EstadoCirugias();

      if(db != null){
         String querySQL = "SELECT * FROM estado_cirugias " +
               "WHERE id = " + id + ";";
         Cursor cursor = db.rawQuery(querySQL, null);

         if(cursor.moveToFirst()){
            estadoCirugia.setId(cursor.getInt(0));
            estadoCirugia.setNombre(cursor.getString(1));
         }
      }

      return estadoCirugia;
   }

   public ArrayList<EstadoCirugias> getEstadoCirugias(){
      SQLiteDatabase db = getReadableDatabase();
      ArrayList<EstadoCirugias> estadoCirugias = new ArrayList<>();

      if(db != null){
         String querySQL = "SELECT * FROM estado_cirugias;";
         Cursor cursor = db.rawQuery(querySQL, null);

         if(cursor.moveToFirst()){
            do{
               EstadoCirugias estadoCirugia = new EstadoCirugias();
               estadoCirugia.setId(cursor.getInt(0));
               estadoCirugia.setNombre(cursor.getString(1));
               estadoCirugias.add(estadoCirugia);
            }while(cursor.moveToNext());
         }
      }

      return estadoCirugias;
   }

}
