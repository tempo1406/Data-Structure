
import java.util.LinkedList;
import java.util.Queue;

public class radixSort {

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (Math.abs(num) > Math.abs(max)) {
                max = num;
            }
        }
        return max;
    }

    public static void RadixSort(int[] arr) {
        int max = getMax(arr);
        for (int k = 1; max / k > 0; k *= 10) {
            Queue<Integer>[] list = new LinkedList[10];

            for (int i = 0; i < 10; i++) {
                list[i] = new LinkedList<>();
            }

            for (int num : arr) {
                int digit = (num / k) % 10;
                list[digit].offer(num);
            }

            int index = 0;
            for (int i = 0; i < 10; i++) {
                while (!list[i].isEmpty()) {
                    arr[index++] = list[i].poll();
                }
            }
        }
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4, 89, 63, 101, 918, 776, 235, 223, 460, 466};
        System.out.println("Before sort: ");
        printArray(arr);
        RadixSort(arr);
        System.out.println("After sort: ");
        printArray(arr);
    }

}