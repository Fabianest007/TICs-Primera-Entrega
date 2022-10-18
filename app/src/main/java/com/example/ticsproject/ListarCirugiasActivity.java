package com.example.ticsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ListarCirugiasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_cirugias);
    }

    public void message(String message){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }

    public void backToHome(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void listarCirugias(View view) {
        try {
            NegocioMantenedorCirugias mantenedorCirugias = new NegocioMantenedorCirugias(this);
            ListView listView = findViewById(R.id.listaCirugias);
            List<Cirugia> listaCirugias = mantenedorCirugias.selectCirugias();
            String[] cirugias = new String[listaCirugias.size()];
            for (int i = 0; i < listaCirugias.size(); i++) {
                cirugias[i] = "ID: "+listaCirugias.get(i).getId() + " \n " +
                        "Nombre: "+ listaCirugias.get(i).getNombre() + " \n " +
                        "Descripción:" + listaCirugias.get(i).getDescripcion() + " \n " +
                        "Fecha: " + listaCirugias.get(i).getFecha() + " \n " +
                        "Hora: " + listaCirugias.get(i).getHora() + " \n " +
                        "Rut Paciente: " + listaCirugias.get(i).getRut_paciente() + " \n ";
            }
            listView.setAdapter(new android.widget.ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cirugias));
            

        } catch (Exception e) {
            this.message("Error: "+ e.getMessage());
        }

    }
}