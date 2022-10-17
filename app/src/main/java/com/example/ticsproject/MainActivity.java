package com.example.ticsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void message(String message){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }

    public void savePaciente(View view) {
        try {
            EditText rutPaciente = findViewById(R.id.rutPacienteInput);
            EditText nombresPaciente = findViewById(R.id.nombresPacienteInput);
            EditText apellidoPaterno = findViewById(R.id.apellidoPaternoInput);
            EditText apellidoMaterno = findViewById(R.id.apellidoMaternoInput);

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
            EditText errorMessage = findViewById(R.id.errorMessage);
            errorMessage.setText("Error: "+ e.getMessage());
            this.message("Error: "+ e.getMessage());
        }



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
            rutPaciente.setText(paciente.getRut());
            nombresPaciente.setText(paciente.getNombres());
            apellidoPaterno.setText(paciente.getApellido_paterno());
            apellidoMaterno.setText(paciente.getApellido_materno());

        } catch (Exception e) {
            EditText errorMessage = findViewById(R.id.errorMessage);
            errorMessage.setText("Error: "+ e.getMessage());
            this.message("Error: "+ e.getMessage());
        }
    }
}