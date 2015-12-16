package com.example.artests.lesson29fragment;

/**
 * Created by artests on 14.12.2015.
 */
public interface Communicator {
    public void count(String data);

    void setData(String data);
    String getData();


    public void setmCounter(int counter);
    public int getmCounter();
}
