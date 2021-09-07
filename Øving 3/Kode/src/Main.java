import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for(int i = 0; i < 10; i++){
            arr[i] = (int) (Math.random()*100);
        }

        int sum = 0;
        for(int i=0; i<arr.length;i++){
            sum += arr[i];
        }
        System.out.println(sum);
        System.out.println(Arrays.toString(arr));

//        Algorithm.quicksort(arr,0,arr.length-1);
//        Algorithm.newQuicksort(arr,0,arr.length-1);
        Algorithm.countsort(arr,100);
        sum = 0;
        for(int i=0; i<arr.length;i++){
            sum += arr[i];
        }
        System.out.println(sum);
        System.out.println(Arrays.toString(arr));



    }
}
