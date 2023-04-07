package Core;

import Utilities.E_CarModel;
import Utilities.E_Color;

import java.util.Date;
import java.util.Objects;

public class MiniCar extends Car {
    private String carClass;

    public MiniCar(String licencePlateSerial, E_CarModel carModel, String subModel, E_Color color, Date manufactureDate,
                   String manufactureCountry, int modelYear, double carLength, double carWeight, int maxSeats,
                   double wheelsAirVolume, String carClass) {
        super(licencePlateSerial, carModel, subModel, color, manufactureDate, manufactureCountry, modelYear, carLength, carWeight, maxSeats, wheelsAirVolume);
        setCarClass(carClass);
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        if (carClass.isEmpty())
            this.carClass = "UNKNOWN";
        else
            this.carClass = carClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MiniCar miniCar = (MiniCar) o;
        return this.getLicencePlateSerial().equals(miniCar.getLicencePlateSerial());
    }

    @Override
    public int hashCode() {
        return Objects.hash(licencePlateSerial, carClass);
    }

    /**
     * This return true if a trailer is available for a ca r otherwise false
     * For mini car is unavailable
     * @return false
     */
    public boolean checkIfTrailerIsAvailiable() {
        return false;
    }

    /**
     * This function calculates if a car can be used for trading
     * @return true if a car possible for trade otherwise false
     */
    public boolean carForTrade() {
        final int START_TRADE_YEAR = 2020;
        return getModelYear() > START_TRADE_YEAR;
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
            cost = cost / getModelYear();

        return cost;
    }
}
