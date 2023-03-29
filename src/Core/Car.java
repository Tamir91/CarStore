package Core;

import Core.ItemPart;
import Utilities.E_CarModel;
import Utilities.E_Color;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public abstract class Car {
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

    protected ArrayList<ItemPart> carParts;

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
     */
    public Car(String licencePlateSerial, E_CarModel carModel, String subModel, E_Color color, Date manufactureDate,
               String manufactureCountry, int modelYear, double carLength, double carWeight, int maxSeats,
               double wheelsAirVolume) {
        this.licencePlateSerial = licencePlateSerial;
        this.carModel = carModel;
        this.subModel = subModel;
        this.color = color;
        this.manufactureDate = manufactureDate;
        this.manufactureCountry = manufactureCountry;
        this.modelYear = modelYear;
        this.carLength = carLength;
        this.carWeight = carWeight;
        this.maxSeats = maxSeats;
        this.wheelsAirVolume = wheelsAirVolume;
        this.carParts = new ArrayList<>();
    }

    // *****************************************************************************************************************
    // GETTERS
    // *****************************************************************************************************************

    public String getLicencePlateSerial() {
        return licencePlateSerial;
    }

    public E_CarModel getCarModel() {
        return carModel;
    }

    public String getSubModel() {
        return subModel;
    }

    public E_Color getColor() {
        return color;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public String getManufactureCountry() {
        return manufactureCountry;
    }

    public int getModelYear() {
        return modelYear;
    }

    public double getCarLength() {
        return carLength;
    }

    public double getCarWeight() {
        return carWeight;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public double getWheelsAirVolume() {
        return wheelsAirVolume;
    }

    public ArrayList<ItemPart> getCarParts() {
        return new ArrayList<>(carParts);
    }

    // *****************************************************************************************************************
    // SETTERS
    // *****************************************************************************************************************

    public void setLicencePlateSerial(String licencePlateSerial) {
        this.licencePlateSerial = licencePlateSerial;
    }

    public void setCarModel(E_CarModel carModel) {
        this.carModel = carModel;
    }

    public void setSubModel(String subModel) {
        this.subModel = subModel;
    }

    public void setColor(E_Color color) {
        this.color = color;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public void setManufactureCountry(String manufactureCountry) {
        this.manufactureCountry = manufactureCountry;
    }

    public void setModelYear(int modelYear) {
        if (modelYear > 1900) {
            this.modelYear = modelYear;
        }
    }

    public void setCarLength(double carLength) {
        if (carLength > 0)
            this.carLength = carLength;
    }

    public void setCarWeight(double carWeight) {
        if (carWeight > 0) {
            this.carWeight = carWeight;
        }
    }

    public void setMaxSeats(int maxSeats) {
        if (maxSeats > 0) {
            this.maxSeats = maxSeats;
        }
    }

    public void setWheelsAirVolume(double wheelsAirVolume) {
        if (wheelsAirVolume > 0) {
            this.wheelsAirVolume = wheelsAirVolume;
        }
    }

    public void setCarParts(ArrayList<ItemPart> carParts) {
        this.carParts = carParts;
    }

    @Override
    public String toString() {
        return  "License Plate : " + licencePlateSerial +
                "Car Model : " + carModel +
                "Sub Model : " + subModel +
                "color : " + color +
                "Manufacture Country : " + manufactureCountry +
                "Manufacture Date : " + manufactureDate +
                "Model Year : " + modelYear +
                "Car Length : " + carLength +
                "Car Weight : " + carWeight +
                "Max Seats : " + maxSeats +
                "Wheels Air Volume : " + wheelsAirVolume +
                "Car Parts : " + carParts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Car car = (Car) o;
        return licencePlateSerial.equals(car.licencePlateSerial) &&
                carModel == car.carModel &&
                subModel.equals(car.subModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licencePlateSerial, carModel, subModel);
    }

    /**
     * This function calculate car price according cost of parts in it.
     * @return Total car price.
     */
    public double calcCarPrice() throws SpecialException{
        double totalPrice = 0;

        if (carParts == null || !isCarCompleted())
            throw new SpecialException("TODO");
        
        for (ItemPart part : carParts) {
            if (part != null && part.price > 0)
                totalPrice += part.price;
        }

        totalPrice = addAdditionPrice(totalPrice);
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

            if (((SportCar)this).isConvertible())
                newPrice += 10000;
        }

        return newPrice;
    }

    // Return true if a car completed otherwise throw ex,
    private boolean isCarCompleted() {
/*        boolean isSteeringWheelAssembled = false;
        boolean isEngineAssembled = false;
        boolean isShiftGearBoxAssembled = false;
        int numberWheels = 0;

        for (ItemPart part : carParts) {
            if (part instanceof SteeringWheel)
                isSteeringWheelAssembled = true;
            else if (part instanceof Engine)
                isEngineAssembled = true;
            else if (part instanceof ShiftGearBox)
                isShiftGearBoxAssembled = true;
            else if (part instanceof Wheel)
                numberWheels++;
        }

        return isSteeringWheelAssembled &&
                isEngineAssembled &&
                isShiftGearBoxAssembled &&
                numberWheels == 4;*/

        return isEngineAssembled() &&
                isSteeringWheelAssembled() &&
                isShiftGearBoxAssembled() &&
                isAllWheelsAssembled();
    }

    // Return true if a car has one steering wheel otherwise false.
    private boolean isSteeringWheelAssembled() {
        int steeringWheelCounter = 0;

        if (carParts != null) {
            for (ItemPart part : carParts) {
                if (part instanceof SteeringWheel)
                    steeringWheelCounter++;
            }
        }

        return steeringWheelCounter == 1;
    }

    // Return true if a car has one engine otherwise false.
    private boolean isEngineAssembled() {
        int engineCounter = 0;

        if (carParts != null) {
            for (ItemPart part : carParts) {
                if (part instanceof Engine)
                    engineCounter++;
            }
        }

        return engineCounter == 1;
    }

    // Return true if a car has one shift gear box otherwise false.
    private boolean isShiftGearBoxAssembled() {
        int shiftGearBoxCounter = 0;

        if (carParts != null) {
            for (ItemPart part : carParts) {
                if (part instanceof ShiftGearBox)
                    shiftGearBoxCounter++;
            }
        }

        return shiftGearBoxCounter == 1;
    }

    // Return true if a car has correct number of wheels otherwise false.
    private boolean isAllWheelsAssembled() {
        int wheelCounter = 0;
        final int CORRECT_NUMBER_OF_WHEELS = 4;

        if (carParts != null) {
            for (ItemPart part : carParts) {
                if (part instanceof Wheel)
                    wheelCounter++;
            }
        }

        return wheelCounter == CORRECT_NUMBER_OF_WHEELS;
    }

    /**
     * This function add part to a car if it not exists
     * @param item - part of car
     * @return true if added otherwise false
     */
    public boolean addItemToCar(ItemPart item) {
        if (carParts == null || item == null)
            return false;

        if (item instanceof SteeringWheel && !isSteeringWheelAssembled()) {
            return carParts.add(item);
        } else if (item instanceof Wheel && !isAllWheelsAssembled()) {
            return carParts.add(item);
        } else if (item instanceof Engine && !isEngineAssembled()) {
            return carParts.add(item);
        } else if (item instanceof ShiftGearBox && !isShiftGearBoxAssembled()) {
            return carParts.add(item);
        }

        return false;
    }

    /**
     * This function remove part form a car
     * @param item - part for removing
     * @return true if a part was removed otherwise false
     */
    public boolean removeItemFromCar(ItemPart item) {
        if (carParts == null || item == null)
            return false;

        return carParts.remove(null);
    }
}
