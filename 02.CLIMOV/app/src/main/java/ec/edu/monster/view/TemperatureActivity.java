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

public class TemperatureActivity extends AppCompatActivity {

    private EditText editTextCelsius;
    private EditText editTextKelvin;
    private Button buttonConvertCelsiusToKelvin;
    private Button buttonConvertKelvinToCelsius;
    private Button buttonBackToMenu;
    private TextView textViewResultCelsius;
    private TextView textViewResultKelvin;
    private AppController appController;
    private final Executor executor = Executors.newSingleThreadExecutor();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        initializeViews();
        setupClickListeners();
        appController = new AppController();
    }

    private void initializeViews() {
        editTextCelsius = findViewById(R.id.editTextCelsius);
        editTextKelvin = findViewById(R.id.editTextKelvin);
        buttonConvertCelsiusToKelvin = findViewById(R.id.buttonConvertCelsiusToKelvin);
        buttonConvertKelvinToCelsius = findViewById(R.id.buttonConvertKelvinToCelsius);
        buttonBackToMenu = findViewById(R.id.buttonBackToMenu);
        textViewResultCelsius = findViewById(R.id.textViewResultCelsius);
        textViewResultKelvin = findViewById(R.id.textViewResultKelvin);
    }

    private void setupClickListeners() {
        buttonConvertCelsiusToKelvin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String celsiusStr = editTextCelsius.getText().toString().trim();
                if (celsiusStr.isEmpty()) {
                    textViewResultKelvin.setText("Por favor, ingrese un valor en celsius");
                    return;
                }

                executor.execute(() -> {
                    try {
                        double celsius = Double.parseDouble(celsiusStr);
                        double result = appController.celsiusAKelvin(celsius);
                        mainHandler.post(() -> {
                            textViewResultKelvin.setText(String.format("%.2fK", result));
                        });
                    } catch (NumberFormatException e) {
                        mainHandler.post(() -> {
                            textViewResultKelvin.setText("Por favor, ingrese un número válido");
                        });
                    } catch (Exception e) {
                        mainHandler.post(() -> {
                            textViewResultKelvin.setText("Error: " + (e.getMessage() != null ? e.getMessage() : "Error desconocido"));
                        });
                    }
                });
            }
        });

        buttonConvertKelvinToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kelvinStr = editTextKelvin.getText().toString().trim();
                if (kelvinStr.isEmpty()) {
                    textViewResultCelsius.setText("Por favor, ingrese un valor en kelvin");
                    return;
                }

                executor.execute(() -> {
                    try {
                        double kelvin = Double.parseDouble(kelvinStr);
                        double result = appController.kelvinACelsius(kelvin);
                        mainHandler.post(() -> {
                            textViewResultCelsius.setText(String.format("%.2f°C", result));
                        });
                    } catch (NumberFormatException e) {
                        mainHandler.post(() -> {
                            textViewResultCelsius.setText("Por favor, ingrese un número válido");
                        });
                    } catch (Exception e) {
                        mainHandler.post(() -> {
                            textViewResultCelsius.setText("Error: " + (e.getMessage() != null ? e.getMessage() : "Error desconocido"));
                        });
                    }
                });
            }
        });

        buttonBackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TemperatureActivity.this, MenuActivity.class);
                startActivity(intent);
                finish(); // Cerrar TemperatureActivity para que no se pueda regresar
            }
        });
    }
}
