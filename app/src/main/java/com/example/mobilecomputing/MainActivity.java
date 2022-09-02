package com.example.mobilecomputing;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.lang.annotation.Native;

public class MainActivity extends AppCompatActivity {
    private final int CAMERA_REQ_CODE = 100;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        img  = findViewById(R.id.img);
        Button btn  =  findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imgintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(imgintent, CAMERA_REQ_CODE);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
       super.onActivityResult(requestCode,resultCode,data);
        setContentView(R.layout.activity_main2);
       if (resultCode == RESULT_OK){
           if(requestCode == CAMERA_REQ_CODE){
               Bitmap image  = (Bitmap) data.getExtras().get("data");
               System.out.println(image.getHeight());
               System.out.println(image.getWidth());
               img = findViewById(R.id.imgnew);
               img.setImageBitmap(image);
               System.out.println(image);
               System.out.println("in Activity 1");
               Intent intent = new Intent(this, MainActivity2.class);
               intent.putExtra("test",image);
//               intent.putExtra("BitmapImage", byteArray);
//               Intent i = new Intent(this, MainActivity2.class);
               startActivity(intent);
           }
//
       }
    }
}