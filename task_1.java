// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.


import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task_1 {

    public static int[] RandomArr() {
        Random rand = new Random();
        int arr[] = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
        return arr;
    }

    public static int[] BublleSort(int arr[]) throws IOException {
        Logger loger = Logger.getLogger(task_1.class.getName());
        FileHandler fHandler = new FileHandler("Task_1.txt");
        SimpleFormatter sFormatter = new SimpleFormatter();
        fHandler.setFormatter(sFormatter);
        loger.addHandler(fHandler);

        int count;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    count = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = count;
                }
            }

            loger.info(Arrays.toString(arr));
        }
        return arr;

    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) throws IOException {

        print(BublleSort(RandomArr()));
    }

}