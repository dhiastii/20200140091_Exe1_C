package com.example.exercsise1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class tampilan_task extends AppCompatActivity {

    EditText task,jenis,time;

    FloatingActionButton btnAction;

    TextView Txtnama;

    String sNama, sTask, sJenis, sTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan_task);

        task    = findViewById(R.id.tkTask);
        jenis   = findViewById(R.id.tkJenis);
        time    = findViewById(R.id.tkTime);

        btnAction   = findViewById(R.id.flnButton);

        Txtnama = findViewById(R.id.gtNama);


        // Penggunaan Bundle
        Bundle bundle = getIntent().getExtras();

        // Mendapatkan Bundle Register
        sNama = bundle.getString("a");

        Txtnama.setText(sNama);

        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sTask = task.getText().toString();
                sJenis = jenis.getText().toString();
                sTime = time.getText().toString();

                if(sJenis.length() == 0){
                    jenis.setError("Jenis Task!");

                    Toast.makeText(getApplicationContext(), "Isi Semua Data", Toast.LENGTH_SHORT).show();
                }
                else  if(sTime.length() == 0){
                    time.setError("Lama Task!");

                    Toast.makeText(getApplicationContext(), "Isi Semua Data", Toast.LENGTH_SHORT).show();
                }
                else if(sTask.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Isi Semua Data", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Berhasil!", Toast.LENGTH_SHORT).show();

                    Bundle bundle = new Bundle();

                    bundle.putString("task", sTask.trim());
                    bundle.putString("jenis", sJenis.trim());
                    bundle.putString("time", sTime.trim());

                    Intent data = new Intent(getApplicationContext(), tampilan_hasil.class);

                    data.putExtras(bundle);

                    startActivity(data);
                }
            }
        });
    }

    // Option Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Membuat Kondisi
        if(item.getItemId() == R.id.itSubmit){

            task    = findViewById(R.id.tkTask);
            jenis   = findViewById(R.id.tkJenis);
            time    = findViewById(R.id.tkTime);

            sTask = task.getText().toString();
            sJenis = jenis.getText().toString();
            sTime = time.getText().toString();

            if(sJenis.length() == 0){
                jenis.setError("Jenis Task!");

                Toast.makeText(getApplicationContext(), "Isi Semua Data", Toast.LENGTH_SHORT).show();
            }
            else  if(sTime.length() == 0){
                time.setError("Lama Task!");

                Toast.makeText(getApplicationContext(), "Isi Semua Data", Toast.LENGTH_SHORT).show();
            }
            else if(sTask.isEmpty()){
                Toast.makeText(getApplicationContext(), "Isi Semua Data", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "Berhasil!", Toast.LENGTH_SHORT).show();

                Bundle bundle = new Bundle();

                bundle.putString("task", sTask.trim());
                bundle.putString("jenis", sJenis.trim());
                bundle.putString("time", sTime.trim());

                Intent data = new Intent(getApplicationContext(), tampilan_hasil.class);

                data.putExtras(bundle);

                startActivity(data);
            }

        }
        else {
            Intent out = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(out);
        }

        return super.onOptionsItemSelected(item);
    }
}