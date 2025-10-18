package ec.edu.monster.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import ec.edu.monster.R;
import ec.edu.monster.controller.AppController;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MassActivity extends AppCompatActivity {

    private EditText editTextKilograms;
    private EditText editTextGrams;
    private Button buttonConvertKgToG;
    private Button buttonConvertGToKg;
    private Button buttonBackToMenu;
    private TextView textViewResultKilograms;
    private TextView textViewResultGrams;
    private AppController appController;
    private final Executor executor = Executors.newSingleThreadExecutor();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass);

        initializeViews();
        setupClickListeners();
        appController = new AppController();
    }

    private void initializeViews() {
        editTextKilograms = findViewById(R.id.editTextKilograms);
        editTextGrams = findViewById(R.id.editTextGrams);
        buttonConvertKgToG = findViewById(R.id.buttonConvertKgToG);
        buttonConvertGToKg = findViewById(R.id.buttonConvertGToKg);
        buttonBackToMenu = findViewById(R.id.buttonBackToMenu);
        textViewResultKilograms = findViewById(R.id.textViewResultKilograms);
        textViewResultGrams = findViewById(R.id.textViewResultGrams);
    }

    private void setupClickListeners() {
        buttonConvertKgToG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kgStr = editTextKilograms.getText().toString().trim();
                if (kgStr.isEmpty()) {
                    textViewResultGrams.setText("Por favor, ingrese un valor en kilogramos");
                    return;
                }

                executor.execute(() -> {
                    try {
                        double kg = Double.parseDouble(kgStr);
                        double result = appController.kilogramosAGramos(kg);
                        mainHandler.post(() -> {
                            textViewResultGrams.setText(String.format("%.2f g", result));
                        });
                    } catch (NumberFormatException e) {
                        mainHandler.post(() -> {
                            textViewResultGrams.setText("Por favor, ingrese un número válido");
                        });
                    } catch (Exception e) {
                        mainHandler.post(() -> {
                            textViewResultGrams.setText("Error: " + (e.getMessage() != null ? e.getMessage() : "Error desconocido"));
                        });
                    }
                });
            }
        });

        buttonConvertGToKg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gStr = editTextGrams.getText().toString().trim();
                if (gStr.isEmpty()) {
                    textViewResultKilograms.setText("Por favor, ingrese un valor en gramos");
                    return;
                }

                executor.execute(() -> {
                    try {
                        double g = Double.parseDouble(gStr);
                        double result = appController.gramosAKilogramos(g);
                        mainHandler.post(() -> {
                            textViewResultKilograms.setText(String.format("%.2f kg", result));
                        });
                    } catch (NumberFormatException e) {
                        mainHandler.post(() -> {
                            textViewResultKilograms.setText("Por favor, ingrese un número válido");
                        });
                    } catch (Exception e) {
                        mainHandler.post(() -> {
                            textViewResultKilograms.setText("Error: " + (e.getMessage() != null ? e.getMessage() : "Error desconocido"));
                        });
                    }
                });
            }
        });

        buttonBackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MassActivity.this, MenuActivity.class);
                startActivity(intent);
                finish(); // Cerrar MassActivity para que no se pueda regresar
            }
        });
    }
}
