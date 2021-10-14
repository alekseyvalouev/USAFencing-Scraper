package org.alekseyvalouev;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class StorageWriter {
    private static String mFilename = "";

    public static void setFilename(String newFilename) {
        mFilename = newFilename;
    }

    public static void write(ArrayList<Competition> Competitions) throws IOException {
        FileOutputStream fos = new FileOutputStream("src/main/java/org/alekseyvalouev/storage/" + mFilename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Competitions);
        oos.close();
    }
}
