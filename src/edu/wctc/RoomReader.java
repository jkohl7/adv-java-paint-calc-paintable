package edu.wctc;

import java.io.*;
import java.util.ArrayList;

public class RoomReader implements Serializable {
    public ArrayList<PaintCalculator.Paintable> readRoomFile(String fileName) throws IOException, ClassNotFoundException {

        ArrayList rooms = new ArrayList();

        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Object place;

        try {
            while ((place = ois.readObject()) != null) {
                Room create = (Room) place;
                rooms.add(create);
            }
        } catch (EOFException e) {}

        return rooms;
    }
}
