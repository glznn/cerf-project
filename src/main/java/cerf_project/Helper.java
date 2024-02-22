package cerf_project;

import java.util.*;

import org.javatuples.Triplet;

public class Helper {
    private static ArrayList<Triplet<Integer, Integer, Integer>> cellConstants = new ArrayList<>();

    
    public Helper()
    {
        cellConstants.add(Triplet.with(2, 23, 1));
        cellConstants.add(Triplet.with(2, 26, 1));
        cellConstants.add(Triplet.with(2, 29, 1));
        cellConstants.add(Triplet.with(2, 23, 5));
        cellConstants.add(Triplet.with(2, 23,6));
        cellConstants.add(Triplet.with(2, 24, 8));
        cellConstants.add(Triplet.with(2, 28, 8));

        cellConstants.add(Triplet.with(2, 36, 6));
        cellConstants.add(Triplet.with(2, 37, 6));
        cellConstants.add(Triplet.with(2, 38, 6));
        cellConstants.add(Triplet.with(2, 39, 6));
        cellConstants.add(Triplet.with(2, 40, 6));
        cellConstants.add(Triplet.with(2, 41, 6));
        cellConstants.add(Triplet.with(2, 44, 6));
        cellConstants.add(Triplet.with(2, 48, 6));
        cellConstants.add(Triplet.with(2, 45, 24));

        cellConstants.add(Triplet.with(2, 36, 24));
        cellConstants.add(Triplet.with(2, 37, 24));
        cellConstants.add(Triplet.with(2, 38, 24));
        cellConstants.add(Triplet.with(2, 39, 24));
        cellConstants.add(Triplet.with(2, 40, 24));
        cellConstants.add(Triplet.with(2, 41, 24));
        cellConstants.add(Triplet.with(2, 42, 24));
        cellConstants.add(Triplet.with(2, 43, 24));
        cellConstants.add(Triplet.with(2, 44, 24));
        cellConstants.add(Triplet.with(2, 45, 24));
    }

    public static int getA(int index) {
        return cellConstants.get(index).getValue0();
    }

    public static int getB(int index) {
        return cellConstants.get(index).getValue1();
    }

    
    public static int getC(int index) {
        return cellConstants.get(index).getValue2();
    }
}
