package com.example.walts.projetowidgets.nativo;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.walts.projetowidgets.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CallFragment extends Fragment {

    EditText campoTelefone;
    Button btnChamar;

    public CallFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_call, container, false);


        campoTelefone = (EditText) view.findViewById(R.id.edPhone);
        Button buttonPhone = (Button) view.findViewById(R.id.btnPhone);
        buttonPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String telefone = campoTelefone.getText().toString();
                Uri uri = Uri.parse("tel:" + telefone);
                Intent intent = new Intent(Intent.ACTION_CALL,uri);
                if(ContextCompat.checkSelfPermission(getActivity().getApplicationContext(),Manifest.permission.CALL_PHONE)==PackageManager.PERMISSION_GRANTED){
                    startActivity(intent);
                }else{
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1);
                }
            }
        });
        return view;
    }

}
