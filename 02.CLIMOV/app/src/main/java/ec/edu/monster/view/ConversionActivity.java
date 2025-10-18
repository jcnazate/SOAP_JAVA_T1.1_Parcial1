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

public class ConversionActivity extends AppCompatActivity{
    private EditText editTextInches;
    private EditText editTextCm;
    private Button buttonConvertInToCm;
    private Button buttonConvertCmToIn;
    private Button buttonBackToMenu;
    private TextView textViewResultCm;
    private TextView textViewResultIn;
    private AppController controller;
    private final Executor executor = Executors.newSingleThreadExecutor();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        // Inicializar vistas
        editTextInches = findViewById(R.id.editTextInches);
        editTextCm = findViewById(R.id.editTextCm);
        buttonConvertInToCm = findViewById(R.id.buttonConvertInToCm);
        buttonConvertCmToIn = findViewById(R.id.buttonConvertCmToIn);
        buttonBackToMenu = findViewById(R.id.buttonBackToMenu);
        textViewResultCm = findViewById(R.id.textViewResultCm);
        textViewResultIn = findViewById(R.id.textViewResultIn);

        // Inicializar el controlador
        controller = new AppController();

        // Configurar el evento de clic para convertir pulgadas a centímetros
        buttonConvertInToCm.setOnClickListener(v -> {
            String inchesStr = editTextInches.getText().toString().trim();
            if (inchesStr.isEmpty()) {
                textViewResultCm.setText("Por favor, ingrese un valor en pulgadas");
                return;
            }

            executor.execute(() -> {
                try {
                    double inches = Double.parseDouble(inchesStr);
                    double centimeters = controller.pulgadasACentimetros(inches);
                    mainHandler.post(() -> {
                        textViewResultCm.setText(String.format("%.2f cm", centimeters));
                    });
                } catch (NumberFormatException e) {
                    mainHandler.post(() -> {
                        textViewResultCm.setText("Por favor, ingrese un número válido");
                    });
                } catch (Exception e) {
                    mainHandler.post(() -> {
                        textViewResultCm.setText("Error: " + (e.getMessage() != null ? e.getMessage() : "Error desconocido"));
                    });
                }
            });
        });

        // Configurar el evento de clic para convertir centímetros a pulgadas
        buttonConvertCmToIn.setOnClickListener(v -> {
            String cmStr = editTextCm.getText().toString().trim();
            if (cmStr.isEmpty()) {
                textViewResultIn.setText("Por favor, ingrese un valor en centímetros");
                return;
            }

            executor.execute(() -> {
                try {
                    double centimeters = Double.parseDouble(cmStr);
                    double inches = controller.centimetrosAPulgadas(centimeters);
                    mainHandler.post(() -> {
                        textViewResultIn.setText(String.format("%.2f pulgadas", inches));
                    });
                } catch (NumberFormatException e) {
                    mainHandler.post(() -> {
                        textViewResultIn.setText("Por favor, ingrese un número válido");
                    });
                } catch (Exception e) {
                    mainHandler.post(() -> {
                        textViewResultIn.setText("Error: " + (e.getMessage() != null ? e.getMessage() : "Error desconocido"));
                    });
                }
            });
        });

        // Configurar el evento de clic para regresar al menú
        buttonBackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConversionActivity.this, MenuActivity.class);
                startActivity(intent);
                finish(); // Cerrar ConversionActivity para que no se pueda regresar
            }
        });
    }

    // Getters para que el controlador acceda a las vistas (si es necesario)
    public EditText getEditTextInches() {
        return editTextInches;
    }

    public EditText getEditTextCm() {
        return editTextCm;
    }

    public Button getButtonConvertInToCm() {
        return buttonConvertInToCm;
    }

    public Button getButtonConvertCmToIn() {
        return buttonConvertCmToIn;
    }

    public TextView getTextViewResultCm() {
        return textViewResultCm;
    }

    public TextView getTextViewResultIn() {
        return textViewResultIn;
    }
}
