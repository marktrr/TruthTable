/**
 * Author: Hy Minh Tran (Mark)
 * Convert pre-fix to post-fix on Java code. Then create an truth table.
 * Date: July 16th, 2019.
 * Last Update: September 18th, 2019.
 * Note of Update: Modify IO file.
 **/
package truthtable;

import java.util.Stack;

public class RPN {
    public static boolean isOperator(char input){
        return input == '~' || input == '&' || input == '=' || input == '|' 
                || input == '>';
    }
    
    public static boolean isOperand(char input) {
       return (input >= 'a' && input <= 'z') 
               || (input >= 'A' && input <= 'Z');
    }
    
    public static int isPriority(char input) {
        switch(input){
            case '~': return 5;
            case '&': return 4;
            case '|': return 3;
            case '>': return 2;
            case '=': return 1;
        }
        return 0;
    }
    
    public static String convertToPostfix(String input) {
        String output = "";
        Stack<Character> myStack = new Stack<>();
        char index;
        
        for(int i = 0; i < input.length(); i++){
            index = input.charAt(i);
        
            if(isOperand(index)){
                output += index + " ";
            }
            else if(index == '('){
                myStack.push(index);
            }
            else if(index == ')') {
                while(!myStack.isEmpty() && myStack.peek() != '(') {
                    output += myStack.pop() + " ";
                }
                if(!myStack.isEmpty() && myStack.peek() != '(') {
                    return null;
                }
                else if(!myStack.isEmpty()) {
                    myStack.pop();
                }
            }
            else if(isOperator(index)) {
                if(!myStack.isEmpty() && isPriority(index) <= isPriority(myStack.peek())){
                    output += myStack.pop() + " ";
                }
                myStack.push(index);                
            }
        }
        while(!myStack.isEmpty()) {
            output += myStack.pop() + " ";
        }        
        return output;
    }
}
