package com.example.mobilecomputing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Toast.makeText(getApplicationContext(),"Image successfully uploaded!!",Toast.LENGTH_LONG).show();
        Button btn  =  findViewById(R.id.button2);
        Button btn2  = findViewById(R.id.button3);
        Intent intent = new Intent(this, MainActivity.class);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intent);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
                finish();
                System.exit(0);

            }
        });

    }
}