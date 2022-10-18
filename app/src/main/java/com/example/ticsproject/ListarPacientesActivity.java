package com.example.ticsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ListarPacientesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_pacientes);
    }

    public void message(String message){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }

    public void backToHome(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void listarPacientes(View view){
        NegocioMantenedorPaciente mantenedorPaciente = new NegocioMantenedorPaciente(this);
        try {
            ListView listView = findViewById(R.id.estadosListView);
            List<Paciente> listaPacientes = mantenedorPaciente.readAllPacientes();
            String[] pacientes = new String[listaPacientes.size()];
            for (int i = 0; i < listaPacientes.size(); i++) {
                pacientes[i] = listaPacientes.get(i).getRut() + " - " + listaPacientes.get(i).getNombres() + " " + listaPacientes.get(i).getApellido_paterno() + " " + listaPacientes.get(i).getApellido_materno();
            }
            listView.setAdapter(new android.widget.ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pacientes));
            
        } catch (Exception e) {
            this.message("Error: "+ e.getMessage());
        }
        
    }
}