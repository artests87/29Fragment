package com.example.artests.lesson29fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by artests on 04.12.2015.
 */
public class Fragment1 extends Fragment implements View.OnClickListener{

    //private int mCounter=0;
    private Communicator mCommunicator;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View rootView=inflater.inflate(R.layout.fragment1, container, false);
        Button button1=(Button)rootView.findViewById(R.id.button1);
        Button button2=(Button)rootView.findViewById(R.id.button2);
        Button button3=(Button)rootView.findViewById(R.id.button3);
        Button button4=(Button)rootView.findViewById(R.id.button4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        //Toast.makeText(getActivity(),getString(R.string.clickButton)+"--"+translatedIdToIndex(v.getId()),Toast.LENGTH_SHORT).show();
        int buttonIndex=translatedIdToIndex(v.getId());
        if (buttonIndex==-1){
            mCommunicator.setmCounter(mCommunicator.getmCounter()+1);// mCounter++;
            String data=getString(R.string.countCatAdd1)+" "+mCommunicator.getmCounter()+" "+getString(R.string.countCatAdd2);
            mCommunicator.count(data);
            mCommunicator.setData(data);
        }
        else {
            OnSelectedButtonListener onSelectedButtonListener = (OnSelectedButtonListener) getActivity();
            onSelectedButtonListener.onButtonSelected(buttonIndex);
        }
    }

    /*@Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter",mCounter);
    }*/

    private int translatedIdToIndex(int id) {
        int index=-1;
        switch (id){
            case R.id.button1:
                index=1;
                break;
            case R.id.button2:
                index=2;
                break;
            case R.id.button3:
                index=3;
                break;
        }
        return index;
    }

    public interface OnSelectedButtonListener {
        void onButtonSelected(int buttonIndex);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mCommunicator=(Communicator)getActivity();
    }
   /* @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState!=null){
            mCounter=savedInstanceState.getInt("counter",0);
        }
        else {
            mCounter=0;
        }
    }*/
}
