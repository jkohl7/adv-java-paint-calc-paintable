package edu.wctc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PaintCalculator {

    private ArrayList<Paintable> roomList = new ArrayList<>();
    private Scanner keyboard;

    public static void main(String[] args) {
        new PaintCalculator();
    }

    public PaintCalculator() {
        keyboard = new Scanner(System.in);

        int option = 0;

        while (option != 6) {
            printMenu();

            String s = keyboard.nextLine();
            try {
                int choice = Integer.parseInt(s);
                switch (choice) {
                    case 1:
                        createRoom();
                        break;
                    case 2:
                        RoomWriter rw = new RoomWriter();
                        try{
                            rw.writeRoomFile("rooms.dat",roomList);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        RoomReader rr = new RoomReader();
                        try{
                            roomList = rr.readRoomFile("rooms.dat");
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 4:
                        printRooms();
                        break;
                    case 5:
                       createMural();
                        break;
                    case 6:
                        System.out.println("Goodbye");
                        System.exit(0);
                        break;

                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice");
            }
        }

    }

    private void printRooms() {
        if (roomList.isEmpty()) {
            System.out.println("No rooms yet");
        }

        for (Paintable room : roomList) {
            System.out.println(room.toString());
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("1. Add room");
        System.out.println("2. Write rooms to file");
        System.out.println("3. Read rooms from file");
        System.out.println("4. View rooms");
        System.out.println("5. Create a mural");
        System.out.println("6. Exit");
        System.out.println();
    }


    private int promptForDimension(String name) {
        System.out.print("Enter the room's " + name + ": ");
        String response = keyboard.nextLine();
        try {
            return Integer.parseInt(response);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void createRoom() {
        int length = promptForDimension("length");
        int width = promptForDimension("width");
        int height = promptForDimension("height");

        try {
            Room room = new Room(length, width, height);
            roomList.add(room);

            System.out.println("Room successfully created");
        } catch (BadWidthException | BadHeightException e) {
            System.out.println("Could not create room.");
        }


    }

    private void createMural() {
        int length = promptForDimension("length");
        int width = promptForDimension("width");


        try {
            Mural mural = new Mural(length, width);
            roomList.add(mural);

            System.out.println("Mural successfully created");
        } catch (BadWidthException | BadHeightException e) {
            System.out.println("Could not create Mural.");
        }

    }

}
