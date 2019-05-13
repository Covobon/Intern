package entities;

import Initial.RandomInfo;

public class ModernCar extends Car{
    private boolean positioningDevice;

    public ModernCar() {
        super();
        this.positioningDevice = RandomInfo.getBoolean();
    }

    public ModernCar(int year){
        this();
        this.setYearOfManufacture(year);
    }

    public ModernCar(String name, long numberPlate, int yearOfManufacture, String brand, boolean havaInsurance, boolean positioningDevice) {
        super(name, numberPlate, yearOfManufacture, brand, havaInsurance);
        this.positioningDevice = positioningDevice;
    }

    public boolean isPositioningDevice() {
        return positioningDevice;
    }

    public void setPositioningDevice(boolean positioningDevice) {
        this.positioningDevice = positioningDevice;
    }

    public String showInfo(){
        return "Name: " + this.name + ". Number Plate: " + this.numberPlate + ". Year Of Manufacture: " + this.yearOfManufacture +
                ". Brand: " + this.brand + ". Insurance: " + this.haveInsurance + ". Positioning Device: " + this.positioningDevice;

    }

    public String toString(){
        return name + " " + this.numberPlate + " " + this.yearOfManufacture + " " + this.brand + " " + this.haveInsurance + " " + this.positioningDevice;
    }
}
