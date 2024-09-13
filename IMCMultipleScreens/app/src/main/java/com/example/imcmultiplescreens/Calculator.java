package com.example.imcmultiplescreens;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class Calculator extends AppCompatActivity {

    private EditText altura,peso, nome;
    private Button btnCalculate,btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);

        nome = findViewById(R.id.nome);
        altura = findViewById(R.id.altura);
        peso = findViewById(R.id.peso);
        btnCalculate = findViewById(R.id.btnCalcular);
        btnVoltar = findViewById(R.id.btnVoltar);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculate();
            }
        });

        btnVoltar.setOnClickListener(view -> {
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void Calculate(){
        String nomeStr = nome.getText().toString();
        String alturaStr = altura.getText().toString();
        String pesoStr = peso.getText().toString();

        if (!alturaStr.isEmpty() && !pesoStr.isEmpty()) {
            double calcAltura = Double.parseDouble(alturaStr);
            double calcPeso = Double.parseDouble(pesoStr);
            double res;

            if (calcAltura < 2.45) {
                calcAltura *= calcAltura;
                res = calcPeso / calcAltura;
                IMCValidation(res,nomeStr);
            } else {
                altura.setError("Conferir Formatação");
            }
        } else {
            nome.setError("Sem Campos Vazios");
            altura.setError("Sem Campos Vazios");
            peso.setError("Sem Campos Vazios");
        }
    }

    private void IMCValidation(double res, String nome) {
        if (res > 0 && res < 18.5) {
            Intent intentBaixoPeso = new Intent(this, BaixoPeso.class);
            intentBaixoPeso.putExtra("nome",nome);
            intentBaixoPeso.putExtra("resultado", res);
            startActivity(intentBaixoPeso);
        }
        if (res >= 18.5 && res <= 24.9) {
            Intent intentPesoNormal = new Intent(this, PesoNormal.class);
            intentPesoNormal.putExtra("nome",nome);
            intentPesoNormal.putExtra("resultado", res);
            startActivity(intentPesoNormal);
        }
        if (res >= 25 && res <= 29.9) {
            Intent intentSobrepeso = new Intent(this, Sobrepeso.class);
            intentSobrepeso.putExtra("nome",nome);
            intentSobrepeso.putExtra("resultado", res);
            startActivity(intentSobrepeso);
        }
        if (res >= 30 && res <= 34.9) {
            Intent intentObesidade1 = new Intent(this,Obesidade1.class);
            intentObesidade1.putExtra("nome",nome);
            intentObesidade1.putExtra("resultado", res);
            startActivity(intentObesidade1);
        }
        if (res >= 35 && res <= 39.9) {
            Intent intentObesidade2 = new Intent(this,Obesidade2.class);
            intentObesidade2.putExtra("nome", nome);
            intentObesidade2.putExtra("resultado", res);
            startActivity(intentObesidade2);
        }
        if (res >= 40) {
            Intent intentObesidade3 = new Intent(this, Obesidade3.class);
            intentObesidade3.putExtra("nome", nome);
            intentObesidade3.putExtra("resultado", res);
            startActivity(intentObesidade3);
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Ciclo de vida","onStart");

    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Ciclo de vida","onResume");
        nome.setText("");
        altura.setText("");
        peso.setText("");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Ciclo de vida","onStop");
        nome.setText("");
        altura.setText("");
        peso.setText("");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Ciclo de vida","onRestart");
        nome.setText("");
        altura.setText("");
        peso.setText("");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo de vida","onDestroy");

    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("Ciclo de vida","onPause");

    }
}