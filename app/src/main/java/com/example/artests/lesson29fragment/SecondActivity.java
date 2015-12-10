package com.example.artests.lesson29fragment;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class SecondActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        int buttonIndex=intent.getIntExtra("buttonIndex", -1);
        if (buttonIndex!=-1){
            FragmentManager fragmentManager=getFragmentManager();
            Fragment2 fragment2 = (Fragment2) fragmentManager.findFragmentById(R.id.fragment2);
            fragment2.setDescription(buttonIndex);
        }
    }

}
