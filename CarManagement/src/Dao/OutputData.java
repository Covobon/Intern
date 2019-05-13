package Dao;

import entities.Car;
import entities.Insurance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public final class OutputData {
    private OutputData(){}

    public static void OutputCars(){
        try {
            PrintWriter out = new PrintWriter(new File("./Data/Cars.text"));
            for (int i = 0; i < Car.cars.size(); i++){
                out.println(Car.cars.get(i).toString());
            }
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Loi khi ghi file cars.text");
        }
    }

    public static void OutputInsurances(){
        try {
            PrintWriter out = new PrintWriter(new File("./Data/Insurances.text"));
            for(int i = 0; i < Insurance.getInsurances().size(); i++){
                out.println(Insurance.getInsurances().get(i).toString());
            }
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Loi khi ghi file insurances.text");
        }
    }

    public static void Ouput() {
        OutputCars();
        OutputInsurances();
    }
}
