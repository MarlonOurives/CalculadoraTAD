package com.example.marlonourives.calculadora;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class CalculadoraActivity extends AppCompatActivity {

    EditText edtValor1;
    EditText edtValor2;
    EditText edtResultado;
    Button btnSomar;
    Button btnSubtrair;
    Button btnDividir;
    Button btnMultiplicar;
    Button btnSalvar;
    ArrayList<String> arraySal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        arraySal = new ArrayList<String>();

        edtResultado = (EditText) findViewById(R.id.edtResultado);
        btnSomar = (Button) findViewById(R.id.btnSomar);
        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double valor1;
                Double valor2;
                Double resultado = 0.0;
                edtValor1 = (EditText) findViewById(R.id.edtValor1);

                edtValor2 = (EditText) findViewById(R.id.edtValor2);

                if (edtValor1.getText().toString().equals("")|| edtValor2.getText().toString().equals("")){
                    alert();
                    edtValor1.setText("");
                    edtValor2.setText("");
                }else {
                    valor1 = Double.parseDouble(edtValor1.getText().toString());
                    valor2 = Double.parseDouble(edtValor2.getText().toString());
                    resultado = valor1 + valor2;
                    edtResultado.setText(resultado.toString());
                    edtValor1.setText("");
                    edtValor2.setText("");
                }


            }
        });


        btnDividir = (Button) findViewById(R.id.btnDividir);
        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double valor1;
                Double valor2;
                Double resultado = 0.0;
                edtValor1 = (EditText) findViewById(R.id.edtValor1);

                edtValor2 = (EditText) findViewById(R.id.edtValor2);

                if (edtValor1.getText().toString().equals("")|| edtValor2.getText().toString().equals("")|| (Double.parseDouble(edtValor2.getText().toString()) == 0 &&
                        Double.parseDouble(edtValor1.getText().toString()) == 0) || Double.parseDouble(edtValor2.getText().toString()) == 0){
                    alert();
                    edtValor1.setText("");
                    edtValor2.setText("");
                }else {
                    valor1 = Double.parseDouble(edtValor1.getText().toString());
                    valor2 = Double.parseDouble(edtValor2.getText().toString());
                    resultado = valor1 / valor2;
                    edtResultado.setText(resultado.toString());
                    edtValor1.setText("");
                    edtValor2.setText("");
                }


            }


        });

        btnMultiplicar = (Button) findViewById(R.id.btnMultiplicar);
        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double valor1;
                Double valor2;
                Double resultado = 0.0;
                edtValor1 = (EditText) findViewById(R.id.edtValor1);

                edtValor2 = (EditText) findViewById(R.id.edtValor2);

                if (edtValor1.getText().toString().equals("")|| edtValor2.getText().toString().equals("")){
                    alert();
                    edtValor1.setText("");
                    edtValor2.setText("");
                }else {
                    valor1 = Double.parseDouble(edtValor1.getText().toString());
                    valor2 = Double.parseDouble(edtValor2.getText().toString());
                    resultado = valor1 * valor2;
                    edtResultado.setText(resultado.toString());
                    edtValor1.setText("");
                    edtValor2.setText("");
                }

            }
        });

        btnSubtrair = (Button) findViewById(R.id.btnSubtrair);
        btnSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double valor1;
                Double valor2;
                Double resultado = 0.0;
                edtValor1 = (EditText) findViewById(R.id.edtValor1);

                edtValor2 = (EditText) findViewById(R.id.edtValor2);

                if (edtValor1.getText().toString().equals("")|| edtValor2.getText().toString().equals("")){
                    alert();
                    edtValor1.setText("");
                    edtValor2.setText("");
                }else {
                    valor1 = Double.parseDouble(edtValor1.getText().toString());
                    valor2 = Double.parseDouble(edtValor2.getText().toString());
                    resultado = valor1 - valor2;
                    edtResultado.setText(resultado.toString());
                    edtValor1.setText("");
                    edtValor2.setText("");
                }
            }
        });

        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               salvar();
            }
        });




    }

    public void salvar(){
        String salva = edtResultado.getText().toString();
        arraySal.add(salva);
        Intent it = new Intent(this, SalvarActivity.class);
        it.putExtra("salv", arraySal);
        startActivity(it);
    }

    public void alert(){
        Toast toast = Toast.makeText(this,"Campo com valor inválido",Toast.LENGTH_LONG);
        toast.show();
    }
}
