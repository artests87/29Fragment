package com.example.artests.lesson29fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements Fragment1.OnSelectedButtonListener, Communicator {
    private boolean mIsDynamic;
    private FragmentManager mFragmentManager;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private WithTextViewFragment fragment3;
    private int numberFragment=0;
    private String mData="0000";
    private int mIndex;
    private int mCounter=0;
    // Значение по умолчанию
    private static final int BUTTON_INDEX_DEFAULT = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager =getFragmentManager();
        fragment1 = (Fragment1) mFragmentManager.findFragmentById(R.id.fragment1);
        fragment2 = (Fragment2) mFragmentManager.findFragmentById(R.id.fragment2);
        fragment3=new WithTextViewFragment();
        mIsDynamic=fragment2==null||!fragment2.isInLayout();
        //Toast.makeText(getApplicationContext(),mIsDynamic+"",Toast.LENGTH_SHORT).show();
        if (savedInstanceState!=null) {
            numberFragment = savedInstanceState.getInt("numberFragment");
            mData=savedInstanceState.getString("stringFragment");
            mIndex=savedInstanceState.getInt("indexFragment");
            mCounter=savedInstanceState.getInt("counterFragment",0);
            Toast.makeText(this,numberFragment+"",Toast.LENGTH_SHORT).show();
        }
        if (mIsDynamic){
            fragment1=new Fragment1();
            fragment2=new Fragment2();
            loadFragment();}


    }
    private void loadFragment(){

        switch (numberFragment){
            case 2:
                loadFragment2(mIndex);
                break;
            case 3:
                count(mData);
                break;
            default:
                FragmentTransaction fragmentTransaction= mFragmentManager.beginTransaction();
                //fragment1=new Fragment1();
                LinearLayout verticalLayout = (LinearLayout) findViewById(R.id.container);
                verticalLayout.removeAllViews();
                fragmentTransaction.add(R.id.container,fragment1,"fragment1");
                fragmentTransaction.commit();
                numberFragment=1;
        }
    }
    private void loadFragment2(int buttonIndex) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragment2 = new Fragment2();
        mIndex=buttonIndex;
        Bundle args = new Bundle();
        args.putInt(Fragment2.BUTTON_INDEX, buttonIndex);
        fragment2.setArguments(args);
        fragmentTransaction.replace(R.id.container, fragment2, "fragment2");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        fragmentTransaction.commit();
        numberFragment=2;
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

            if (mIsDynamic) {
                loadFragment2(buttonIndex);
            } else {
                fragment2 = (Fragment2) mFragmentManager.findFragmentById(R.id.fragment2);
                if(buttonIndex!=BUTTON_INDEX_DEFAULT && buttonIndex<4){
                    fragment2.setDescription(buttonIndex);
                }
            }


    }

    @Override
    public void onBackPressed() {
        //Fragment1 fragment1=(Fragment1)mFragmentManager.findFragmentById(R.id.fragment1);
        boolean bool=true;
        if (findViewById(R.id.container)!=null) {
            //bool = !fragment1.isRemoving();
            if (numberFragment==2||numberFragment==3){
                bool=false;
            }
        }
        Toast.makeText(this,(bool)+"",Toast.LENGTH_SHORT).show();
        if(mIsDynamic && !bool){
            FragmentTransaction fragmentTransaction= mFragmentManager.beginTransaction();
            LinearLayout verticalLayout = (LinearLayout) findViewById(R.id.container);
            verticalLayout.removeAllViews();
            fragmentTransaction.replace(R.id.container, fragment1, "fragment1");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
            //fragmentTransaction.add(R.id.container, fragment1, "fragment1");
            fragmentTransaction.commit();
            numberFragment=1;

        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public void count(String data) {
        mData=data;
        fragment3=(WithTextViewFragment)mFragmentManager.findFragmentById(R.id.fragment3);
        if (mIsDynamic) {
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragment3=new WithTextViewFragment();
            fragmentTransaction.replace(R.id.container, fragment3, "fragment3");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
            fragmentTransaction.commit();
            mFragmentManager.executePendingTransactions();
            numberFragment=3;
        }
        fragment3.setmTextView();
    }

    @Override
    public void setData(String data) {
        mData=data;
    }

    @Override
    public String getData() {
        return mData;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("numberFragment", numberFragment);
        outState.putInt("counterFragment", mCounter);
        outState.putString("stringFragment", mData);
    }

    public void setmCounter(int counter){
        mCounter=counter;
    }
    public int getmCounter(){
        return  mCounter;
    }

}
