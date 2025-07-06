import java.io.*;
import java.util.*;

public class Q5acc {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] array = new int[size];
        
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        int[] copy = array.clone();
        int[] sorted = array.clone();
        
        
        if (sorted.length > 0) {
           
            int max = sorted[0];
            for (int i = 1; i < sorted.length; i++) {
                if (sorted[i] > max) {
                    max = sorted[i];
                }
            }
            int[] count = new int[max + 1];
            
            for (int value : sorted) {
                count[value]++;
            }
            
            int index = 0;
            for (int j = 0; j < count.length; j++) {
                while (count[j] > 0) {
                    sorted[index] = j;
                    index++;
                    count[j]--;
                }
            }
        }
        if (size == 1) {
            System.out.println("YES");
        } else if (size == 2) {
            if (array[0] <= array[1]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            int length = size;
            int itr = 0;
            boolean sortable = false;
            while (itr < 2 * length) {
                boolean c = false;
                int i = 0;
                while (i <= length - 3) {
                    if (array[i] > array[i + 1] || array[i + 1] > array[i + 2]) {
                        int temp = array[i];
                        array[i] = array[i + 2];
                        array[i + 2] = temp;
                        c = true;
                    }
                    i++;
                }
                if (Arrays.equals(array, sorted)) {
                    sortable = true;
                    break;
                }    
                if (!c) {
                    break;
                }
                itr++;
            }
            if (sortable) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        br.close();
    }
}