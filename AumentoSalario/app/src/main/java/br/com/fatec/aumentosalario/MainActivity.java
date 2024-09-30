package br.com.fatec.aumentosalario;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private RadioButton radio40, radio45, radio50;
    private Button btnCalcular;
    private TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        input = findViewById(R.id.inputSalario);
        radio40 = findViewById(R.id.radio_40);
        radio45 = findViewById(R.id.radio_45);
        radio50 = findViewById(R.id.radio_50);
        btnCalcular = findViewById(R.id.btnCalcular);
        res = findViewById(R.id.Resultado);

        btnCalcular.setOnClickListener(v -> Calcular());

    }

    public void Calcular(){

        double salary;
        double result;

        // Ler salário e tratar
        try {
            salary = Double.parseDouble(input.getText().toString());
        } catch (NumberFormatException e) {
            res.setText("Insira um valor");
            input.setError("Campo em Branco");
            return;
        }

        if (radio40.isChecked()) {
            result = (salary + (0.40 * salary)); // Aumneto de 40%
        } else if (radio45.isChecked()) {
            result = (salary + (0.45 * salary)); // Aumento de 45%
        } else if (radio50.isChecked()) {
            result = (salary + (0.50 * salary)); // Aumento de 50%
        } else {
            res.setText("Selecione uma porcentagem");
            return;
        }

        // Mostrar novo Salário
        res.setText(String.format("Novo salário: %.2f", result));

    }
}