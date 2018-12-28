package com.example.walts.projetowidgets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ProgressBarActivity extends AppCompatActivity {

    protected static final int TIMER_RUNTIME = 10000;
    protected boolean nbActive;

    protected ProgressBar nProgressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_bar);

        nProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        final Thread timerThread = new Thread() {
            @Override
            public void run() {
                nbActive = true;
                try {
                    int waited = 0;
                    while (nbActive && (waited < TIMER_RUNTIME)) {
                        sleep(200);
                        if (nbActive) {
                            waited += 200;
                            updateProgress(waited);
                        }

                    }
                } catch (InterruptedException e) {

                } finally {
                    onContinue();
                }

            }

        };
        timerThread.start();




    }
    public void updateProgress(final int timePassed){
        if(null != nProgressBar){
            final int progress = nProgressBar.getMax() * timePassed / TIMER_RUNTIME;
            nProgressBar.setProgress(progress);
        }
    }

    public void onContinue(){
         Log.d("mensagemFinal", "Barra carregada com sucesso");
    }
}
