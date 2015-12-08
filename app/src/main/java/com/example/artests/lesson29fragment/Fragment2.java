package com.example.artests.lesson29fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by artests on 04.12.2015.
 */
public class Fragment2 extends Fragment {
    private TextView mInfoTextView;
    private ImageView mCatImageView;
    private String[] mCatDescriptionArray;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View rootView=inflater.inflate(R.layout.fragment2,container,false);

        mInfoTextView=(TextView)rootView.findViewById(R.id.textView1);
        mCatImageView=(ImageView)rootView.findViewById(R.id.imageView1);
        mCatDescriptionArray =getResources().getStringArray(R.array.cats);
        return rootView;
    }

    public void setDescription(int buttonIndex){
        String catDescroption= mCatDescriptionArray[buttonIndex];
        mInfoTextView.setText(catDescroption);
        switch (buttonIndex){
            case 1:
                mCatImageView.setImageResource(R.drawable.cat_yellow);
                break;
            case 2:
                mCatImageView.setImageResource(R.drawable.cat_white);
                break;
            case 3:
                mCatImageView.setImageResource(R.drawable.cat_green);
                break;
        }
    }
}
