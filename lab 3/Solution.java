import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        long[] count = new long[1];
        sort(arr, 0, n - 1, count);
        System.out.println(count[0]);
    }
    
    static void sort(List<Integer> arr, int l, int r, long[] count) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, l, m, count);
            sort(arr, m + 1, r, count);
            pairs(arr, l, m, r, count);
            combine(arr, l, m, r);
        }
    }
    
    static void pairs(List<Integer> arr, int l, int m, int r, long[] count) {
        abs(arr, m + 1, r);

        int i = l, j = m + 1, mid = m + 1;

        while (i <= m && j <= r) {
            long sq = (long) arr.get(j) * arr.get(j);
            if (arr.get(i) > sq) {
                count[0] += (mid - i);
                j++;
            } else {
                i++;
            }
        }
    }
    
    public static void combine(List<Integer> arr, int l, int m, int r) {
        order(arr, m + 1, r);
        join(arr, l, m, r);
    }

    private static void merge(List<Integer> arr, int low, int mid, int high, int i, int j) {
        List<Integer> temp = new ArrayList<>();

        while (i <= mid && j <= high) {
            if (arr.get(i) <= arr.get(j)) {
                temp.add(arr.get(i++));
            } else {
                temp.add(arr.get(j++));
            }
        }

        place(arr, low, mid, high, i, j, temp);
    }

    static void abs(List<Integer> arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            abs(arr, l, m);
            abs(arr, m + 1, r);
            absJoin(arr, l, m, r);
        }
    }
    
    static void absJoin(List<Integer> arr, int l, int m, int r) {
        int i = l, j = m + 1;
        List<Integer> temp = new ArrayList<>();

        while (i <= m && j <= r) {
            int x = Math.abs(arr.get(i));
            int y = Math.abs(arr.get(j));
            if (x < y || (x == y && arr.get(i) < arr.get(j))) {
                temp.add(arr.get(i++));
            } else {
                temp.add(arr.get(j++));
            }
        }
        place(arr, l, m, r, i, j, temp);
    }

    private static void place(List<Integer> arr, int l, int m, int r, int i, int j, List<Integer> temp) {
        while (i <= m) temp.add(arr.get(i++));
        while (j <= r) temp.add(arr.get(j++));

        for (int p = 0; p < temp.size(); p++) {
            arr.set(l + p, temp.get(p));
        }
    }

    static void order(List<Integer> arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            order(arr, l, m);
            order(arr, m + 1, r);
            join(arr, l, m, r);
        }
    }
    
    static void join(List<Integer> arr, int l, int m, int r) {
        int i = l, j = m + 1;
        merge(arr, l, m, r, i, j);
    }
}