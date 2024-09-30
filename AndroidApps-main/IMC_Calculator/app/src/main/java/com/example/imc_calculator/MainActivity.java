package com.example.imc_calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView errorMsg, successMsg;
    private EditText altura, peso;
    private Button btnCalculate, btnClean;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        errorMsg = findViewById(R.id.resultado1);
        successMsg = findViewById(R.id.resultado2);
        altura = findViewById(R.id.altura);
        peso = findViewById(R.id.peso);
        btnCalculate = findViewById(R.id.btnCalcular);
        btnClean = findViewById(R.id.btnLimpar);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate();
            }
        });

        btnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Clean();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void Calculate() {
        String alturaStr = altura.getText().toString();
        String pesoStr = peso.getText().toString();

        if (!alturaStr.isEmpty() && !pesoStr.isEmpty()) {
            double calcAltura = Double.parseDouble(alturaStr);
            double calcPeso = Double.parseDouble(pesoStr);
            double res;

            if (calcAltura < 2.45) {
                calcAltura *= calcAltura;
                res = calcPeso / calcAltura;
                IMCValidation(res);
                errorMsg.setText("");
            } else {
                altura.setError("Conferir Formatação");
            }
        } else {
            errorMsg.setText("ERRO");
            errorMsg.setTextColor(getColor(R.color.red));
            successMsg.setText("ENTRADA INVÁLIDA");
            successMsg.setTextColor(getColor(R.color.red));
        }
    }


    private void Clean() {
        errorMsg.setText("");
        successMsg.setText("");
        peso.setText("");
        altura.setText("");
    }

    private void IMCValidation(double res) {
        if (res > 0 && res < 18.5) {
            successMsg.setText("Baixo Peso");
            successMsg.setTextColor(getColor(R.color.green));
        }
        if (res >= 18.5 && res <= 24.9) {
            successMsg.setText("Peso Normal");
            successMsg.setTextColor(getColor(R.color.green));
        }
        if (res >= 25 && res <= 29.9) {
            successMsg.setText("Sobrepeso");
            successMsg.setTextColor(getColor(R.color.orange));
        }
        if (res >= 30 && res <= 34.9) {
            successMsg.setText("Obesidade Grau 1");
            successMsg.setTextColor(getColor(R.color.red));
        }
        if (res >= 35 && res <= 39.9) {
            successMsg.setText("Obesidade Grau 2");
            successMsg.setTextColor(getColor(R.color.red));
        }
        if (res >= 40) {
            successMsg.setText("Ta grande hein bixo");
            successMsg.setTextColor(getColor(R.color.red));
        }
    }
}