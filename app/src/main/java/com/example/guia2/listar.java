package com.example.guia2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.guia2.modelo.Persona;

import java.util.ArrayList;

import static com.example.guia2.Registrar.persona;

public class listar extends AppCompatActivity {

    private ListView lsv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        lsv = findViewById(R.id.lsvPersona);
        ArrayAdapter<Persona> adapterPersonita= new ArrayAdapter(this, android.R.layout.simple_list_item_1,persona);

        lsv.setAdapter(adapterPersonita);

        adapterPersonita.notifyDataSetChanged();
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
}