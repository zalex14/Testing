package zalex14.testing;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestingApplication {

    public static void main(String[] args) {
        System.out.println("Тестирование");

//        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19);
        List<Integer> list = List.of(101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114);

        Stream<Integer> stream = new ArrayList<>(list).stream();

        Comparator<Integer> order = Comparator.reverseOrder();
//        Comparator<Integer> order = Comparator.naturalOrder();
//        Comparator<Integer> order = Comparator.comparingInt(Integer::valueOf);
        BiConsumer<Integer, Integer> minMaxConsumer = (i1, i2) -> System.out.println(i1 + " " + i2);

//        Задание 1
        findMinMax(stream, order, minMaxConsumer);


//        Задание 2
        System.out.println("\nОпределяем количество четных чисел и выводим их в консоль:");
        evenNumbersCounter(list);
    }

    /**
     * Задание 1
     * Напишите метод findMinMax, находящий в стриме минимальный и максимальный элементы в соответствии порядком,
     * заданным Comparator ом.
     * Данный метод принимает на вход 3 элемента
     * Stream<? extends T> stream,
     * Comparator<? super T> order,
     * BiConsumer<? super T, ? super T> minMaxConsumer
     * Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:
     * minMaxConsumer.accept(min, max);
     * Если стрим не содержит элементов, то вызовите
     * minMaxConsumer.accept(null, null);
     */
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> list = stream.sorted(order).collect(Collectors.toList());

        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }

    /**
     * Задание 2
     * Реализуйте метод, который принимает на вход список целых чисел и определяет количество четных и выводит их
     * в консоль. Решать именно с применением Stream API
     */
    private static void evenNumbersCounter(List<Integer> list) {
        System.out.println("\nНайдено четных чисел " +
                list.stream()
                        .filter(i -> i % 2 == 0)
                        .peek(i -> System.out.print(" " + i))
                        .count());
    }
}