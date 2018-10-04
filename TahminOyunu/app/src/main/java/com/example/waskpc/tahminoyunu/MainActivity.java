package com.example.waskpc.tahminoyunu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button buttonTahmin,buttonTemizle;
    TextView textUyari,textPuan;
    EditText editTahmin;
    Random rand = new Random();
    int sayi = 0;
    int tahmin = 0;
    int puan = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //0-100 arası random sayı tanımlandı
        sayi = rand.nextInt(100);


        //Nesneler ilişkilendirildi
        buttonTahmin = findViewById(R.id.buttonTahmin);
        buttonTemizle = findViewById(R.id.buttonTemizle);
        textPuan = findViewById(R.id.textPuan);
        textUyari = findViewById(R.id.textUyari);
        editTahmin = findViewById(R.id.editTahmin);


        //temizle butonuna basıldığında  program yenilenir
        buttonTemizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayi = rand.nextInt(100);
                textUyari.setText(R.string.yeniden);
                textPuan.setText(R.string.puan);
                puan = 100;

            }
        });

        //tahmin butonuna basıldığında tahmin algoritması çalışır
        buttonTahmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tah = editTahmin.getText().toString();
                tahmin = Integer.parseInt(tah);



                if(tahmin == sayi){
                    textUyari.setText(R.string.basari);
                }
                else if(tahmin > sayi){
                    textUyari.setText(R.string.kucuk);
                    puan = puan - 20;
                    textPuan.setText(puan);
                    if(puan == 0){
                        textUyari.setText(R.string.elendin);
                        sayi = rand.nextInt(100);
                    }
                }
                else if(tahmin < sayi) {
                    textUyari.setText(R.string.kucuk);
                    puan = puan - 20;
                    textPuan.setText(puan);
                    if(puan == 0){
                        textUyari.setText(R.string.elendin);
                        sayi = rand.nextInt(100);
                    }
                }





            }
        });



    }
}
