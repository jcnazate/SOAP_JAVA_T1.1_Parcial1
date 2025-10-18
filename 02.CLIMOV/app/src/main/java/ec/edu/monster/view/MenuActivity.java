package ec.edu.monster.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import ec.edu.monster.R;

public class MenuActivity extends AppCompatActivity {

    private Button buttonLengthConversion;
    private Button buttonTemperatureConversion;
    private Button buttonMassConversion;
    private Button buttonBackToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        initializeViews();
        setupClickListeners();
    }

    private void initializeViews() {
        buttonLengthConversion = findViewById(R.id.buttonLengthConversion);
        buttonTemperatureConversion = findViewById(R.id.buttonTemperatureConversion);
        buttonMassConversion = findViewById(R.id.buttonMassConversion);
        buttonBackToLogin = findViewById(R.id.buttonBackToLogin);
    }

    private void setupClickListeners() {
        buttonLengthConversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, ConversionActivity.class);
                startActivity(intent);
            }
        });

        buttonTemperatureConversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, TemperatureActivity.class);
                startActivity(intent);
            }
        });

        buttonMassConversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MassActivity.class);
                startActivity(intent);
            }
        });

        buttonBackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Cerrar MenuActivity para que no se pueda regresar
            }
        });
    }
}
