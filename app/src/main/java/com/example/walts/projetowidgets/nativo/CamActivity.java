package com.example.walts.projetowidgets.nativo;



import android.content.Intent;
import android.graphics.Bitmap;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.example.walts.projetowidgets.R;




public class CamActivity extends AppCompatActivity {

    ImageView imageView;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam);

        imageView = findViewById(R.id.imgViewCamera);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abriCamera();
            }
        });
    }

    private void abriCamera() {
        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intentCamera, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @android.support.annotation.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        if(data != null){
            Bundle bundle = data.getExtras();

            if (bundle != null){
                Bitmap bitmap =(Bitmap) bundle.get("data");
                //atualizar a imagem
                imageView.setImageBitmap(bitmap);
            }
        }
    }





    public void callGirar(View v){
        imageView.setRotation(90);
    }

    public void callVoltar(View v){
        imageView.setRotation(0);
    }

}
