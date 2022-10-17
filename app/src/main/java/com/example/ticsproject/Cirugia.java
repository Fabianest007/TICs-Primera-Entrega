package com.example.ticsproject;

public class Cirugia implements Serializable {
      private String nombre, descripcion, fecha, hora, rut_paciente;
      private int id, estado_cirugia_id;
   
      public Cirugia(int id, String nombre, String descripcion, String fecha, String hora, String rut_paciente, int estado_cirugia_id) {
         this.id = id;
         this.nombre = nombre;
         this.descripcion = descripcion;
         this.fecha = fecha;
         this.hora = hora;
         this.rut_paciente = rut_paciente;
         this.estado_cirugia_id = estado_cirugia_id;
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
   
      public String getDescripcion() {
         return descripcion;
      }
   
      public void setDescripcion(String descripcion) {
         this.descripcion = descripcion;
      }
   
      public String getFecha() {
         return fecha;
      }
   
      public void setFecha(String fecha) {
         this.fecha = fecha;
      }
   
      public String getHora() {
         return hora;
      }
   
      public void setHora(String hora) {
         this.hora = hora;
      }
   
      public String getRut_paciente() {
         return rut_paciente;
      }
   
      public void setRut_paciente(String rut_paciente) {
         this.rut_paciente = rut_paciente;
      }
   
      public int getEstado_cirugia_id() {
         return estado_cirugia_id;
      }
   
      public void setEstado_cirugia_id(int estado_cirugia_id) {
         this.estado_cirugia_id = estado_cirugia_id;
      }
}
