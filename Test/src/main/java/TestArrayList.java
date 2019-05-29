import java.util.ArrayList;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> primary = new ArrayList<>();
        ArrayList<Integer> after;

        primary.add(1);
        primary.add(1);
        primary.add(1);
        primary.add(1);

        after = primary;
        after.add(5);
        System.out.println(primary.size());
    }
}
