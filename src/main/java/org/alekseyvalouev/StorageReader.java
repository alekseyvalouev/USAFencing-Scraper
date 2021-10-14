package org.alekseyvalouev;

import java.io.*;
import java.util.ArrayList;

public class StorageReader {
    private static String mFilename = "";

    public static void setFilename(String newFilename) {
        mFilename = newFilename;
    }

    public static ArrayList<Competition> read() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("src/main/java/org/alekseyvalouev/storage/" + mFilename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Competition> Competitions = (ArrayList<Competition>)ois.readObject();
        ois.close();
        return Competitions;
    }
}
