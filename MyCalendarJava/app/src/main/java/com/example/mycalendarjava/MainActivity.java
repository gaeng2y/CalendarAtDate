package com.example.mycalendarjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.time.LocalDate;
import java.time.chrono.JapaneseChronology;
import java.time.chrono.JapaneseDate;
import java.time.chrono.ThaiBuddhistDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar cal = Calendar.getInstance();
        String type = cal.getCalendarType();
        Log.d("calType", type);
        // calType: gregory

        String date = "2022-05-24";
        LocalDate gregorianDate = LocalDate.parse(date);

        DateTimeFormatter japEraDtf = DateTimeFormatter.ofPattern("GGGGy年M月d日")
                .withChronology(JapaneseChronology.INSTANCE)
                .withLocale(Locale.JAPAN);

        JapaneseDate jpDate = JapaneseDate.from(gregorianDate);
        Log.d("jap:::", jpDate.format(japEraDtf));
        // jap:::: 令和4年5月24日
        ThaiBuddhistDate buDate = ThaiBuddhistDate.from(gregorianDate);
        Log.d("bud:::", buDate.toString());
        // bud:::: ThaiBuddhist BE 2565-05-24
    }
}