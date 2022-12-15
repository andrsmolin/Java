//

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class lesson_3 {
    public static void main(String[] args) throws IOException {
        sort();
        Scanner scan = new Scanner(System.in);
        deleteEven(createArray(scan));
        minMaxMiddle(createArray(scan));
        scan.close();
    }
    // Реализовать алгоритм сортировки слиянием

    public static void sort() {
        int[] sortArr = { 2, 4, 6, 34, 56, 12, 33, 7, 9 };
        int[] result = mergeSort(sortArr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] mergeSort(int[] sortArr) {
        int[] buffer1 = Arrays.copyOf(sortArr, sortArr.length);
        int[] buffer2 = new int[sortArr.length];
        int[] result = mergeSortInner(buffer1, buffer2, 0, sortArr.length);
        return result;
    }

    public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        // уже отсортирован
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);

        // слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++]
                    : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }

    // Пусть дан произвольный список целых чисел, удалить из него четные числа

    public static ArrayList<Integer> createArray(Scanner scan) { // создание начальной коллекции

        // Scanner scan = new Scanner(System.in);
        System.out.println("Введите целые числа через пробел: ");
        String input = scan.nextLine();

        String[] array_str = input.split(" ");
        ArrayList<Integer> array_first = new ArrayList<>();
        for (int index = 0; index < array_str.length; index++) {
            try {
                array_first.add(Integer.parseInt(array_str[index]));
            } catch (Exception e) {

            }

        }
        System.out.println(array_first);
        // scan.close();
        return array_first;
    }

    public static void deleteEven(ArrayList<Integer> arr_1) { // коллекция с удалением четных
        ArrayList<Integer> array_second = new ArrayList<>();
        for (int index = 0; index < arr_1.size(); index++) {
            if (arr_1.get(index) % 2 == 0) {
                continue;
            } else {
                array_second.add(arr_1.get(index));
            }
        }
        System.out.println(array_second);
    }

    // Задан целочисленный список ArrayList. Найти минимальное, максимальное и
    // среднее из этого списка.
    public static void minMaxMiddle(ArrayList<Integer> arr_1) {
        int max = arr_1.get(0);
        int min = arr_1.get(0);
        int summ = arr_1.get(0);
        for (int index = 1; index < arr_1.size(); index++) {
            summ += arr_1.get(index);
            if (arr_1.get(index) > max) {
                max = arr_1.get(index);
            } else if (arr_1.get(index) < min) {
                min = arr_1.get(index);
            }
            System.out.println(summ);
        }
        double middle = (double) summ / (double) arr_1.size();
        System.out.println("Минимальное число = " + min + ", максимальное = " + max + ", среднее = " + middle);
    }
}
