import java.util.Scanner;
import java.util.Stack;

public class ValidParanthesis{
    public boolean isValid(String s) {
        if(s.length()==1){
            return false;
        }
        Stack<Character> helper = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(helper.isEmpty() || s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i)=='['){
                helper.push(s.charAt(i));
                continue;
            }
            char inString = s.charAt(i);
            if(inString==')' || inString=='}' || inString==']'){
                if(helper.peek()=='(' && inString==')'){
                    helper.pop();
                }
                else if(helper.peek()=='{' && inString=='}'){
                    helper.pop();
                }
                else if(helper.peek()=='[' && inString==']'){
                    helper.pop();
                }
                else{ 
                    return false;
                }
            }
        }
        if(helper.size()==0){
            return true;
        }
        return false;
    } 
    public static void main(String args[]){
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        ValidParanthesis vp = new ValidParanthesis();
        System.out.println("Enter the string containing only ( ) { } [ ] these specific characters : ");
        String s=sc.next();
        boolean isValid=vp.isValid(s);
        if(isValid){
            System.out.println("The entered Strng is a valid paranthesis");
        }
        else{
            System.out.println("The entered String is not a valid paranthesis");
        }
    }
}
