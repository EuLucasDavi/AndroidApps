package com.example.megasena;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView num1, num2, num3, num4, num5, num6;
    private Button sortearButton;
    private Button limparButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Encontrar os TextViews e o Botão pelo ID
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        num5 = findViewById(R.id.num5);
        num6 = findViewById(R.id.num6);
        sortearButton = findViewById(R.id.sortearButton);
        limparButton = findViewById(R.id.limparButton);

        // Configurar o evento de clique do botão
        sortearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortearNumeros();
            }
        });

        limparButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limparNumeros();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void sortearNumeros() {
        // Criar uma lista com números de 1 a 60
        List<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= 60; i++) {
            numeros.add(i);
        }

        // Embaralhar os números para garantir aleatoriedade
        Collections.shuffle(numeros);

        // Selecionar os primeiros 6 números embaralhados
        List<Integer> selecionados = numeros.subList(0, 6);

        // Ordenar os números selecionados
        Collections.sort(selecionados);

        // Atribuir os números ordenados aos TextViews
        num1.setText(String.valueOf(selecionados.get(0)));
        num2.setText(String.valueOf(selecionados.get(1)));
        num3.setText(String.valueOf(selecionados.get(2)));
        num4.setText(String.valueOf(selecionados.get(3)));
        num5.setText(String.valueOf(selecionados.get(4)));
        num6.setText(String.valueOf(selecionados.get(5)));
    }

    private void limparNumeros(){
        num1.setText("");
        num2.setText("");
        num3.setText("");
        num4.setText("");
        num5.setText("");
        num6.setText("");
    }
}
