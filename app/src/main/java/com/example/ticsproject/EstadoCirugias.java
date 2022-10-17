package com.example.ticsproject;

import java.io.Serializable;

public class EstadoCirugias implements Serializable {
      private String nombre;
      private int id;
   
      public EstadoCirugias(int id, String nombre) {
         this.id = id;
         this.nombre = nombre;
      }
   
      public EstadoCirugias() {
      }
   
      public int getId() {
         return id;
      }
   
      public void setId(int id) {
         this.id = id;
      }
   
      public String getNombre() {
         return nombre;
      }
   
      public void setNombre(String nombre) {
         this.nombre = nombre;
      }
}
