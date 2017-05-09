import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalanceBrackets{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            
            int top = -1;
            String s = in.next();
            char[] brackets = s.toCharArray();
            char[] stack = new char[brackets.length];
            Character lastOpening = '\0';
	    boolean isNotMatched = false;
            for (Character bracket : brackets){
                boolean isClsing = isClosing(bracket);
                if (isClsing && (lastOpening.equals('\0') || !isAPair(lastOpening, bracket))){
		    isNotMatched = true;
                    break;
                }
                if(!isClsing && (-1 <= top && top < stack.length - 1)){
		    //System.out.println("Adding "+bracket+" at "+top +" + 1");
                    stack[++top] = bracket;
                    lastOpening = bracket;
                } else {
                    if (top > 0){
                        lastOpening = stack[top - 1];
		    }
		    else if (top == 0){
			lastOpening = '\0';
		    }
		    if (top > -1){
			//System.out.println("Removing from stack "+stack[top]+" at "+top);
		    	--top;
		    }
                }
	    //System.out.println("Last open is "+lastOpening+" and top is "+top);
                
            }
            if (top != -1 || isNotMatched){
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
       
    public static boolean isClosing(Character bracket){
        return bracket.equals(')') || bracket.equals('}') || bracket.equals(']');
    }
    
    public static boolean isAPair(Character lastOpen, Character bracket){
        if (lastOpen.equals('(')){
            return bracket.equals(')');
        } else if (lastOpen.equals('{')){
            return bracket.equals('}');
        } else if (lastOpen.equals('[')){
            return bracket.equals(']');
        }
        return false;
    }
}
