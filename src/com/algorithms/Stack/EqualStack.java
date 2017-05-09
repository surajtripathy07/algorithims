import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EqualStack {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int heightOne = in.nextInt();
        int heightTwo = in.nextInt();
        int heightThree = in.nextInt();
        int stack1[] = new int[heightOne];
        for(int i = 0; i < heightOne; i++){
            stack1[i] = in.nextInt();
        }
        int stack2[] = new int[heightTwo];
        for(int i=0; i < heightTwo; i++){
            stack2[i] = in.nextInt();
        }
        int stack3[] = new int[heightThree];
        for(int i=0; i < heightThree; i++){
            stack3[i] = in.nextInt();
        }
        
        
        // Add all heights such that arrays now have height
        
        for(int i = heightOne - 2; i > -1 ; i--){
           stack1[i] += stack1[i + 1];
        }
        
        for(int i = heightTwo - 2; i > -1 ; i--){
           stack2[i] += stack2[i + 1];
        }
    
        for(int i = heightThree - 2; i > -1 ; i--){
           stack3[i] += stack3[i + 1];
        }
        
        int[] top = new int[3];
        
        while(true){
            int stackTop1 = getStackTop(stack1, heightOne,top[0]);
            int stackTop2 = getStackTop(stack2, heightTwo,top[1]);
            int stackTop3 = getStackTop(stack3, heightThree,top[2]);
            
            if (stackTop1 == stackTop2 && stackTop2 == stackTop3){
                System.out.println(stackTop1);
                break;
            }
            int min = stackTop1 <= stackTop2 ? stackTop1 : stackTop2;
            min = min <= stackTop3 ? min : stackTop3;
            
            if(top[0] < heightOne && stackTop1 > min){
                top[0]++;
            }
            if(top[1] < heightTwo && stackTop2 > min){
                top[1]++;
            }
            if(top[2] < heightThree && stackTop3 > min){
                top[2]++;
            }
        }
    }

    public static int getStackTop(int[] stack, int height, int top){
        if (height == 0 || top == height){
            return 0;
        } else {
            return stack[top];
        }
        
    }
}

