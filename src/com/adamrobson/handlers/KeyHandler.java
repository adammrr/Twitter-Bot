package com.adamrobson.handlers;

import java.io.*;

public class KeyHandler {
    private final String appdataPath = System.getenv().get("APPDATA") + "\\.twitterbot";
    private final String keyFilePath = appdataPath + "\\apiKeys.txt";

    private String metOfficeKey;
    private String otherKey = "TempKeyValue";

    public boolean validateKeys() {
        File dataDir = new File(appdataPath);
        File keyFile = new File(keyFilePath);

        if(!dataDir.exists()){
            // Directory does not exist, create it.
            if(!dataDir.mkdir()){
                System.err.println("Error Creating Directory");
                return false;
            }
        }

        if(!keyFile.exists()){
            // Api Keys File does not exist, create it.
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(keyFile));
                writer.write("#Twitter Bot Key Storage\n#@AdamRobson___\n#\n#Only edit the line below each tag.\n#\n#Met Office\nReplaceKeyHere");
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        if(!importKeys(keyFile)){
            System.err.println("Error fetching API Keys. Please check your keys: " + keyFilePath);
            return false;
        }

        return true;
    }

    private boolean importKeys(File keyFile){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(keyFile));
            String line = reader.readLine();
            while((line != null) && (!line.equals("ReplaceKeyHere"))){
                if(!line.startsWith("#")){
                    System.out.println(line);
                    metOfficeKey = line;
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return metOfficeKey != null && otherKey != null;
    }

    public String getMetOfficeKey(){
        return metOfficeKey;
    }

}

