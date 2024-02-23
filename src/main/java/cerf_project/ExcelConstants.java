package cerf_project;

import java.util.*;

import org.javatuples.Triplet;

public class ExcelConstants {
    private static ArrayList<Triplet<Integer, Integer, Integer>> cellConstantsPageOne = new ArrayList<>();
    private static Triplet<Integer, Integer, Integer> firstAttCell;

    
    public ExcelConstants()
    {
        cellConstantsPageOne.add(Triplet.with(2, 23, 1));
        cellConstantsPageOne.add(Triplet.with(2, 26, 1));
        cellConstantsPageOne.add(Triplet.with(2, 29, 1));
        cellConstantsPageOne.add(Triplet.with(2, 23, 5));
        cellConstantsPageOne.add(Triplet.with(2, 23,6));
        cellConstantsPageOne.add(Triplet.with(2, 24, 8));
        cellConstantsPageOne.add(Triplet.with(2, 28, 8));

        cellConstantsPageOne.add(Triplet.with(2, 36, 6));
        cellConstantsPageOne.add(Triplet.with(2, 37, 6));
        cellConstantsPageOne.add(Triplet.with(2, 38, 6));
        cellConstantsPageOne.add(Triplet.with(2, 39, 6));
        cellConstantsPageOne.add(Triplet.with(2, 40, 6));
        cellConstantsPageOne.add(Triplet.with(2, 41, 6));
        cellConstantsPageOne.add(Triplet.with(2, 44, 6));
        cellConstantsPageOne.add(Triplet.with(2, 48, 6));
        cellConstantsPageOne.add(Triplet.with(2, 45, 24));

        cellConstantsPageOne.add(Triplet.with(2, 36, 24));
        cellConstantsPageOne.add(Triplet.with(2, 37, 24));
        cellConstantsPageOne.add(Triplet.with(2, 38, 24));
        cellConstantsPageOne.add(Triplet.with(2, 39, 24));
        cellConstantsPageOne.add(Triplet.with(2, 40, 24));
        cellConstantsPageOne.add(Triplet.with(2, 41, 24));
        cellConstantsPageOne.add(Triplet.with(2, 42, 24));
        cellConstantsPageOne.add(Triplet.with(2, 43, 24));
        cellConstantsPageOne.add(Triplet.with(2, 44, 24));
        cellConstantsPageOne.add(Triplet.with(2, 45, 24));

        firstAttCell = Triplet.with(4, 10, 1);
    }

    public static int getA(int index) {
        return cellConstantsPageOne.get(index).getValue0();
    }

    public static int getB(int index) {
        return cellConstantsPageOne.get(index).getValue1();
    }

    
    public static int getC(int index) {
        return cellConstantsPageOne.get(index).getValue2();
    }

    public static Triplet<Integer, Integer, Integer> getFirstAtt() {
        return firstAttCell;
    }
}
