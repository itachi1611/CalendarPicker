package com.foxy.calendarpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.maxproj.calendarpicker.Builder;
import com.maxproj.calendarpicker.Config.MyConfig;
import com.maxproj.calendarpicker.Models.CalendarDay;
import com.maxproj.calendarpicker.Models.YearMonthDay;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCalendarPicker(View view) {
        Builder builder = new Builder(MainActivity.this, new Builder.CalendarPickerOnConfirm() {
            @Override
            public void onComplete(YearMonthDay yearMonthDay) {
                MyConfig.uiToast("You pick " + yearMonthDay.year + "-" + yearMonthDay.month + "-" + yearMonthDay.day);
            }
        })
                .setPromptText("Pick a date")
                .setPromptSize(18)
                .setPromptColor(Color.RED)
                .setPromptBgColor(0xFFFFFFFF)

                .setSelectedText("Selected")
                .setSelectedSize(14)
                .setSelectedColor(Color.WHITE)
                .setSelectedBgColor(0xFF1E90FF)

                .setTodayText("Today")
                .setTodaySize(14)
                .setTodayColor(Color.DKGRAY)
                .setTodayBgColor(Color.YELLOW)

                .setMonthTitle(new Builder.FormatMonthTitle() {
                    @Override
                    public String setMonthTitle(int year, int month) {
                        return "" +year + "年" + month + "月";
                    }
                })
                .setMonthTitleSize(16)
                .setMonthTitleColor(0xFFB22222)
                .setMonthTitleBgColor(0x00000000)

                .setWeekIndex(new String[]{"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"})
                .setWeekIndexSize(16)
                .setWeekIndexColor(0xFFFF00FF)
                .setWeekIndexBgColor(0x00000000)

                .setCancelText("Cancel")
                .setCancelSize(14)
                .setCancelColor(Color.RED)
                .setCancelBgColor(0xFFFFFFFF)

                .setConfirmText("Confirm")
                .setConfirmSize(14)
                .setConfirmColor(Color.RED)
                .setConfirmBgColor(0xFFB0E0E6)

                .setPreset(new YearMonthDay(2017, 11, 4))
                .setDaySize(16)
                .setDayColor(Color.BLUE)
                .setDayOtherMonthColor(0xFF87CEFA)
                .setMonthBaseBgColor(0xFFD0EED0)

                .setJump2Preset(true);
                //.restoreDefault();

        builder.show();
    }
}
