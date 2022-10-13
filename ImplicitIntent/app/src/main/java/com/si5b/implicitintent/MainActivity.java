package com.si5b.implicitintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

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
                String linkWebsite = etLink.getText().toString();
                Uri konvLinkWebsite = Uri.parse(linkWebsite);
                Intent bukaWebsite = new Intent(Intent.ACTION_VIEW, konvLinkWebsite);

                try {
                    startActivity(bukaWebsite);
                } catch (Exception e) {
                    etLink.setError("Ada Kesalahan Link Website");
                }
            }
        });

        btnBagikanTeks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String teks = etTeks.getText().toString();
                String mimeType = "text/plain";
                new ShareCompat
                        .IntentBuilder(MainActivity.this)
                        .setType(mimeType)
                        .setChooserTitle("Bagikan teks ini")
                        .setText(teks)
                        .startChooser();

            }
        });

        btnBukaLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lokasi = etLokasi.getText().toString();
                Uri konvLokasi = Uri.parse("geo:0,0?q=" + lokasi);
                Intent bukaLokasi = new Intent(Intent.ACTION_VIEW, konvLokasi);
                startActivity(bukaLokasi);

            }
        });
        }

    }
}