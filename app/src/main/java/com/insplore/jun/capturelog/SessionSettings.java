package com.insplore.jun.capturelog;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SessionSettings.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SessionSettings#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SessionSettings extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String ARG_INPUT_TEXT = "input_text";
    private static final String ARG_INPUT_SOUND = "input_sound";
    private static final String ARG_CATEGORY = "category";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private OnFragmentInteractionListener mListener;

    public SessionSettings() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SessionSettings.
     */
    // TODO: Rename and change types and number of parameters
    public static SessionSettings newInstance(String param1, String param2) {
        SessionSettings fragment = new SessionSettings();
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
        View view = inflater.inflate(R.layout.fragment_session_settings, container, false);

        ToggleButton toggleText = (ToggleButton) getActivity().findViewById(R.id.session_text_togglebutton);
        ToggleButton toggleSound = (ToggleButton) getActivity().findViewById(R.id.session_sound_togglebutton);

        Button startSessionButton = (Button) view.findViewById(R.id.start_session_button);
        startSessionButton.setOnClickListener(this);

        return view;
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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void onClick(View v) {
        Fragment captureSessionFragment = new CaptureSession();
        FragmentManager fragmentManager = getFragmentManager();

        //Get the elements and data
        ToggleButton toggleText = (ToggleButton) getActivity().findViewById(R.id.session_text_togglebutton);
        ToggleButton toggleSound = (ToggleButton) getActivity().findViewById(R.id.session_sound_togglebutton);
        EditText sessionCategory = (EditText) getActivity().findViewById(R.id.session_edittext);
        String sessionCategoryText = sessionCategory.getText().toString();

        //Set arguments for next fragment
        Bundle args = new Bundle();
        args.putString(ARG_CATEGORY, sessionCategoryText );
        args.putBoolean(ARG_INPUT_TEXT, toggleText.isChecked());
        args.putBoolean(ARG_INPUT_SOUND, toggleSound.isChecked());
        captureSessionFragment.setArguments(args);

        //Fragment transactions
        FragmentTransaction fragTransaction = fragmentManager.beginTransaction();
        fragTransaction.replace(R.id.session_fragment, captureSessionFragment);
        fragTransaction.addToBackStack(null);
        fragTransaction.commit();
    }
}
