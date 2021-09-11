package com.example.guia2;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;

public class prueba extends AppCompatActivity {


    private ProgressBar miprogress;
    private ObjectAnimator anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);

      /*  miprogress =  findViewById(R.id.circularProgress);
        //instanciamos el animador
        //Construye y devuelve un ObjectAnimator que anima.
        anim = ObjectAnimator.ofInt(miprogress, "progress", 0, 100);
        mostrarProgress();
        */
     
    }

    private void mostrarProgress(){
        //agregamos el tiempo de la animacion a mostrar
        anim.setDuration(15000);
        anim.setInterpolator(new DecelerateInterpolator());
        //iniciamos el progressbar
        anim.start();
    }
}