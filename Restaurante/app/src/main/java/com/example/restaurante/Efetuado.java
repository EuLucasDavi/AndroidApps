package com.example.restaurante;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Efetuado extends AppCompatActivity {

    private Button btnVoltar;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_efetuado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeElements();

        Bundle bundle = getIntent().getExtras();
        String res = bundle.getString("valorFinal");

        textResult.setText(res + "\nPAGAMENTO APROVADO");

        btnVoltar.setOnClickListener(v -> {
            finish();
        });

    }

    public void initializeElements(){
        btnVoltar = findViewById(R.id.btnVoltar);
        textResult = findViewById(R.id.textResult);
    }

}