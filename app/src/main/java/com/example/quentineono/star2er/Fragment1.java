package com.example.quentineono.star2er;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.sax.TextElementListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;


public class Fragment1 extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private static final String STATE_DATE = "date";
    private static final String STATE_TIME = "time";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragment1Listener mListener;

    private TextView tDate, tTime;
    private Spinner spinLignes, spinDirection;

    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment1, container, false);
        tDate = v.findViewById(R.id.DateText);
        tTime = v.findViewById(R.id.TimeText);
        spinLignes = v.findViewById(R.id.spinLignesBus);
        spinDirection = v.findViewById(R.id.spinDirection);
        spinDirection.setVisibility(View.GONE);
        ////TO DO : make it VISIBLE again
        tDate.setOnClickListener(this);
        tTime.setOnClickListener(this);
        if(savedInstanceState != null){
            tDate.setText(savedInstanceState.getString(STATE_DATE));
            tTime.setText(savedInstanceState.getString(STATE_TIME));
        }
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragment1Listener) {
            mListener = (OnFragment1Listener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.DateText:
                mListener.onDateClickListener();
                break;
            case R.id.TimeText:
                mListener.onTimeClickListener();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (view.getId()){
            case R.id.spinLignesBus:

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragment1Listener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
        void onDateClickListener();
        void onTimeClickListener();
    }

    public void setDate(int year, int month, int day){
        String monthString = ""+month;
        String dayString = ""+day;
        if(month < 10){
            monthString = "0" +month;
        }
        if(day < 10){
            dayString = "0" + day;
        }
        String s = dayString + "/"+ monthString + "/" + year;
        tDate.setText(s);
    }

    public void setTime(int hour, int minute){
        tTime.setText(hour + "h" + minute);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_DATE,tDate.getText().toString());
        outState.putString(STATE_TIME,tTime.getText().toString());
    }
}
