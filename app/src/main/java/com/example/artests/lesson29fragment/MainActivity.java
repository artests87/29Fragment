package com.example.artests.lesson29fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements Fragment1.OnSelectedButtonListener {
    private boolean mIsDynamic;
    private FragmentManager mFragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager =getFragmentManager();
        Fragment2 fragment2 = (Fragment2) mFragmentManager.findFragmentById(R.id.fragment2);
        mIsDynamic=fragment2==null||!fragment2.isInLayout();
        Toast.makeText(getApplicationContext(),mIsDynamic+"",Toast.LENGTH_SHORT).show();
        if (mIsDynamic){loadFragment();}
    }
    private void loadFragment(){
        FragmentTransaction fragmentTransaction= mFragmentManager.beginTransaction();
        Fragment1 fragment1=new Fragment1();
        fragmentTransaction.add(R.id.container,fragment1,"fragment1");
        fragmentTransaction.commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onButtonSelected(int buttonIndex) {
        Fragment2 fragment2;
        if (mIsDynamic){
            FragmentTransaction fragmentTransaction= mFragmentManager.beginTransaction();
            fragment2=new Fragment2();
            Bundle args=new Bundle();
            args.putInt(Fragment2.BUTTON_INDEX,buttonIndex);
            fragment2.setArguments(args);
            fragmentTransaction.replace(R.id.container, fragment2, "fragment2");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
            fragmentTransaction.commit();
            mIsDynamic=!fragment2.isInLayout();
        }
        else {
            fragment2=(Fragment2)mFragmentManager.findFragmentById(R.id.fragment2);
            fragment2.setDescription(buttonIndex);
        }
    }

    @Override
    public void onBackPressed() {
        /*Fragment1 fragment1;
        if(!mIsDynamic){
            FragmentTransaction fragmentTransaction= mFragmentManager.beginTransaction();
            fragment1=new Fragment1();
            fragmentTransaction.replace(R.id.container, fragment1, "fragment1");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
            fragmentTransaction.commit();
        }*/
        super.onBackPressed();
    }
}
