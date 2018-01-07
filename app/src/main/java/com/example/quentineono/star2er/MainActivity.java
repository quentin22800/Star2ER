package com.example.quentineono.star2er;

import android.app.DatePickerDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.TimePickerDialog;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.quentineono.star2er.dummy.DummyContent;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements Fragment1.OnFragment1Listener, Fragment2.OnFragment2Listener, Fragment3.OnFragment3Listener{

    private Fragment1 f1;
    private Fragment2 f2;
    private Fragment3 f3;
    private FragmentManager fm;
    private boolean isLarge;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = this.getFragmentManager();
        isLarge = this.getResources().getBoolean(R.bool.isLarge);
        if(isLarge){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        }
        initFragments();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onDateClickListener() {
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        f1.setDate(year,monthOfYear+1,dayOfMonth);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    @Override
    public void onTimeClickListener() {
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        f1.setTime(hourOfDay,minute);
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    private void initFragments(){
        f1 = (Fragment1) fm.findFragmentById(R.id.fragment_1);
        f2 = (Fragment2) fm.findFragmentById(R.id.fragment_2);
        f3 = (Fragment3) fm.findFragmentById(R.id.fragment_3);

        FragmentTransaction ft = fm.beginTransaction();

        if(!isLarge) {
            ft.hide(f2);
            ft.hide(f3);
        }
        ft.commit();
    }

    @Override
    public void onFragment3Interaction(Uri uri) {

    }

    @Override
    public void onFragment2Interaction(DummyContent.DummyItem item) {

    }
}
