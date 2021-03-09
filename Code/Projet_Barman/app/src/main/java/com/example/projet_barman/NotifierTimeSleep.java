package com.example.projet_barman;

public class NotifierTimeSleep implements Runnable{

    private long milli = 0;

    public NotifierTimeSleep(long millisecondes_sleep){ this.milli = millisecondes_sleep;}

    @Override
    public void run() {
        try {
            Thread.sleep(milli);
        }catch (InterruptedException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
