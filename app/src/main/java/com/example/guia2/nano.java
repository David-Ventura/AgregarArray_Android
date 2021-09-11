package com.example.guia2;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.guia2.modelo.Persona;

public class nano extends AppCompatActivity {
    private ProgressBar miprogress;
    private ObjectAnimator anim;
    int progreso = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nano);

        //instanciamos el progrogressbar
        miprogress = (ProgressBar) findViewById(R.id.circularProgress);
        //instanciamos el animador
        //Construye y devuelve un ObjectAnimator que anima.
        anim = ObjectAnimator.ofInt(miprogress, "progress", 0, 100);

        mostrarProgress();
    }
    private void mostrarProgress(){

        while (progreso < 100) {
            progreso = progreso + 10;
            miprogress.setProgress(progreso);
            if(progreso == 100) {

                Toast.makeText(nano.this, "Guardado", Toast.LENGTH_SHORT).show();
            }
        }
        //agregamos el tiempo de la animacion a mostrar


        anim.setDuration(1000);
            Toast.makeText(nano.this, "next", Toast.LENGTH_SHORT).show();



        anim.setInterpolator(new DecelerateInterpolator());
        //iniciamos el progressbar
        anim.start();

    }
}