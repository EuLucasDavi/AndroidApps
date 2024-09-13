package com.example.imcmultiplescreens;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Obesidade3 extends AppCompatActivity {

    private TextView textResultado, textName;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obesidade3);

        textName = findViewById(R.id.personName);
        textResultado = findViewById(R.id.resultado);
        btnVoltar = findViewById(R.id.btnVoltar);

        Bundle bundle = getIntent().getExtras();
        String nome = bundle.getString("nome");
        double res = bundle.getDouble("resultado");

        String Mensagem = nome + "\n \nEITA PORRA MENÓ, \n OLHA ESSA PAPADA, TEM 5 QUEIXOS.";
        String Resultado = String.format("%.2f",res);
        textResultado.setText(Resultado);
        textName.setText(Mensagem);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnVoltar.setOnClickListener(view -> {
            finish();
        });
    }
}