package com.example.ticsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarCirugiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cirugia);
    }

    public void backToHome(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void message(String message){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }

    public void saveCirugia(View view) {
        try {
            EditText nombreCirugia = findViewById(R.id.nombreCirugiaInput);
            EditText descripcionCirugia = findViewById(R.id.descripcionCirugiaInput);
            EditText fechaCirugia = findViewById(R.id.fechaInput);
            EditText horaCirugia = findViewById(R.id.horaInput);
            EditText rutPaciente = findViewById(R.id.cirugiarutPacienteInput);

            Cirugia cirugia = new Cirugia();

            cirugia.setNombre(nombreCirugia.getText().toString());
            cirugia.setDescripcion(descripcionCirugia.getText().toString());
            cirugia.setFecha(fechaCirugia.getText().toString());
            cirugia.setHora(horaCirugia.getText().toString());
            cirugia.setRut_paciente(rutPaciente.getText().toString());
            cirugia.setEstado_cirugia_id(1);

            if(nombreCirugia.getText().toString().isEmpty() || descripcionCirugia.getText().toString().isEmpty() || fechaCirugia.getText().toString().isEmpty() || horaCirugia.getText().toString().isEmpty() || rutPaciente.getText().toString().isEmpty()){
                this.message("Error: Debe rellenar todos los campos");
                return;
            }

            NegocioMantenedorCirugias mantenedorCirugias = new NegocioMantenedorCirugias(this);
            mantenedorCirugias.insertCirugia(cirugia);
            this.message("Cirugia Registrada con éxito");
            nombreCirugia.setText("");
            descripcionCirugia.setText("");
            fechaCirugia.setText("");
            horaCirugia.setText("");
            rutPaciente.setText("");
        } catch (Exception e){
            this.message("Error: " + e.getMessage());
        }


    }
}