package com.adamrobson;

public class TimingThread extends Thread {

    private boolean continueLoop = true;

    public void run() {
        while (continueLoop) {
            System.out.println("Running Timing Thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void kill() {
        continueLoop = false;
    }
}
