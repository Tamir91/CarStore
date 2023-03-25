package Core;

import Utilities.E_Color;

public class Wheel extends ItemPart {


    protected double diameter;

    protected double width;

    public Wheel(String serialNumber) {
        super(serialNumber);
    }

    public Wheel(String serialNumber, double price, String manufactureCountry, E_Color color, double weight,
                 double diameter, double width) {
        super(serialNumber, price, manufactureCountry, color, weight);
        this.diameter = diameter;
        this.width = width;
    }



}