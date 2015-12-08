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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View rootView=inflater.inflate(R.layout.fragment1,container,false);
        Button button1=(Button)rootView.findViewById(R.id.button1);
        Button button2=(Button)rootView.findViewById(R.id.button2);
        Button button3=(Button)rootView.findViewById(R.id.button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        //Toast.makeText(getActivity(),getString(R.string.clickButton)+"--"+translatedIdToIndex(v.getId()),Toast.LENGTH_SHORT).show();
        int buttonIndex=translatedIdToIndex(v.getId());
        OnSelectedButtonListener onSelectedButtonListener=(OnSelectedButtonListener) getActivity();
        onSelectedButtonListener.onButtonSelected(buttonIndex);
    }

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
}
