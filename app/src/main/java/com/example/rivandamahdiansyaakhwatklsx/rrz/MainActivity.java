package com.example.rivandamahdiansyaakhwatklsx.rrz;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.io.IOException;

import static com.example.rivandamahdiansyaakhwatklsx.rrz.R.drawable.kerucutdanbola;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button play, stop;
    MediaPlayer mediaPlayer;

    String nama[]= {
            "Kubus", "Balok", "Tabung", "Limas", "Prisma", "Kerucut dan Bola"
    };

    int gambar[] = {
            R.drawable.kubus, R.drawable.balok, R.drawable.tabung, R.drawable.limas, R.drawable.prisma, R.drawable.kerucutdanbola
    };

    int gambar1[] = {
            R.drawable.kubus1, R.drawable.balok1, R.drawable.tabung1, R.drawable.limas1, R.drawable.prisma1, R.drawable.kb1
    };

    int keterangan[] = {
            R.string.ketKubus, R.string.ketBalok, R.string.ketTabung, R.string.ketLimas, R.string.ketPrisma, R.string.ketBola
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.ListView);

        AdapterList adapterList = new AdapterList(this, nama, gambar, gambar1, keterangan);
        listView.setAdapter(adapterList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent q = new Intent(getApplicationContext(), DetailActivity.class) ;
                q.putExtra("nama", nama [position]);
                q.putExtra("gambar", gambar [position]);
                q.putExtra("gambar1", gambar1 [position]);
                q.putExtra("keterangan", keterangan [position]);
                startActivity(q);
            }
        });
        play = findViewById(R.id.btn);
        stop = findViewById(R.id.btn1);
        stop.setEnabled(false);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (play.getText().toString().equals("Pause") && mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    play.setText("Resume");
                } else {
                    mediaPlayer = new MediaPlayer();
                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.cg);
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

                    try {
                        mediaPlayer.setDataSource(getApplicationContext(), uri);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    mediaPlayer.start();
                    play.setText("Pause");
                    stop.setEnabled(true);
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    stop.setEnabled(false);
                    play.setText("Play");
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Peringatan");
        builder.setMessage(" Apakah anda yakin ingin keluar ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Tidak keluar", Toast.LENGTH_SHORT).show();

            }
        });
        builder.show();
    }
}
