package ec.edu.monster.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import ec.edu.monster.R;
import ec.edu.monster.controller.AppController;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class LoginActivity extends AppCompatActivity{
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;
    private TextView textViewMessage;
    private AppController controller;
    private final Executor executor = Executors.newSingleThreadExecutor();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializar vistas
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewMessage = findViewById(R.id.textViewMessage);

        // Inicializar el controlador
        controller = new AppController();

        // Configurar el evento de clic del botón de login
        buttonLogin.setOnClickListener(v -> {
            String username = editTextUsername.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                textViewMessage.setText("Por favor, ingrese usuario y contraseña");
                return;
            }

            // Ir directo al login (omitir verificación de conectividad por ahora)
            textViewMessage.setText("Conectando al servidor...");
            
            // Ejecutar la solicitud SOAP en un hilo secundario
            executor.execute(() -> {
                try {
                    boolean loginSuccess = controller.login(username, password);
                    // Actualizar la UI en el hilo principal
                    mainHandler.post(() -> {
                        if (loginSuccess) {
                            textViewMessage.setText("Login exitoso");
                            // Crear un Intent para iniciar MenuActivity
                            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                            startActivity(intent);
                            // Opcional: Finalizar LoginActivity para que no se pueda regresar a ella
                            finish();
                        } else {
                            textViewMessage.setText("Usuario o contraseña incorrectos");
                        }
                    });
                } catch (Exception e) {
                    String errorMsg = e.getMessage() != null ? e.getMessage() : "Error desconocido al conectar con el servidor";
                    // Actualizar la UI en el hilo principal
                    mainHandler.post(() -> {
                        textViewMessage.setText("Error: " + errorMsg);
                        e.printStackTrace();
                    });
                }
            });
        });
    }

    // Getters para que el controlador acceda a las vistas (si es necesario)
    public EditText getEditTextUsername() {
        return editTextUsername;
    }

    public EditText getEditTextPassword() {
        return editTextPassword;
    }

    public Button getButtonLogin() {
        return buttonLogin;
    }

    public TextView getTextViewMessage() {
        return textViewMessage;
    }
}
