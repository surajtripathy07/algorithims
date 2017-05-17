import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    StringBuilder b = new StringBuilder();

    public String duplication(int x){
        // Complete this function
        return String.valueOf(b.charAt(x));
    }

    
    public void processBit(){
                b.append(0);
                int i = 1;
                int count = 0;
                while(b.length() <= 1000){
                    if (count == i){
                        i <<= 1;                           
                        count = 0;
                    }
                    char c = b.charAt(count);
                    b.append(c == '0' ? '1' : '0');
                    count++;
                }
        }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.processBit();
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int x = in.nextInt();
            String result = s.duplication(x);
            System.out.println(result);
        }
        //System.out.println(s.b.toString());
    }
}

