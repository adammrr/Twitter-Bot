package com.adamrobson;

import com.adamrobson.handlers.KeyHandler;
import com.adamrobson.handlers.WeatherHandler;

import java.util.Scanner;

public class Main {

    static TimingThread thread = new TimingThread();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Initialising Twitter Bot\n");

        System.out.println("Init: Checking Local Files");
        // TODO: Add Twitter Keys to KeyHandler
        KeyHandler keyHandler = new KeyHandler();
        if(!keyHandler.validateKeys()){
            System.exit(1);
        }

        System.out.println("Init: Fetching Weather Data");
        // TODO: Setup DownloadHandler
        // TODO: Setup WeatherHandler
        WeatherHandler weatherHandler = new WeatherHandler(keyHandler);

        weatherHandler.updateLocationData("310012");

        System.out.println("Init: Starting Thread");
        thread.start();

        System.out.println("Initialisation Complete\n");

        System.out.println("[TEMP] Enter a string to kill thread and exit system.");
        sc.next();
        thread.kill();

    }
}
