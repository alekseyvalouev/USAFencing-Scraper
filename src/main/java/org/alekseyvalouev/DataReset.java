package org.alekseyvalouev;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataReset {
    // !FIXME: ONLY RUN THIS ONCE EVER OR IT WILL RESET ALL THE DATA
    public static void initFiles(String[] files) throws IOException {
        StorageWriter mStorageWriter = new StorageWriter();

        ArrayList<Competition> temp = new ArrayList<>();
        for (String file : files) {
            mStorageWriter.setFilename(file);
            mStorageWriter.write(temp);
        }
    }

    public static void main( String[] args ) throws IOException {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("WARNING: YOU ARE ABOUT TO RESET ALL COMPETITION DATA, ARE YOU SURE YOU WISH TO PROCEED (y/n): ");
        String response = myScanner.nextLine();
        if (response.equals("y")) {
            initFiles(new String[]{"NationalStorage", "RegionalStorage", "SCCStorage", "SJCStorage", "SYCStorage"});
            System.out.println("Files reset");
        } else {
            System.out.println("Aborted resetting files");
        }
    }
}
