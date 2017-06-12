import java.util.*;

class FiboGCD {
    Map<Long, Long> fibo;
    Long MOD = 1000000007L;
    
    long fibonaci(long n){
        if(n<2) return 1;
        if(fibo.containsKey(n)) return fibo.get(n);
        long val = (
            ( (fibonaci((n + 1) / 2) % MOD) * (fibonaci(n / 2) % MOD) ) % MOD + 
            ( (fibonaci((n - 1) / 2) % MOD) * (fibonaci((n - 2) / 2) % MOD) ) % MOD
            ) % MOD;
        fibo.put(n, val);
        
        return val;
    }
    
    long getGCD(long a, long b){
        if (b == 0) return a;
        else return (getGCD (b, a % b));
    }
    
    long gcdList(long gcd, int left, int right, long[] arr){
        //System.out.println("Fibo of "+(arr[left] - 1)+" is "+fibonaci(arr[left] - 1));
        gcd = getGCD(gcd, fibonaci(arr[left] - 1));
        if (left == right){
            return gcd;
        }
        
        //System.out.println(gcd);
        
        return gcdList(gcd, left + 1, right, arr);
    }
    
    public static void main(String args[] ) throws Exception {
        
        FiboGCD fg = new FiboGCD();
        
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int queries = sc.nextInt();
        long[] arr = new long[size];
        
        while(size > 0){
            arr[arr.length - size--] = sc.nextLong();
        }
        
        fg.fibo = new HashMap<Long, Long>();
        
        while(queries-- > 0){
            int left = sc.nextInt() - 1;
            int right = sc.nextInt() - 1;
            if (left == right) {
                System.out.println();
            } else {
                System.out.println(fg.gcdList(fg.fibonaci(arr[left] - 1), left + 1, right, arr));
            }
        }
    }
}

