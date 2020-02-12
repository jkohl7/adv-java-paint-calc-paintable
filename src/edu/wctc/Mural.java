package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;

public class Mural implements Serializable, Paintable {
    static int muralCount;
    int Num = 1;

    private ArrayList<Wall> wallList;


    public Mural(double length, double width) throws BadWidthException, BadHeightException {


        wallList = new ArrayList<Wall>();

        Wall wall = new Wall(width, length);
        wallList.add(wall);
    }

    public double getArea() {
        double area = 0;
        Num = muralCount;
        muralCount++;

        for (int i = 0; i < wallList.size(); i++) {
            Wall w = wallList.get(i);
            area += w.getArea();
        }

        return area;
    }



    public String toString() {return "A mural has a total area of " + getArea() + " cubic units.";
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
