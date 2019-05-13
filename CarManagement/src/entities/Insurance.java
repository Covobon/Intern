package entities;

import Initial.RandomInfo;

import java.util.ArrayList;

public class Insurance {
    private String name;
    private Character packageType;
    private boolean used;
    public static ArrayList<Insurance> insurances = new ArrayList<>();

    public Insurance() {
        this.name = "InsurancePackage#" + insurances.size();
        this.packageType = RandomInfo.getPackageType();
        this.used = false;
        insurances.add(this);
    }

    public Insurance(String name, Character packageType, boolean used) {
        this();
        this.name = name;
        this.packageType = packageType;
        this.used = used;
    }

    public static void initialInsuracne() {
        for (int i = 0; i < 10; i++){
            new Insurance();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getPackageType() {
        return packageType;
    }

    public void setPackageType(Character packageType) {
        this.packageType = packageType;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public static ArrayList<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(ArrayList<Insurance> insurances) {
        this.insurances = insurances;
    }

    public String toString(){
        return this.name + " " + this.packageType + " " + this.used;
    }
}
