package com.example.ticsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarPacienteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_paciente);
    }

    public void message(String message){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }


    public void savePaciente(View view) {
        try {
            EditText rutPaciente = findViewById(R.id.inputRutPaciente);
            EditText nombresPaciente = findViewById(R.id.inputNombresPaciente);
            EditText apellidoPaterno = findViewById(R.id.inputApellidoPaternoPaciente);
            EditText apellidoMaterno = findViewById(R.id.inputApellidoMaternoPaciente);

            Paciente paciente = new Paciente(rutPaciente.getText().toString(),
                    nombresPaciente.getText().toString(),
                    apellidoPaterno.getText().toString(),
                    apellidoMaterno.getText().toString());

            NegocioMantenedorPaciente mantenedorPaciente = new NegocioMantenedorPaciente(this);
            mantenedorPaciente.insertPaciente(paciente);
            this.message("Paciente guardado con éxto");
            rutPaciente.setText("");
            nombresPaciente.setText("");
            apellidoPaterno.setText("");
            apellidoMaterno.setText("");
        } catch (Exception e){
            this.message("Error: "+ e.getMessage());
        }



    }

    public void backToHome(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}