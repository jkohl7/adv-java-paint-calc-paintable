package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;

public class Room implements PaintCalculator.Paintable {
    static int roomCount;
    int roomNum = 1;

    private ArrayList<Wall> wallList;



    public Room(double length, double width, double height) throws BadWidthException, BadHeightException {


        wallList = new ArrayList<Wall>();

        Wall wallA = new Wall(length, height);
        wallList.add(wallA);
        Wall wallB = new Wall(length, height);
        wallList.add(wallB);
        Wall wallC = new Wall(width, height);
        wallList.add(wallC);
        Wall wallD = new Wall(width, height);
        wallList.add(wallD);
    }

    public double getArea() {
        double area = 0;
        roomNum = roomCount;
        roomCount++;

        for (int i = 0; i < wallList.size(); i++) {
            Wall w = wallList.get(i);
            area += w.getArea();
        }

        return area;
    }



    public String toString() {return "A room has a total area of " + getArea() + " cubic units.";
    }

    @Override
    public double getPremiumCost() {
        return 0;
    }

    @Override
    public double getStandardCost() {
        return 0;
    }
}
