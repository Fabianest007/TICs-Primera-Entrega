package com.example.ticsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BuscarPacienteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_paciente);
    }

    public void message(String message){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }


    public void searchPaciente(View view) {
        try {
            EditText buscadorRutInput = findViewById(R.id.buscadorRutInput);
            EditText rutPaciente = findViewById(R.id.rutPacienteInput);
            EditText nombresPaciente = findViewById(R.id.nombresPacienteInput);
            EditText apellidoPaterno = findViewById(R.id.apellidoPaternoInput);
            EditText apellidoMaterno = findViewById(R.id.apellidoMaternoInput);

            NegocioMantenedorPaciente mantenedorPaciente = new NegocioMantenedorPaciente(this);
            Paciente paciente = mantenedorPaciente.readPaciente(buscadorRutInput.getText().toString());
            if(paciente != null){
                rutPaciente.setText(paciente.getRut());
                nombresPaciente.setText(paciente.getNombres());
                apellidoPaterno.setText(paciente.getApellido_paterno());
                apellidoMaterno.setText(paciente.getApellido_materno());
            } else {
                this.message("Error: No se encontró ningun paciente con ese rut");
            }

        } catch (Exception e) {
            this.message("Error: "+ e.getMessage());
        }
    }



    public void backToHome(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}