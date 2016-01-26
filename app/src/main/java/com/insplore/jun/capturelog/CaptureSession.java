package com.insplore.jun.capturelog;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CaptureSession.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CaptureSession#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class CaptureSession extends Fragment {
    private static final String ARG_INPUT_TEXT = "input_text";
    private static final String ARG_INPUT_SOUND = "input_sound";
    private static final String ARG_CATEGORY = "category";

    private String categoryText;
    private Boolean inputText;
    private Boolean inputSound;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param input_text Parameter 1.
     * @param input_sound Parameter 2.
     * @param category Parameter 3.
     * @return A new instance of fragment CaptureSession.
     */
    // TODO: Rename and change types and number of parameters
    public static CaptureSession newInstance(String input_text, String input_sound, String category) {
        CaptureSession fragment = new CaptureSession();
        Bundle args = new Bundle();
        args.putString(ARG_INPUT_TEXT, input_text);
        args.putString(ARG_INPUT_SOUND, input_sound);
        args.putString(ARG_CATEGORY, category);
        fragment.setArguments(args);
        return fragment;
    }
    public CaptureSession() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            categoryText = getArguments().getString(ARG_CATEGORY);
            inputText = getArguments().getBoolean(ARG_INPUT_TEXT);
            inputSound = getArguments().getBoolean(ARG_INPUT_SOUND);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_capture_session, container, false);
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
}
