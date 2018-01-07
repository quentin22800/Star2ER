package com.example.quentineono.star2er;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment3.OnFragment3Listener} interface
 * to handle interaction events.
 * Use the {@link Fragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment3 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String STATE_LIGNE = "ligne";
    private static final String STATE_DIRECTION = "direction";
    private static final String STATE_ARRET = "arret";
    private static final String STATE_HEUREDEBUT = "heureDebut";
    private static final String STATE_HEUREFIN = "heureFin";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView tLigne, tDirection, tArret, tHeureDebut, tHeureFin;

    private OnFragment3Listener mListener;

    public Fragment3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment3.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment3 newInstance(String param1, String param2) {
        Fragment3 fragment = new Fragment3();
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
        View v = inflater.inflate(R.layout.fragment_fragment3, container, false);

        tLigne = v.findViewById(R.id.textLigne);
        tDirection = v.findViewById(R.id.textDirection);
        tArret = v.findViewById(R.id.textArret);
        tHeureDebut = v.findViewById(R.id.textHeureDebut);
        tHeureFin = v.findViewById(R.id.textHeureFin);

        if(savedInstanceState != null){
            tLigne.setText(savedInstanceState.getString(STATE_LIGNE));
            tDirection.setText(savedInstanceState.getString(STATE_DIRECTION));
            tArret.setText(savedInstanceState.getString(STATE_ARRET));
            tHeureDebut.setText(savedInstanceState.getString(STATE_HEUREDEBUT));
            tHeureFin.setText(savedInstanceState.getString(STATE_HEUREFIN));
        }
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragment3Interaction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragment3Listener) {
            mListener = (OnFragment3Listener) context;
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
    public interface OnFragment3Listener {
        // TODO: Update argument type and name
        void onFragment3Interaction(Uri uri);
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_LIGNE,tLigne.getText().toString());
        outState.putString(STATE_DIRECTION,tDirection.getText().toString());
        outState.putString(STATE_ARRET,tArret.getText().toString());
        outState.putString(STATE_HEUREDEBUT,tHeureDebut.getText().toString());
        outState.putString(STATE_HEUREFIN,tHeureFin.getText().toString());
    }
}
