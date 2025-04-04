import java.util.*;

public class j {
  
    public static int sum(int arr[], int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter numbers of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        // Populate the array
        

        Scanner sc1 = new Scanner(System.in);
        System.out.print("Enter command (sum/exit): ");
        String str = sc1.nextLine();

        if (str.equals("sum")) {
            System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
            int result = sum(arr, n); // Call the sum function
            System.out.println("The sum of the array elements is: " + result);
        } else if (str.equals("exit")) {
            System.out.println("Exiting the program.");
            return;
        }

        sc.close();
        sc1.close();
    }
}
