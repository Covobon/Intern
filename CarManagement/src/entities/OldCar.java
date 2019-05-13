package entities;

import Initial.RandomInfo;

public class OldCar extends Car {
    private long actionDuration;

    public OldCar() {
        super();
        this.actionDuration = RandomInfo.getNumberPlate();
    }

    public OldCar(int year){
        this();
        this.setYearOfManufacture(year);
    }

    public OldCar(String name, long numberPlate, int yearOfManufacture, String brand, boolean havaInsurance, long actionDuration) {
        super(name, numberPlate, yearOfManufacture, brand, havaInsurance);
        this.actionDuration = actionDuration;
    }

    public long getActionDuration() {
        return actionDuration;
    }

    public void setActionDuration(long actionDuration) {
        this.actionDuration = actionDuration;
    }

    public String showInfo(){
        return "Name: " + this.name + ".Number Plate: " + this.numberPlate + ".Year Of Manufacture: " + this.yearOfManufacture +
                ".Brand: " + this.brand + "Insurance: " + this.haveInsurance + ".Action Duration: " + this.actionDuration;

    }

    public String toString(){
        return name + " " + this.numberPlate + " " + this.yearOfManufacture + " " + this.brand + " " + this.haveInsurance + " " + this.actionDuration;
    }
}
