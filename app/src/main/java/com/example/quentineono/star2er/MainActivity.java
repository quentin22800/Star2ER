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

    private static final String STATE_YEAR = "year";
    private static final String STATE_MONTH = "month";
    private static final String STATE_DAY = "day";
    private static final String STATE_HOUR = "hour";
    private static final String STATE_MINUTE = "minute";
    private Fragment1 f1;
    private Fragment2 f2;
    private Fragment3 f3;
    private FragmentManager fm;
    private boolean isLarge, isLandscape;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = this.getFragmentManager();
        isLarge = this.getResources().getBoolean(R.bool.isLarge);
        isLandscape = this.getResources().getBoolean(R.bool.isLandscape);
        if(isLarge){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        }
        if(savedInstanceState != null){
            mYear = savedInstanceState.getInt(STATE_YEAR);
            mMonth = savedInstanceState.getInt(STATE_MONTH);
            mDay = savedInstanceState.getInt(STATE_DAY);
            mHour = savedInstanceState.getInt(STATE_HOUR);
            mMinute = savedInstanceState.getInt(STATE_MINUTE);
        }
        initFragments(savedInstanceState);
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

    private void initFragments(Bundle savedInstanceState){
        f1 = (Fragment1) fm.findFragmentById(R.id.fragment_1);
        f2 = (Fragment2) fm.findFragmentById(R.id.fragment_2);
        f3 = (Fragment3) fm.findFragmentById(R.id.fragment_3);

        FragmentTransaction ft = fm.beginTransaction();

        if(!isLarge){
            Toast.makeText(getApplicationContext(),"ok1",Toast.LENGTH_LONG).show();
            if(!isLandscape) {
                Toast.makeText(getApplicationContext(),"ok2",Toast.LENGTH_LONG).show();
                ft.hide(f2);
            } else if (savedInstanceState != null){
                Toast.makeText(getApplicationContext(),"ok",Toast.LENGTH_LONG).show();
                ft.show(f2);
            }
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

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_YEAR,mYear);
        outState.putInt(STATE_MONTH,mMonth);
        outState.putInt(STATE_DAY,mDay);
        outState.putInt(STATE_HOUR,mHour);
        outState.putInt(STATE_MINUTE,mMinute);
    }
}
