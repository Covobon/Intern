package entities;

import Initial.RandomInfo;

public class MediumCar extends Car{
    private boolean powerSteering;

    public MediumCar() {
        super();
        this.powerSteering = RandomInfo.getBoolean();
    }

    public MediumCar(int year){
        this();
        this.setYearOfManufacture(year);
    }

    public MediumCar(String name, long numberPlate, int yearOfManufacture, String brand, boolean havaInsurance, boolean powerSteering) {
        super(name, numberPlate, yearOfManufacture, brand, havaInsurance);
        this.powerSteering = powerSteering;
    }

    public boolean isPowerSteering() {
        return powerSteering;
    }

    public void setPowerSteering(boolean powerSteering) {
        this.powerSteering = powerSteering;
    }

    public String showInfo(){
        return "Name: " + this.name + ".Number Plate: " + this.numberPlate + ".Year Of Manufacture: " + this.yearOfManufacture +
                ".Brand: " + this.brand + "Insurance: " + this.haveInsurance + ".Power Steering: " + this.powerSteering;
    }

    public String toString(){
        return name + " " + this.numberPlate + " " + this.yearOfManufacture + " " + this.brand + " " + this.haveInsurance + " " + this.powerSteering;
    }
}
