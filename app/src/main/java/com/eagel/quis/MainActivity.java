package com.eagel.quis;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    EditText tugas, quis, uts, uas;
    Button proses, bersih;
    TextView hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tugas = (EditText) findViewById(R.id.tugas);
        quis = (EditText) findViewById(R.id.quis);
        uts = (EditText) findViewById(R.id.uts);
        uas = (EditText) findViewById(R.id.uas);

        proses = (Button)findViewById(R.id.proses);
        bersih = (Button)findViewById(R.id.bersih);

        hasil = (TextView) findViewById(R.id.hasil);

        proses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tugas.getText().length()>0 && quis.getText().length()>0 && uts.getText().length()>0 && uas.getText().length()>0) {
                    double nilaiTugas = Double.parseDouble(tugas.getText().toString());
                    double nilaiQuis = Double.parseDouble(quis.getText().toString());
                    double nilaiUts = Double.parseDouble(uts.getText().toString());
                    double nilaiUas = Double.parseDouble(uas.getText().toString());

                    double result = (nilaiTugas * 20/100) + (nilaiQuis * 20/100) + (nilaiUts * 30/100) + (nilaiUas * 30/100);
                    hasil.setText(Double.toString(result));
                } else {
                    Toast toast = Toast.makeText(MainActivity.this, "Nilai Yang Anda Masukkan Belum Lengkap!", Toast.LENGTH_LONG);
                    toast.show();

                }
            }
        });

        bersih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tugas.setText("");
                quis.setText("");
                uts.setText("");
                uas.setText("");
                hasil.setText("0");
                tugas.requestFocus();
            }
        });

    }
}