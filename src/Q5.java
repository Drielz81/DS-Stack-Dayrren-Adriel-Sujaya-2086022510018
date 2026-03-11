

import java.util.Stack;

public class Q5 {
    public static void main(String[] args) {
        int max_bounce = 50;
        Stack<Integer> menyimpan_hasil_pembagian = new Stack<>();
        Stack<Integer> menyimpan_hasil_pembagian_invert = new Stack<>();
        for (int i = max_bounce; i >= 1; i /= 2){
            menyimpan_hasil_pembagian.push(i);
        } 
        while(!menyimpan_hasil_pembagian.isEmpty()){
            int invert = menyimpan_hasil_pembagian.pop();
            menyimpan_hasil_pembagian_invert.push(invert);
        }
        System.out.println(menyimpan_hasil_pembagian_invert);
    }
    
}
