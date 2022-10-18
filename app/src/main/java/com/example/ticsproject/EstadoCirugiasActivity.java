package com.example.ticsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class EstadoCirugiasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estado_cirugias);
        try {
            NegocioMantenedorEstadoCirugias mantenedorEstados2 = new NegocioMantenedorEstadoCirugias(this);
            List<EstadoCirugias> listaEstados2 = mantenedorEstados2.getEstadoCirugias();
            if (listaEstados2.size() == 0){
                mantenedorEstados2.seeder();
            }
        } catch (Exception e){
            this.message("Error: "+ e.getMessage());
        }

    }

    public void message(String message){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }

    public void backToHome(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void listarEstados(View view){
        NegocioMantenedorEstadoCirugias mantenedorEstados = new NegocioMantenedorEstadoCirugias(this);
        try {
            ListView listView = findViewById(R.id.estadosListView);
            List<EstadoCirugias> listaEstados = mantenedorEstados.getEstadoCirugias();
            if (listaEstados.size() == 0){
                this.message("No hay estados de cirugía");
            }
            String[] estados = new String[listaEstados.size()];
            for (int i = 0; i < listaEstados.size(); i++) {
                estados[i] = listaEstados.get(i).getId() + " - " + listaEstados.get(i).getNombre();
            }
            listView.setAdapter(new android.widget.ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, estados));

        } catch (Exception e) {
            this.message("Error: "+ e.getMessage());
        }

    }
}