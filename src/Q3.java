

import java.util.*;

public class Q3 {
    static String buildMsbFirst(int n) {
        if (n == 1) return "1";
        String bits = Integer.toBinaryString(n).substring(1); // buang leading '1'
        StringBuilder sb = new StringBuilder("1");
        for (char bit : bits.toCharArray()) {
            sb.append(bit == '0' ? "d+" : "d+1+");
        }
        return sb.toString();
    }

    // Hitung jumlah operasi '+' untuk membangun nilai n
    static int countMerges(int n) {
        return (int) buildMsbFirst(n).chars().filter(c -> c == '+').count();
    }

    // Rekursif: build elemen terakhir, kompensasi distorsi ke elemen sebelumnya
    static String solve(int[] vals, int n) {
        if (n == 0) return "";
        int last   = vals[n - 1];
        int merges = countMerges(last);

        // Semua elemen sebelumnya akan terdistorsi sebanyak 'merges' kali
        // maka tambahkan 'merges' ke masing-masing sebagai kompensasi
        int[] adjusted = new int[n - 1];
        for (int i = 0; i < n - 1; i++) adjusted[i] = vals[i] + merges;

        return solve(adjusted, n - 1) + buildMsbFirst(last);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();                       // baris 1: jumlah test case

            while (t-- > 0) {
                int n = sc.nextInt();                   // baris 1 per TC: jumlah elemen
                int[] stack = new int[n];
                for (int i = 0; i < n; i++) {
                    stack[i] = sc.nextInt();            // baris 2 per TC: elemen stack
                }
                System.out.println(solve(stack, n));
            }
        }
    }
}