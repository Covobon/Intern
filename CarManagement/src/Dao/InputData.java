package Dao;

import entities.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public final class InputData {
    private InputData(){}

    public static void input(){
        inputCars();
        inputInsurances();
    }

    public static void inputCars(){
        try{
            Scanner in = new Scanner(new File("./Data/Cars.text"));
            while(in.hasNext()){
                toCar(in.nextLine());
            }
            in.close();
        }catch (Exception e){
            System.out.println("Loi File Cars");
        }
    }

    public static void inputInsurances(){
        try{
            Scanner in = new Scanner(new File("./Data/Insurances.text"));
            while(in.hasNext()){
                toInsurance(in.nextLine());
            }
            in.close();
        }catch (Exception e){
            System.out.println("Loi doc file Insurances.text");
        }
    }

    private static Car toCar(String s){
        ArrayList<String> data = new ArrayList<String>();
        int point = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' ' || i == s.length() - 1){
                data.add(s.substring(point, i));
                point = i+1;
            }
        }
        Car car;
        if (Integer.parseInt(data.get(2)) >= 2005){
            car = new ModernCar(data.get(0), Long.parseLong(data.get(1)), Integer.parseInt(data.get(2)), data.get(3), Boolean.parseBoolean(data.get(4)), Boolean.parseBoolean(data.get(5)));
        } else if (Integer.parseInt(data.get(2)) <= 1995){
            car = new OldCar(data.get(0), Long.parseLong(data.get(1)), Integer.parseInt(data.get(2)), data.get(3), Boolean.parseBoolean(data.get(4)), Long.parseLong(data.get(5)));
        }
        else car = new MediumCar(data.get(0), Long.parseLong(data.get(1)), Integer.parseInt(data.get(2)), data.get(3), Boolean.parseBoolean(data.get(4)), Boolean.parseBoolean(data.get(5)));
        return car;
    }

    private static Insurance toInsurance(String s){
        ArrayList<String> data = new ArrayList<String>();
        int point = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' ' || i == s.length() - 1){
                data.add(s.substring(point, i));
                point = i+1;
            }
        }
        Insurance insurance = new Insurance(data.get(0), data.get(1).charAt(0), Boolean.parseBoolean(data.get(2)));
        return insurance;

    }
}
