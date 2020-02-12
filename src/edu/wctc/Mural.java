package edu.wctc;

import java.io.Serializable;

public class Mural implements PaintCalculator.Paintable {
    @Override
    public double getPremiumCost() {
        return 0;
    }

    @Override
    public double getStandardCost() {
        return 0;
    }
}
