package com.example.guia2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.guia2.modelo.Comunicacion;
import com.example.guia2.modelo.Persona;

import java.util.ArrayList;

public class Registrar extends AppCompatActivity {

    private EditText nombre;
    private ProgressBar prg;
    private Button btnGuardar;
    private ProgressBar pr;
    private ObjectAnimator anim;
    int progreso = 0;
    int i=0;
    Handler handler = new Handler();

    public static ArrayList<Persona> persona;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        nombre= findViewById(R.id.txtNombre);
        btnGuardar = findViewById(R.id.btnAgregar);

        pr= findViewById(R.id.progressBar);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        persona = new ArrayList<>();
        pr.setVisibility(View.VISIBLE);
        anim = ObjectAnimator.ofInt(prg, "progress", 0, 100);

        // INICIA EL HILO CON LA ACCION DEL PROGRESS BAR




    }


    public void prueba(View view){

        if(nombre.getText().toString().isEmpty()){
            Toast.makeText(Registrar.this, "Campo requerido", Toast.LENGTH_SHORT).show();


        }else{
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (progreso < 100) {
                        progreso = progreso + 10;

                        // ACTUALIZA EL PROGRESS BAR Y ACTUALIZA EL TEXT VIEW
                        handler.post(new Runnable() {
                            @Override
                            public void run() {

                                pr.setProgress(progreso);
                                if(progreso == 100) {
                                    //        Toast.makeText(MainActivity.this, "SE TERMINO LA CARGA", Toast.LENGTH_LONG).show();
                                    persona.add(new Persona(nombre.getText().toString()));
                                    Toast.makeText(Registrar.this, "Guardado", Toast.LENGTH_SHORT).show();
                               //     startActivity(new Intent(Registrar.this, listar.class));

                                }

                                //        tvTexto.setText(progreso + " / " + prg.getMax());
                            }
                        });

                        try {
                            // DUERME EL HILO POR 200 MILISEGUNDOS
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }).start();
        }






    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    public void guardar(View view){
    persona.add(new Persona(nombre.getText().toString()));
            Toast.makeText(Registrar.this, "Guardado", Toast.LENGTH_SHORT).show();
    }



}