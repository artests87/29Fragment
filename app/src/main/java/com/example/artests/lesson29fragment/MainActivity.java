package com.example.artests.lesson29fragment;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity implements Fragment1.OnSelectedButtonListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        FragmentManager fragmentManager=getFragmentManager();

        Fragment2 fragment2=(Fragment2)fragmentManager.findFragmentById(R.id.fragment2);
        if (fragment2==null || !fragment2.isVisible()){
            Intent intent = new Intent(this,SecondActivity.class);
            intent.putExtra("buttonIndex",buttonIndex);
            startActivity(intent);
        }
        else {
            fragment2.setDescription(buttonIndex);
        }
    }
}
