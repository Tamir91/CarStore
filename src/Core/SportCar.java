package Core;

import Core.Car;
import Utilities.E_CarModel;
import Utilities.E_Color;

import java.util.Date;
import java.util.Objects;

public class SportCar extends Car {
    private boolean isFastCar;
    private boolean isConvertible;
    private boolean is4or2doors;

    /**
     * Main Constructor
     * @param licencePlateSerial Unique car number
     * @param carModel car model
     * @param subModel car sub model
     * @param color car color
     * @param manufactureDate car manufacture date
     * @param manufactureCountry car manufacture country
     * @param modelYear car model year
     * @param carLength car length
     * @param carWeight car weight
     * @param maxSeats max number seats in a car
     * @param wheelsAirVolume wheels air volume
     * @param isFastCar is this fast car
     * @param isConvertible is a roof convertible
     * @param is4or2doors is a ca has 4 or 2 doors
     */
    public SportCar(String licencePlateSerial, E_CarModel carModel, String subModel, E_Color color,
                    Date manufactureDate, String manufactureCountry, int modelYear, double carLength, double carWeight,
                    int maxSeats, double wheelsAirVolume, boolean isFastCar, boolean isConvertible, boolean is4or2doors) {
        super(licencePlateSerial, carModel, subModel, color, manufactureDate, manufactureCountry, modelYear, carLength,
                carWeight, maxSeats, wheelsAirVolume);
        this.isFastCar = isFastCar;
        this.isConvertible = isConvertible;
        this.is4or2doors = is4or2doors;
    }

    public boolean isFastCar() {
        return isFastCar;
    }

    public boolean isConvertible() {
        return isConvertible;
    }

    public boolean isIs4or2doors() {
        return is4or2doors;
    }

    public void setFastCar(boolean fastCar) {
        isFastCar = fastCar;
    }

    public void setConvertible(boolean convertible) {
        isConvertible = convertible;
    }

    public void setIs4or2doors(boolean is4or2doors) {
        this.is4or2doors = is4or2doors;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Fast Car : " + isFastCar +
                "Convertible : " + isConvertible +
                "4 or 2 doors : " + is4or2doors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SportCar sportCar = (SportCar) o;
        return this.getLicencePlateSerial().equals(sportCar.getLicencePlateSerial());
    }

    @Override
    public int hashCode() {
        return Objects.hash(licencePlateSerial, isFastCar, isConvertible, is4or2doors);
    }
}