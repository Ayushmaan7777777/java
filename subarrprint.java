// Java program to print all elements in an array after a given element
import java.util.*;
public class a{
    public static int printArray(int arr[]) {
        int largest = 0;
        for (int i = 0; i < arr.length; i++){
            int start = arr[i];
               for (int j = i ; j < arr.length; j++){
                   int end = arr[j];
                   int t = 0;
                   for (int k = i; k < j+1; k++){
                    System.out.print(arr[k] + " ");
                    int sum = t + arr[k];
                    t = sum;
                    }
                   System.out.print("sum = " + t + " ");
                   System.out.println();
                   if (t > largest){
                       largest = t;
                   }
               }
           }
        return largest;
}

public static void main(String[] args){
    int arr[] = {1, 2, 3, 4, 5};

    System.out.println("Largest sum = " + printArray(arr));
}
}
