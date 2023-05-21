package com.example.act1;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        // Obtener el idioma actual del dispositivo
        String currentLanguage = Locale.getDefault().getLanguage();

        // Establecer el idioma de la aplicación según el idioma del dispositivo
        setAppLanguage(currentLanguage);

        // Actualizar el texto según el idioma seleccionado
        updateText();
    }

    private void setAppLanguage(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.setLocale(locale);

        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }

    private void updateText() {
        String appName = getString(R.string.app_name);
        textView.setText(appName);
    }
}
