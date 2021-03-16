public class arrayDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] arr2 = arr;
        for (int i = 0; i < 5; i++) {
            System.out.print(arr[i]);
            arr[i] = 0;
        }
        System.out.println();
        for (int i : arr2) {
            System.out.print(i);
        }
    }
}
