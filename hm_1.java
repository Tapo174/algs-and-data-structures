package hm_1;

// Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
public class hm_1 {
    public static void main(String[] args) {
        System.out.println(firstMethod(3, 0)); // ArithmeticException: / by zero
        System.out.println(secondMethod(10, 11, 1)); // ArrayIndexOutOfBoundsException: Index 11 out of bounds for length 10
        System.out.println(thirdMethod()); // NullPointerException: Cannot invoke "String.length()" because "a" is null
    }

    private static int firstMethod(int a, int b) {
        return a / b;
    }

    private static int[] secondMethod(int a, int b, int c) {
        int[] arr = new int[a];
        arr[b] = c;
        return arr;
    }

    private static int thirdMethod() {
        String a = null;
        return a.length();
    }

}