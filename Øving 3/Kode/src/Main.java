
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        int sumBefore = 0;
        for (int i = 0; i < arr.length; i++) {
            sumBefore += arr[i];
        }

        Algorithm.newQuicksort(arr, 0, arr.length-1);
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


        Algorithm.newQuicksort(arr,0,arr.length-1);
        sumAfter = 0;
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
