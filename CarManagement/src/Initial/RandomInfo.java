package Initial;

public final class RandomInfo {
    private RandomInfo(){}

    public static long getNumberPlate(){
        return 10000 + (long) (Math.random()*89000);
    }

    public static int getYear(){
        return 1980 + (int)(Math.random()*33);
    }

    public static String getBrand(){
        String[] brands = {"TOYOTA", "BWM", "HUYNDAI"};
        return brands[(int)(Math.random()*3)];
    }

    public static boolean getBoolean(){
        return (Math.random() > 0.5) ? true : false;
    }

    public static Character getPackageType(){
        Character[] c = {'A','B','C'};
        return c[(int)(Math.random()*3)];
    }
}
