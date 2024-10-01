package br.com.temdetudo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity2 extends AppCompatActivity {

    private Button btnSeguir;
    private TextInputEditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnSeguir = findViewById(R.id.btnSeguir);
        btnSeguir.setOnClickListener(v -> {
            input = findViewById(R.id.inputName);
            String name = input.getText().toString();
            Intent intent = new Intent(this,MainActivity3.class);
            intent.putExtra("name", name);
            startActivity(intent);
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
    }
}