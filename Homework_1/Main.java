// Напишите программу, которая использует Stream API для обработки списка чисел.
// Программа должна вывести на экран среднее значение всех четных чисел в списке.

package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<Integer>();
        new Random().ints(-100, 101)
                .limit(10)
                .forEach(numbers::add);

        System.out.println("Список: " + numbers);

        double averageEven = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);

        System.out.println("Среднее значение всех четных чисел в списке: " + averageEven);
    }
}