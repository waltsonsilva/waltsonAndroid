package com.example.walts.projetowidgets.nativo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.walts.projetowidgets.R;

public class CallActivity extends AppCompatActivity implements View.OnClickListener {

    EditText campoTelefone;
    Button btnChamar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        Button buttonPhone = (Button)findViewById(R.id.btnPhone);
        buttonPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        campoTelefone = (EditText) findViewById(R.id.edPhone);
        String telefone = campoTelefone.getText().toString();
        Uri uri = Uri.parse("tel:" + telefone);
        Intent intent = new Intent(Intent.ACTION_CALL,uri);
        startActivity(intent);

    }



    }


