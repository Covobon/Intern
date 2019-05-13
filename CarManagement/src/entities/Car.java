package entities;

import Initial.RandomInfo;

import java.util.ArrayList;
import java.util.BitSet;

public abstract class Car {
    String name;
    long numberPlate;
    int yearOfManufacture;
    String brand;
    boolean haveInsurance;
    public static ArrayList<Car> cars = new ArrayList<>();

    public Car() {
        this.name = "Car#" + this.cars.size();
        boolean used = false;
        long numberPlate = RandomInfo.getNumberPlate();
        while(!used){
            for (int i = 0; i < Car.getCars().size(); i++){
                if (numberPlate == Car.getCars().get(i).getNumberPlate()){
                    used = true;
                } else
                if( i == Car.getCars().size() - 1){
                    used = true;
                } else {
                    used = false;
                }
                numberPlate = RandomInfo.getNumberPlate();
            }
            if (Car.getCars().size() == 0){
                used = true;
            }
        }

        this.numberPlate = numberPlate;
        this.yearOfManufacture = RandomInfo.getYear();
        this.brand = RandomInfo.getBrand();
        this.haveInsurance = false;
        this.cars.add(this);
    }

    public Car(String name, long numberPlate, int yearOfManufacture, String brand, boolean havaInsurance) {
        this();
        this.name = name;
        this.numberPlate = numberPlate;
        this.yearOfManufacture = yearOfManufacture;
        this.brand = brand;
        this.haveInsurance = havaInsurance;

    }

    public static ArrayList<Car> getModernCars() {
        ArrayList<Car> modernCars = new ArrayList<>();
        for (int i = 0; i < Car.cars.size(); i++){
            if (Car.getCars().get(i).getYearOfManufacture() >= 2005){
                modernCars.add(Car.getCars().get(i));
            }
        }
        return modernCars;
    }

    public static ArrayList<Car> getMediumCars() {
        ArrayList<Car> modernCars = new ArrayList<>();
        for (int i = 0; i < Car.cars.size(); i++){
            if (Car.getCars().get(i).getYearOfManufacture() < 2005 && Car.getCars().get(i).getYearOfManufacture() > 1995){
                modernCars.add(Car.getCars().get(i));
            }
        }
        return modernCars;
    }

    public static ArrayList<Car> getOldCars() {
        ArrayList<Car> modernCars = new ArrayList<>();
        for (int i = 0; i < Car.cars.size(); i++){
            if (Car.getCars().get(i).getYearOfManufacture() <= 1995){
                modernCars.add(Car.getCars().get(i));
            }
        }
        return modernCars;
    }

    public static void initialCars() {
        int year = RandomInfo.getYear();
        for (int i = 0; i < 10; i++){
            if(year >=2005){
                new ModernCar(year);
            }
            else{
                if(year <=1995){
                    new OldCar(year);
                }
                else new MediumCar(year);
            }
            year = RandomInfo.getYear();
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(long numberPlate) {
        this.numberPlate = numberPlate;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isHaveInsurance() {
        return haveInsurance;
    }

    public void setHaveInsurance(boolean havaInsurance) {
        this.haveInsurance = havaInsurance;
    }

    public static ArrayList<Car> getCars() {
        return cars;
    }

    public static void setCars(ArrayList<Car> cars) {
        Car.cars = cars;
    }

    public String showInfo(){

        if (this.yearOfManufacture >= 2005){
            return ((ModernCar) this).showInfo();
        }else {

            if (this.yearOfManufacture <= 1995) {
                return ((OldCar) this).showInfo();
            }
            else {
                return ((MediumCar) this).showInfo();
            }
        }
    }

    public String toString(){
        if (this.yearOfManufacture >= 2005){
            return ((ModernCar) this).toString();
        } else if (this.yearOfManufacture <= 1995) {
            return ((OldCar) this).toString();
        }
            else return ((MediumCar)this).toString();
    }

    public static ArrayList numberPackage(Character c){
        ArrayList<Insurance> numberInsurances = new ArrayList<>();
        for (int i = 0; i < Insurance.insurances.size(); i++){
            if (Insurance.insurances.get(i).getPackageType() == c && Insurance.insurances.get(i).isUsed() == false){
                numberInsurances.add(Insurance.insurances.get(i));
            }
        }
        return numberInsurances;
    }

    public static ArrayList numberCarAvailabel(Character c){
        ArrayList<Car> numberCar = new ArrayList<>();
        ArrayList<Car> numberCarOut = new ArrayList<>();
        if (c == 'A'){
            numberCar = getModernCars();
        }
        if (c == 'B'){
            numberCar = getMediumCars();
        }
        if (c == 'C'){
            numberCar = getOldCars();
        }

        for (int i = 0; i < numberCar.size(); i++){
            if (numberCar.get(i).isHaveInsurance() == false){
                numberCarOut.add(numberCar.get(i));
            }
        }
        return numberCarOut;
    }

    public static void assignAssurance(Character c){
        int count;
        ArrayList<Insurance> numberAvailable = numberPackage(c);
        ArrayList<Car> numberCar = numberCarAvailabel(c);
        count = numberAvailable.size() < numberCar.size() ? numberAvailable.size() : numberCar.size();
        for (int i = 0; i < count; i++){
            numberAvailable.get(i).setUsed(true);
            numberCar.get(i).setHaveInsurance(true);
        }
    }
}
