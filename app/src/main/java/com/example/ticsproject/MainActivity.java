package com.example.ticsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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


    public void irRegistrarPaciente(View view) {
        Intent intent = new Intent(this,RegistrarPacienteActivity.class);
        startActivity(intent);
    }


    public void irBuscarPaciente(View view) {
        Intent intent = new Intent(this,BuscarPacienteActivity.class);
        startActivity(intent);
    }

    public void irListarPacientes(View view) {
        Intent intent = new Intent(this,ListarPacientesActivity.class);
        startActivity(intent);
    }
}