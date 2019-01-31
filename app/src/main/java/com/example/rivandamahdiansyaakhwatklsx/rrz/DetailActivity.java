package com.example.rivandamahdiansyaakhwatklsx.rrz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView txtnama, txtket;
    ImageView imgitem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout2);

        txtnama = findViewById(R.id.txt);
        txtket = findViewById(R.id.txt2);
        imgitem = findViewById(R.id.img);

        Intent a = getIntent();
        String nama = a.getStringExtra("nama");
        int gambar = a.getIntExtra("gambar", 0);
        int keterangan = a.getIntExtra("keterangan", 0);

        txtnama.setText(nama);
        txtket.setText(keterangan);
        imgitem.setImageResource(gambar);


    }
}
