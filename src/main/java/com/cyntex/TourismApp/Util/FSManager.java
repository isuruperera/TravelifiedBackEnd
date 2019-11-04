package com.cyntex.TourismApp.Util;

import javax.xml.bind.DatatypeConverter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FSManager {

    public static void saveImage(String imageID, String base64String) {
        try {
  
            File file = new File(imageID);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter("images/" + imageID + ".pic"));
            writer.write(base64String);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] retrieveImage(String imageID) {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get("images/" + imageID + ".pic"));
            String fileAsString = new String(encoded, StandardCharsets.US_ASCII);
            return DatatypeConverter.parseBase64Binary(fileAsString);
        } catch (Exception e) {
            return null;
        }

    }
}
