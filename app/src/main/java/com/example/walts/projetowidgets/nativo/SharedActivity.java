package com.example.walts.projetowidgets.nativo;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.ShareActionProvider;

import com.example.walts.projetowidgets.R;

import java.util.zip.Inflater;

public class SharedActivity extends AppCompatActivity {

    private ShareActionProvider mShareActionProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_shared, menu);

        ShareActionProvider shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menu.findItem(R.id.action_shared));
        shareActionProvider.setShareIntent(shareIt());

        return true;
    }



    private Intent shareIt() {
        Intent intent= new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");

        String shareMsgBody = "Hello, Share this with world !!";

        intent.putExtra(Intent.EXTRA_TEXT, shareMsgBody);
        startActivity(Intent.createChooser(intent, "Spread the message!!"));
        return intent;
    }
}


