package com.example.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnChamaTela2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Log.i("Ciclo de vida","onCreate");

        btnChamaTela2 = findViewById(R.id.btnChamaTela2);
        btnChamaTela2.setOnClickListener(view -> {

            // Cria objeto Intent
            Intent intent = new Intent(this, MainActivity2.class);

            // Crie uma variável com conteúdo qualquer
            String nome = "Emilia";

            // Passa parâmetros para outra activity
            intent.putExtra("Idade",33);
            intent.putExtra("Altura",1.34);
            intent.putExtra("Nickname","Zipada");
            intent.putExtra("nome", nome);

            startActivity(intent);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
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

    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Ciclo de vida","onStop");

    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Ciclo de vida","onRestart");

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