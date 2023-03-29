package Core;

import Utilities.E_CarModel;
import Utilities.E_Color;

import java.time.Year;
import java.util.Date;

public class RegularCar extends Car {
    public RegularCar(String licencePlateSerial, E_CarModel carModel, String subModel, E_Color color,
                      Date manufactureDate, String manufactureCountry, int modelYear, double carLength,
                      double carWeight, int maxSeats, double wheelsAirVolume) {
        super(licencePlateSerial, carModel, subModel, color, manufactureDate, manufactureCountry, modelYear, carLength,
                carWeight, maxSeats, wheelsAirVolume);
    }

    /**
     * This function check if car can to trail
     * @return true if a car can to trail otherwise false
     */
    public boolean checkIfTrailerIsAvailiable() {
        return getCarWeight() > 4;
    }

    /**
     * This function calculates if a car can be used for trading
     * @return true if a car possible for trade otherwise false
     */
    public boolean carForTrade() {
        final int MAX_CAR_AGE_FOR_TRADE = 2;
        return (Year.now().getValue() - getModelYear()) < MAX_CAR_AGE_FOR_TRADE;
    }

    /**
     * The function calculates price of moving car to store
     * @return price
     */
    public double calcCarCostForMovingToStore() {
        double cost = 0;

        try {
            cost = calcCarPrice();
        } catch (SpecialException exception) {
            exception.getMessage();
        }

        if (cost > 0)
            cost = cost / 1000;

        return cost;
    }
}
