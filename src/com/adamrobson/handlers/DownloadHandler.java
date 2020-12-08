package com.adamrobson.handlers;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadHandler {
    private final String dataDirPath = System.getenv().get("APPDATA") + "\\.twitterbot\\data";

    public void downloadFileFromURL(String url, String fileSaveName){
        try {
            File fileDestDir = new File(dataDirPath);
            File fileDest = new File(fileDestDir + "\\" + fileSaveName);

            if(!fileDestDir.exists()){
                // Directory does not exist, create it.
                if(!fileDestDir.mkdir()){
                    System.err.println("Error Creating Directory");
                }
            }

            BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(fileDest);

            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
