package streamSys;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;



public class Main {
    public static void main(String[] args) {
        String strTest1 = "Мама мыла-мыла-мыла раму!";

        String strTest2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibusbufferedreader string java. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.";

        BufferedReader bf = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(strTest1.getBytes()), StandardCharsets.UTF_8));

        HashMap<String, Integer> result = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/streamSys/test.txt"))) {
            reader.lines()
                    .map(l -> l.toLowerCase().replaceAll("\\p{Punct}", " ").split("\\s+"))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .sorted(Comparator.comparing((Function<Map.Entry<String, Long>, Long>) Map.Entry::getValue).reversed())
                    .map(Map.Entry::getKey)
                    .limit(10)
                    .forEach(System.out::println);
        } catch (IOException e) {

        }
        /*(new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8)))
                .lines()
                .flatMap(i -> Stream.of(i.split("[\\p{Punct}\\s]+")))
                .map(s -> s.toLowerCase())
                .forEach(w -> {
                    if (result.containsKey(w)) result.put(w, result.get(w) + 1);
                    else result.put(w, 1);
                });*/

        /*result.entrySet()
                .stream()
                .sorted((i1, i2) -> {
                    if (i1.getValue() == i2.getValue()) return i1.getKey().compareTo(i2.getKey());
                    else return i2.getValue().compareTo(i1.getValue());
                })
                .limit(10)
                .forEach(e -> System.out.println(e.getKey()));*/
    }
}
