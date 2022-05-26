package com.example.mycalendar

import android.icu.util.BuddhistCalendar
import android.icu.util.JapaneseCalendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.time.LocalDate
import java.time.chrono.JapaneseChronology
import java.time.chrono.JapaneseDate
import java.time.chrono.ThaiBuddhistDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendar: Calendar = Calendar.getInstance()
        val calendarType = calendar.calendarType
        Log.d("calendarType", calendarType)
        // 2022-05-26 18:39:49.330 13962-13962/com.example.mycalendar D/calendarType: gregory

        val japaneseEraDtf: DateTimeFormatter = DateTimeFormatter.ofPattern("GGGGy年M月d日")
            .withChronology(JapaneseChronology.INSTANCE)
            .withLocale(Locale.JAPAN)

        val date = "2022-05-24"
        val gregorianDate: LocalDate = LocalDate.parse(date)
        val japaneseDate: JapaneseDate = JapaneseDate.from(gregorianDate)
        val buddhistDate: ThaiBuddhistDate = ThaiBuddhistDate.from(gregorianDate)
        Log.d("jap:::", japaneseDate.format(japaneseEraDtf))
        Log.d("bud:::", buddhistDate.toString())
    }
}