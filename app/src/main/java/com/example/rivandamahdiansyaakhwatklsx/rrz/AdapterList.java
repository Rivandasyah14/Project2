package com.example.rivandamahdiansyaakhwatklsx.rrz;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterList extends ArrayAdapter {

    private final Activity activity;
    private final String[] nama;
    private final int[] gambar;
    private final int[] gambar1;
    private final int[] keterangan;

    public AdapterList(Activity activity, String[] nama, int[] gambar, int[] gambar1, int[] keterangan) {
        super(activity, R.layout.activity_layout2, nama );
        this.activity = activity;
        this.nama = nama;
        this.gambar = gambar;
        this.gambar1 = gambar1;
        this.keterangan = keterangan;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.activity_layout3, null, true);
        TextView txt =  view.findViewById(R.id.txtitem);
        ImageView img = view.findViewById(R.id.imgitem);

        txt.setText(nama[position]);
        img.setImageResource(gambar1[position]);

        return view;
    }





}
