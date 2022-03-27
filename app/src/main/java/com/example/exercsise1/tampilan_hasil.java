package com.example.exercsise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class tampilan_hasil extends AppCompatActivity {

    // Membuat Variable TextView
    TextView VieTask, VieJenis, VieTime;

    String sTask, sJenis, sTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan_hasil);

        // Memanggil Variable TextView yg ada di dalam Id
        VieTask = findViewById(R.id.hlTask);
        VieJenis = findViewById(R.id.hlJenis);
        VieTime = findViewById(R.id.hlTime);

        // Penggunaan Bundle
        Bundle bundle = getIntent().getExtras();

        // Mengambil bundel dari kelas Task
        sTask = bundle.getString("task");
        sJenis = bundle.getString("jenis");
        sTime = bundle.getString("time");

        VieTask.setText(sTask);
        VieJenis.setText(sJenis);
        VieTime.setText(sTime);
    }

}