import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Stream<Integer> stream = Stream.of(123, 54325, 456, 567, 768, 7689, 78, 35, 132);
        Comparator<? super Integer> comparator = Integer::compare;
        BiConsumer<? super Integer, ? super Integer> biConsumer = (x1, x2) -> System.out.println("min: " + x1 + "\nmax: " + x2);
        findMinMax(stream, comparator, biConsumer);

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<? extends T> list = stream.toList();
        Stream<? extends T> stream1 = list.stream();
        Stream<? extends T> stream2 = list.stream();
        minMaxConsumer.accept(stream1.min(order).orElse(null), stream2.max(order).orElse(null));
        /*Object[] o = {null, null};
        stream.forEach(item -> {
            if (o[0] == null) {
                o[0] = item;
            }
            if (o[1] == null) {
                o[1] = item;
            }
            if (order.compare(item, (T) o[0]) < 0) {
                o[0] = item;
            }
            if (order.compare(item, (T) o[1]) > 0) {
                o[1] = item;
            }
        });

        minMaxConsumer.accept((T) o[0], (T) o[1]);*/
    }
}