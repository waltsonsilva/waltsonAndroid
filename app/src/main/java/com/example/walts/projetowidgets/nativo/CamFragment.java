package com.example.walts.projetowidgets.nativo;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.walts.projetowidgets.R;


public class CamFragment extends Fragment {


    ImageView imageView;
    private Bitmap bitmap;
    Button btnGirar;
    Button btnVoltar;

    public CamFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cam, container, false);

        imageView  = (ImageView) view.findViewById(R.id.imgViewCamera);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abriCamera();

            }
        });
        btnGirar = (Button) view.findViewById(R.id.btnGirar);
        btnGirar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callGirar(v);
            }
        });

        btnVoltar = (Button) view.findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callVoltar(v);
            }
        });

        return view;
    }



    private void abriCamera() {
        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intentCamera, 0);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @android.support.annotation.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (data != null) {
            Bundle bundle = data.getExtras();

            if (bundle != null) {
                Bitmap bitmap = (Bitmap) bundle.get("data");
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
