package com.example.temperaturecricket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText etChirps;
    Button btnCalcTemp;
    TextView tvResults;
    DecimalFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etChirps = findViewById(R.id.etChirps);
        btnCalcTemp = findViewById(R.id.btnCalcTemp);
        tvResults = findViewById(R.id.tvResults);

        tvResults.setVisibility(View.GONE);
        formatter = new DecimalFormat("#0.0");

        btnCalcTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etChirps.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter number of chirps", Toast.LENGTH_SHORT).show();
                } else {
                    int chirps = Integer.parseInt(etChirps.getText().toString().trim());
                    double temperature = (chirps / 3.0) + 4;
                    String results = "The approximate temperature outside is " + formatter.format(temperature) + " degrees Celsius.";
                    tvResults.setText(results);
                    tvResults.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}