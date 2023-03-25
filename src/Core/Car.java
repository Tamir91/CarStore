package Core;

import Core.ItemPart;
import Utilities.E_CarModel;
import Utilities.E_Color;

import java.util.ArrayList;
import java.util.Date;

public abstract class Car <T extends ItemPart> {
    protected String licencePlateSerial;
    protected E_CarModel carModel;
    protected String subModel;
    protected E_Color color;
    protected Date manufactureDate;
    protected String manufactureCountry;
    protected int modelYear;
    protected double carLength;
    protected double carWeight;
    protected int maxSeats;
    protected double wheelsAirVolume;

    protected ArrayList<T> carParts;

    /**
     * This function calculate car price according cost of parts in it.
     * @return Total car price.
     */
    public double calcCarPrice() {
        double totalPrice = 0;

        if (carParts == null)
            return -1;
        
        for (T part : carParts) {
            if (part != null && part.price > 0)
                totalPrice += part.price;
        }

        return totalPrice;
    }


     // This function calculate additional price for car according to car type.
     // param basePrice - price before additional price.
     // return new price after additions.
    private double addAdditionPrice(double basePrice)
    {
        double newPrice = 0;

        if (this instanceof MiniCar || this instanceof RegularCar)  {
            newPrice = basePrice * 1.2 + 1000;
        }
        
        else if (this instanceof SportCar) {
            newPrice = basePrice * 2.5 + 50000;

            if (((SportCar)this).isCarConvertible())
                newPrice += 10000;
        }

        return newPrice;
    }

    private boolean isCarCompleted() {
        if (carParts == null)
            throw new SpecialException();

        if (carParts.contains)

    }
}

}
