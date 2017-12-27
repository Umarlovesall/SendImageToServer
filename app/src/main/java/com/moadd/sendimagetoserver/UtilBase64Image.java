package com.moadd.sendimagetoserver;

/**
 * Created by moadd on 23-Oct-17.
 */

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class UtilBase64Image {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static String encoder(File file) {
       // File file = new File(imagePath);
        try (FileInputStream imageInFile = new FileInputStream(file)) {
            // Reading a Image file from file system
            String base64Image = "";
            byte imageData[] = new byte[(int) file.length()];
            imageInFile.read(imageData);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                base64Image = Base64.getEncoder().encodeToString(imageData);
            }
            return base64Image;
        } catch (FileNotFoundException e) {
            System.out.println("Image not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
        }
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void decoder(String base64Image, String pathFile) {
        try (FileOutputStream imageOutFile = new FileOutputStream(pathFile)) {
            // Converting a Base64 String into Image byte array
            byte[] imageByteArray = new byte[0];
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                imageByteArray = Base64.getDecoder().decode(base64Image);
            }

            System.out.println("imges lokesh");
            imageOutFile.write(imageByteArray);
        } catch (FileNotFoundException e) {
            System.out.println("Image not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
        }
    }
}
