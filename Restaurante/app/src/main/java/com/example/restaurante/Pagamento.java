package com.example.restaurante;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class Pagamento extends AppCompatActivity {

    private Button btnPagar, btnCalcular, btnCancelar;
    private TextInputEditText valorEditText;
    private Switch swPark, swTip;
    private ToggleButton tgPayment;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pagamento);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeElements();

        btnCancelar.setOnClickListener(v -> {
            finish();
        });

        btnCalcular.setOnClickListener(v -> {
            String valorString = valorEditText.getText().toString().trim();
            Double finalResult = 0.0;

            if (!valorString.isEmpty()) {
                finalResult = getValue();

                if (swTip.isChecked()) {
                    finalResult += finalResult * 0.1;
                }

                if (tgPayment.isChecked()) {
                    finalResult += finalResult * 0.02;
                }

                if (swPark.isChecked()) {
                    finalResult += 25;
                }

                result.setText("R$ " + String.format("%.2f", finalResult));

            } else {
                Toast.makeText(this, "Preencha todos os Campos", Toast.LENGTH_SHORT).show();
            }
        });

        btnPagar.setOnClickListener(v -> {
            if (getValue() != null || getValue() != 0.00){
                Intent intent = new Intent(this, Efetuado.class);
                intent.putExtra("valorFinal", result.getText().toString());
                startActivity(intent);
            }else{
                Toast.makeText(this, "Preencha todos os Campos ou valor inválido", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initializeElements() {
        btnCalcular = findViewById(R.id.btnCalcular);
        btnPagar = findViewById(R.id.btnPagar);
        btnCancelar = findViewById(R.id.btnCancelar);
        valorEditText = findViewById(R.id.valor);
        swPark = findViewById(R.id.park);
        swTip = findViewById(R.id.tip);
        tgPayment = findViewById(R.id.btnTg);
        result = findViewById(R.id.result);
    }

    public Double getValue() {
        String valorString = valorEditText.getText().toString().trim();
        return Double.parseDouble(valorString.replace("R$", "").trim());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        valorEditText.setText("");
        result.setText("R$ 0,00");
        swPark.setChecked(false);
        swTip.setChecked(true);
        tgPayment.setChecked(false);
    }
}
