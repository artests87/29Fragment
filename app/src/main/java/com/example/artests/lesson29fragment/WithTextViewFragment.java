package com.example.artests.lesson29fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by artests on 14.12.2015.
 */
public class WithTextViewFragment extends Fragment {
    private Communicator mCommunicator;
    private TextView mTextView;
    //private String mData;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View rootView=inflater.inflate(R.layout.fragment_with_textview,container,false);
        mTextView=(TextView)rootView.findViewById(R.id.textView);
        /*if(savedInstanceState==null){

        }
        else{
            mData=savedInstanceState.getString("text");
            mTextView.setText(mData);
        }*/
        return rootView;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mCommunicator=(Communicator)getActivity();
        setmTextView();
    }
    /*@Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text",mData);
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void setmTextView() {
        if (mTextView==null) {

        }
        else {
            //mData=data;
            mTextView.setText(mCommunicator.getData());
        }
    }
}
