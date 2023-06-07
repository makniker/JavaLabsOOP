package lab5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final List<Integer> list1 = new ArrayList<>(5);
    private static final List<String> list2 = new ArrayList<>(5);
    private static final int[] arr1 = {1, 2, 3, 4, 5};
    private static final int[] arr2 = {1, 3, 5};
    public static void main(String[] args) throws Exception {
        list1.add(5);
        list1.add(5);
        list1.add(5);
        list1.add(5);
        list1.add(5);
        System.out.println(StreamMethods.averageValue(list1));

        list2.add("ffff");
        list2.add("dfsadvsv");
        list2.add("sagsadgfsad");
        list2.add("DDDDDDDDD");
        list2.add("sadjvhbjhHJJHJBJB");
        System.out.println(StreamMethods.toUpperCase(list2));

        list1.add(4);
        list1.add(3);
        list1.add(2);
        list1.add(1);
        System.out.println(StreamMethods.getListOfSquares(list1));

        System.out.println(StreamMethods.getStringStartsWith(list2, 's'));

        System.out.println(StreamMethods.getLastElement(list1));

        System.out.println(StreamMethods.getEvenSum(arr1));
        System.out.println(StreamMethods.getEvenSum(arr2));

        list2.remove("sadjvhbjhHJJHJBJB");
        System.out.println(StreamMethods.getListOfMaps(list2));
    }

}
