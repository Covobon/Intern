package App;

import Dao.OutputData;
import Initial.RandomInfo;
import entities.Car;
import entities.Insurance;
import entities.ModernCar;
import entities.OldCar;
import Dao.InputData;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        InputData.input();
        System.out.println(Car.cars.size());
        Scanner in = new Scanner(System.in);
        int flag = 1;
          while(flag != 4) {
            System.out.println("Chon de su dung:\n" +
                    "1.Xem thong tin xe.\n" +
                    "2. Mua bao hiem.\n" +
                    "3. Quan ly.\n" +
                    "4. De thoat.");
            flag = in.nextInt();
            switch (flag) {
                case 1: {
                    showCar();
                    break;
                }
                case 2: {
                    buyInsurance();
                    break;
                }
                case 3: {
                    manager();
                }
                default: {
                    System.out.println("----------Tam biet---------");
                }
            }

        }
        OutputData.Ouput();
    }

        private static void manager() {
        Scanner in = new Scanner(System.in);
        int flag = 1;
        while(flag != 4){
            System.out.println("Chon de su dung:\n" +
                    "1. Them 10 xe.\n" +
                    "2. Them 10 bao hiem.\n" +
                    "3. Gan bao hiem.\n" +
                    "4. Tro ve");
            flag = in.nextInt();
            switch (flag){
                case 1: {
                    Car.initialCars();
                    System.out.println("Da them 10 xe");
                    break;
                }
                case 2:{
                    Insurance.initialInsuracne();
                    System.out.println("Da them 10 bao hiem");
                    break;
                }
                case 3:{
                    System.out.println("Nhap de su dung:\n" +
                            "1. Gan bao hiem xe doi moi.\n" +
                            "2. Gan bao hiem xe trung binh.\n" +
                            "3. Gan bao hiem xe cu.");
                    switch (in.nextInt()){
                        case 1: {
                            Car.assignAssurance('A');
                            break;
                        }
                        case 2: {
                            Car.assignAssurance('B');
                            break;
                        }
                        case 3: {
                            Car.assignAssurance('C');
                            break;
                        }
                    }
                }
            }

        }

    }

    private static void buyInsurance() {
        int flag = 1;
        Car car = null;
        while(flag != 3) {
            System.out.println("Chon xe de mua bao hiem\n" +
                    "1. Chon xe theo bien so.\n" +
                    "2. Chon xe theo so thu tu.\n" +
                    "3. De thoat.");
            Scanner in = new Scanner(System.in);
            flag = in.nextInt();
            switch (flag) {
                case 1: {
                    car = chooseByNumberPlate();
                    break;
                }
                case 2: {
                    car = chooseByNumberOrder();
                    break;
                }
            }
        }
        if (car != null) {

            if (car.isHaveInsurance()) {
                System.out.println("Unavailable Buying!");
            } else {
                if (!checkIvnalidPackage(car)) {
                    System.out.println("Successful Buying");
                    buying(car);
                } else {
                    System.out.println("Unsuccessful Buying");
                }
            }
        }
            
    }

    private static void buying(Car car) {
        car.setHaveInsurance(true);
        Character c = 'A';
        if (car.getYearOfManufacture() >= 2005){
            c = 'A';
        }else if (car.getYearOfManufacture() <= 1995) c = 'C';
        else c = 'B';
        for (int i = 0; i < Insurance.getInsurances().size(); i++){
            if (c == Insurance.getInsurances().get(i).getPackageType()){
                Insurance.getInsurances().get(i).setUsed(true);
                break;
            }
        }
    }

    private static boolean checkIvnalidPackage(Car car) {
        Character c = 'A';
        if (car.getYearOfManufacture() >= 2005){
            c = 'A';
        }else if (car.getYearOfManufacture() <= 1995) c = 'C';
        else c = 'B';
        for (int i = 0; i < Insurance.getInsurances().size(); i++){
            if (c == Insurance.getInsurances().get(i).getPackageType()){
                return false;
            }
        }
        return true;
    }

    private static void showCar() {
        Scanner in = new Scanner(System.in);
        int flag = 1;
        while (flag != 3) {
            System.out.println("Chon de su dung:\n" +
                    "1. Hien thi tat ca.\n" +
                    "2. Hien thi xe theo doi.\n" +
                    "3. Nhap 3 de tro lai.");
            flag = in.nextInt();
            switch (flag) {
                case 1: {
                    System.out.println("Dang xu ly");
                    System.out.println(Car.cars.size());
                    for (int i = 0; i < Car.cars.size(); i++){
                        System.out.println(Car.cars.get(i).showInfo());
                    }
                    break;
                }
                case 2: {

                    int flag1 = 1;
                    while (flag1 != 4) {
                        System.out.println("Chon de su dung:\n" +
                                "1. Hien thi xe doi moi.\n" +
                                "2. Hien thi xe trung binh.\n" +
                                "3. Hien thi xe cu.\n" +
                                "4. De tro lai");
                        flag1 = in.nextInt();
                        switch (flag1) {
                            case 1: {
                                for (int i = 0; i < Car.getModernCars().size(); i++) {
                                    System.out.println(Car.getModernCars().get(i).showInfo());
                                }
                                break;
                            }
                            case 2: {
                                for (int i = 0; i < Car.getMediumCars().size(); i++) {
                                    System.out.println(Car.getMediumCars().get(i).showInfo());
                                }
                                break;
                            }
                            case 3: {
                                for (int i = 0; i < Car.getOldCars().size(); i++) {
                                    System.out.println(Car.getOldCars().get(i).showInfo());
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public static Car chooseByNumberOrder(){
        int numberOrder;
        System.out.println("Nhap vao so thu tu xe: ");

        Scanner in = new Scanner(System.in);
        numberOrder = in.nextInt();
        while(numberOrder > Car.cars.size()){
            System.out.println("Ko tim thay xe, lam on thu lai voi so thu tu khac: ");
            numberOrder = in.nextInt();
        }

        return Car.cars.get(numberOrder);
    }

    public static Car chooseByNumberPlate(){
        System.out.println("Nhap vao bien so xe: ");
        Scanner in = new Scanner(System.in);
        long numberPlate = in.nextLong();
        while(true){
            for (int i = 0; i < Car.cars.size(); i++){
                if(Car.cars.get(i).getNumberPlate() == numberPlate)
                    return Car.cars.get(i);
            }
            System.out.println("Ko tim thay xe, lan on thu voi so xe khac: ");
            numberPlate = in.nextLong();
        }
    }


}
