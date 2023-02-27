import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.BiConsumer;


public class Main {


    public static void main(String[] args) {

       Stream<Integer> stream = Stream.of(8,98,34,2,4,0);
       Comparator<Integer> comparator = Comparator.comparing(Integer::intValue);
       BiConsumer<Integer, Integer> biConsumer = (min, max) ->
                System.out.println("Минимальное знаачение: " + min + ", максимальное значение " + max);
        findMinMax (stream, comparator, biConsumer);

        findNumberOfEvenNumbers(List.of(9,34,56,7,4,99));

    }

    public static <T> void findMinMax (
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List <T> list =stream.collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            list.sort(order);
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1) );
        }
    }
    public static void findNumberOfEvenNumbers (List<Integer> list) {
        Stream <Integer> stream = list.stream();
        Predicate <Integer> predicate = n -> (n % 2) == 0;
        Stream <Integer> stream1 = stream.filter(predicate);
        System.out.println("Количество четных чисел равно " + stream1.count());
    }





}