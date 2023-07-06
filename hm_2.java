// Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, 
// и возвращающий новый массив, каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. 
// Если длины массивов не равны, необходимо как-то оповестить пользователя.
package hm_1;
import java.util.Arrays;

public class hm_2 {
    public static void main(String[] args) {
        int[] arr1 = { 9, 8, 7, 6, 5 };
        int[] arr2 = { 1, 2, 3, 4, 5 };

        createArr(arr1, arr2);
    }

    public static void createArr(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length];
        if (arr1.length == arr2.length) {
            for (int i = 0; i < arr2.length; i++) {
                arr3[i] = arr1[i] - arr2[i];
            }
            System.out.println(Arrays.toString(arr3));

        } else {
            throw new RuntimeException("Array lengths are not equal");
        }

    }
}