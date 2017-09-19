package com.example.marlonourives.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SalvarActivity extends AppCompatActivity{

    private ListView lstSal;
    private ArrayAdapter<String> arrayResultados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salvar);

        ListView lstSal = (ListView) findViewById(R.id.lstSalvo);

        arrayResultados = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        lstSal.setAdapter(arrayResultados);

        Bundle bundle = getIntent().getExtras();

        ArrayList<String> sal = bundle.getStringArrayList("salv");
        arrayResultados.addAll(sal);

    }
}
