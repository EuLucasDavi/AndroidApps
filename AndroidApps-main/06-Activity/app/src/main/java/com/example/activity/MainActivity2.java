package com.example.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private Button btnFechaTela2;
    private Button btnChamaTela3;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        // Instanciamento dos elementos
        textResultado = findViewById(R.id.textResultado);
        btnChamaTela3 = findViewById(R.id.btnChamaTela3);
        btnFechaTela2 = findViewById(R.id.btnFechaTela2);

        // Recebe dados
        Bundle bundle = getIntent().getExtras();

        //
        String nome = bundle.getString("nome");
        String nickname = bundle.getString("Nickname");
        int idade = bundle.getInt("Idade");
        double altura = bundle.getDouble("Altura");

        // Mostrar Resultado
        String Resultado =
                "Nome: " + nome + " (" + nickname+ ")\n" +
                "Idade: " + idade + "\n" +
                "Altura: " + altura + "\n";
        textResultado.setText(Resultado);

        // Metodo fecha tela 2 quando clicla em btnFechaTela2
        btnFechaTela2.setOnClickListener(view ->{
            finish();
        });

        // Metodo chama tela 3 quando clicar em btnChamaTela3
        btnChamaTela3.setOnClickListener(view -> {
            Intent intent = new Intent(this,MainActivity3.class);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}