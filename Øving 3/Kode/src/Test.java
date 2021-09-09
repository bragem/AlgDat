import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        //klasse for å se på sorterte tabeller av quicksort
        int length = 20;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(arr));



        int max = 0;
        int sumBefore = 0;
        for (int i = 0; i<arr.length;i++){
            if(arr[i] > max) max = arr[i];
            sumBefore += arr[i];
        }

        Algorithm.newQuicksort(arr, 0,arr.length-1);
        System.out.println(Arrays.toString(arr));

        int sumAfter = 0;
        for (int i = 0; i < arr.length; i++) {
            sumAfter += arr[i];
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1] && arr[i] != arr[i - 1]) {
                System.out.println("Wrong sorting");
                break;
            }
        }
        System.out.println(sumBefore == sumAfter);



    }
}
