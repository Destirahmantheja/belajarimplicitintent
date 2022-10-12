package com.si5b.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etLink, etLokasi, etTeks;
    private Button btnBukaWebsite, btnBukaLokasi, btnBagikanTeks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLink = findViewById(R.id.et_link);
        etLokasi = findViewById(R.id.et_lokasi);
        etTeks = findViewById(R.id.et_teks);

        btnBukaWebsite = findViewById(R.id.btn_buka_website);
        btnBukaLokasi = findViewById(R.id.btn_buka_lokasi);
        btnBagikanTeks = findViewById(R.id.btn_bagikan_teks);

        btnBukaWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link = etLink.getText().toString();
                Uri uriLink = Uri.parse(link);
                Intent bukawebsite = new Intent(Intent.ACTION_VIEW, uriLink);
                try {
                    startActivity(bukawebsite);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "kesalahan", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnBagikanTeks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String teks = etTeks.getText().toString();

            }
        });

        btnBukaLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        }

    }
}