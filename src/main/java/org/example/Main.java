package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] smallArray = {5, 3, 8, 4, 2}; // небольшой массив
        int[] largeArray = new int[10000];
        for (int i = 0; i < 10000; i++) {
            largeArray[i] = 10000 - i; // крупный массив
        }

        // Время выполнения сортировки пузырьком для небольшого массива
        long startTime = System.nanoTime();
        bubbleSort(smallArray);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  // Время в наносекундах
        System.out.println("Время выполнения сортировки пузырьком для небольшого массива: " + duration + " наносекунд");

        // Время выполнения быстрой сортировки для небольшого массива
        startTime = System.nanoTime();
        quickSort(smallArray, 0, smallArray.length - 1);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Время выполнения быстрой сортировки для небольшого массива: " + duration + " наносекунд");

        // Время выполнения сортировки пузырьком для крупного массива
        startTime = System.nanoTime();
        bubbleSort(largeArray);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Время выполнения сортировки пузырьком для крупного массива: " + duration + " наносекунд");

        // Время выполнения быстрой сортировки для крупного массива
        startTime = System.nanoTime();
        quickSort(largeArray, 0, largeArray.length - 1);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Время выполнения быстрой сортировки для крупного массива: " + duration + " наносекунд");
    }

    // Сортировка пузырьком
    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    // меняем элементы местами
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // Быстрая сортировка (quicksort)
    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            // Разделение
            int pi = partition(arr, low, high);

            // Рекурсивная сортировка элементов до и после разделителя
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    // Метод для разделения элементов
    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low-1); // индекс меньшего элемента
        for (int j = low; j < high; j++) {
            // Если текущий элемент меньше опорного
            if (arr[j] < pivot) {
                i++;

                // меняем arr[i] и arr[j] местами
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // меняем arr[i+1] и arr[high] местами
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
}