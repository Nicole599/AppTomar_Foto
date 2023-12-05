package com.example.apptomar_foto;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.View;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button btnCamara;
    ImageView picture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        picture = findViewById(R.id.picture);
        btnCamara = findViewById(R.id.btncamara);

        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                camara();
            }
        });
    }
    // Abrir la cámara
    private void camara() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 1);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap pictureBitmap = (Bitmap) extras.get("data");
            picture.setImageBitmap(pictureBitmap);
        }
    }
}