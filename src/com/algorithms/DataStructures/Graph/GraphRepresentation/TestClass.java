import java.util.*;
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        int edges = sc.nextInt();
        int[][] graph = new int[nodes][nodes];
        while(edges-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            // Unidirected graph
            graph[a - 1][b - 1] = 1;
            graph[b - 1][a - 1] = 1;
        }
        
        int queries = sc.nextInt();
        while(queries-- > 0){
            System.out.println(graph[sc.nextInt() - 1][sc.nextInt() - 1] == 1 ? "YES" : "NO");
        }
    }
}

