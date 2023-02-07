package StreamMethod;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Тест 1");
        list.add("Тест 24");
        list.add("Test 452");
        list.add("Test 3dfg");
        list.add("Test 4 fsd");

        /*for (int i = 0; i < list.size(); i++) {
           list.set(i, String.valueOf(list.get(i).length()));
        }*/
        List<Integer> listInt = list.stream().map(element -> element.length()).collect(Collectors.toList());
        list.stream().map(String::length);

        System.out.println(list);
        System.out.println(listInt);

        int[] array = {3, 4, 56, 2, 45, 76, 32, 1};
        array = Arrays.stream(array).map(element -> {
            if (element % 3 == 0) {
                element = element / 3;
            }
            return element;
        }).toArray();
        System.out.println(Arrays.toString(array));

        Set<String> set = new TreeSet<>();
        set.add("Test ww");
        set.add("Test 2w12");
        set.add("Test edw");
        set.add("Test wwer");
        set.add("Test33e");

        System.out.println(set);
        Set<Integer> newSet = set.stream().map(e -> e.length()).collect(Collectors.toSet());
        System.out.println(newSet);

    }
}
