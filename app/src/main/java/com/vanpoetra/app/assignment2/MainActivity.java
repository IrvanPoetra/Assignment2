package com.vanpoetra.app.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//Code by: Irvan Pratama Putra (JVAN-KS04-013)
//Assignment 2

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView viewCount;
    Button btnTambah;
    EditText saveText;

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewCount = findViewById(R.id.view_count);
        btnTambah = findViewById(R.id.btn_tambah);
        saveText = findViewById(R.id.savetext);

        btnTambah.setOnClickListener(this);

        if(savedInstanceState != null) {
            String teks = savedInstanceState.getString("teks");
            count = savedInstanceState.getInt("hasil");

            viewCount.setText(Integer.toString(count));

            if(saveText != null) {
                saveText.setText(teks);
            }
        }
    }

    @Override
    public void onClick(View v) {
        count++;
        viewCount.setText(Integer.toString(count));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("teks", String.valueOf(saveText.getText()));
        outState.putInt("hasil", count);
    }


}