package com.example.ejfrm.scheduler;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context ctx = MainActivity.this;

        final CalendarView cal = findViewById(R.id.calendar);
        final TimePicker time = findViewById(R.id.timePicker);
        final TextView today = findViewById(R.id.today);
        // 자바에서 오늘 날짜 가져오는 방법
        today.setText(new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date()));
        final TextView year = findViewById(R.id.year);
        final TextView date = findViewById(R.id.date);
        final TextView month = findViewById(R.id.month);
        final TextView hour = findViewById(R.id.hour);
        final TextView minute = findViewById(R.id.minute);



        //자바에서는 월이 0~11 까지 배열로 담겨있기에 +1
        //달력이 값을 유지한상태에서 시계로 넘어가야하기에 cal을 참조
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                temp = year+"-" + (month+1)+ "-"+ dayOfMonth;
            }
        });

        time.setVisibility(View.INVISIBLE); //시계가 보이지 않게함






        findViewById(R.id.rdDate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                time.setVisibility(View.INVISIBLE); //시계가 보이지 않게함
                cal.setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.rdTime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cal.setVisibility(View.INVISIBLE);
                time.setVisibility(View.VISIBLE);

            }
        });
        findViewById(R.id.confirmBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("선택한 날짜",temp);
                String[] arr = temp.split("-");
                year.setText(arr[0]);
                month.setText(arr[1]);
                date.setText(arr[2]);
                hour.setText(time.getHour()+""); // int형을 String형으로 변환
                minute.setText(String.valueOf(time.getMinute())); //또는 스트링밸류로 변환

            }
        });

    }
}
