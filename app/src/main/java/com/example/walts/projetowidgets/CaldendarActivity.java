package com.example.walts.projetowidgets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.Calendar;

public class CaldendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_view);

        CalendarView  cv = (CalendarView) findViewById(R.id.calendarView);

        cv.getDate();


        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange( CalendarView view, int year, int month, int dayOfMonth) {

                String date = dayOfMonth + "/" + month +"/"+ year;
                Toast.makeText(getApplicationContext(),"Data" + date,Toast.LENGTH_SHORT)
                .show();

            }
        });
    }
}
