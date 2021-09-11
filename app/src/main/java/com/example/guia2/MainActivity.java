package com.example.guia2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.guia2.modelo.Persona;

import static com.example.guia2.Registrar.persona;

public class MainActivity extends AppCompatActivity {

    private Button  Datos;
    private Button  agregar;
    private Button  lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Datos= findViewById(R.id.btnDatos);
        agregar = findViewById(R.id.btnAgregar);
        lista = findViewById(R.id.btnLista);
    }

    public void agregar(View view){
        startActivity(new Intent(MainActivity.this, Registrar.class));
    }

    public void ners(View view){
        startActivity(new Intent(MainActivity.this, nano.class));
    }



    public void datos(View view){
        startActivity(new Intent(MainActivity.this, datos.class));
    }
    public void verLista(View view){

        if(persona.isEmpty()){
            Toast.makeText(MainActivity.this, "La lista esta vacia", Toast.LENGTH_SHORT).show();
        }else{
            startActivity(new Intent(MainActivity.this, listar.class));
        }




    }
}