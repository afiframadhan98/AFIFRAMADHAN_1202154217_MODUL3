package com.example.android.afiframadhan_1202154217_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    TextView title, liter;
    ImageView photo, filledBottle;
    private int liters = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();                            // Mendapatkan Intent dari class ListAdapter
        String Title = intent.getStringExtra("Title");      // Melakukan set Title
        Integer Background = intent.getIntExtra("Background",0);    // Melakukan set Background

        title = (TextView)findViewById(R.id.detail_title);
        liter = (TextView)findViewById(R.id.Liter);
        photo = (ImageView)findViewById(R.id.detail_photo);
        filledBottle = (ImageView)findViewById(R.id.bottle);

        title.setText(Title);
        Bottle();
        photo.setImageResource(Background);
    }

    public void onPlus(View view) {
        // method untuk membatasi penambahan liters
        if(liters < 4) {
            liters++;
            Bottle();
        } else {
            // Tetap menampilkan toast walaupun liters tidak bisa ditambah lagi
            Toast.makeText(this,"Water is Full",Toast.LENGTH_SHORT).show();
        }
    }

    public void onMin(View view) {
        // method untuk membatasi pengurangan liters
        if (liters > 1) {
            liters--;
            Bottle();
        } else {
            // Tetap menampilkan toast walaupun liters tidak bisa dikurangi lagi
            Toast.makeText(this,"Water is a Little",Toast.LENGTH_SHORT).show();
        }
    }

    public void Bottle() {
        if (liters == 1 ){
            // ic_filled_bottle_20 or 20% filled
            liter.setText("1L");
            filledBottle.setImageResource(R.drawable.ic_filled_bottle_20);
            Toast.makeText(this,"Water is a Little",Toast.LENGTH_SHORT).show();
        } else if (liters == 2){
            // ic_filled_bottle_50 or 50% filled
            liter.setText("2L");
            filledBottle.setImageResource(R.drawable.ic_filled_bottle_50);
        } else if(liters == 3) {
            // ic_filled_bottle_80 or 80% filled
            liter.setText("3L");
            filledBottle.setImageResource(R.drawable.ic_filled_bottle_80);
        } else {
            // ic_bottle_full or 100% filled
            liter.setText("4L");
            filledBottle.setImageResource(R.drawable.ic_bottle_full);
            Toast.makeText(this,"Water is Full",Toast.LENGTH_SHORT).show();
        }
    }
}
