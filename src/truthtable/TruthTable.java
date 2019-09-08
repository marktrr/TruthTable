/**
 * Author: Hy Minh Tran (Mark)
 * Convert pre-fix to post-fix on Java code. Then create an truth table.
 * Date: July 16th, 2019.
 * Last Update: September 18th, 2019.
 * Note of Update: Modify IO file.
 **/
package truthtable;

import java.util.*;

public class TruthTable {
    public static int countPower(int a, int b) {
        if(b == 1) {
            return a;
        }
        return a * countPower(a, b-1);
    }
    
    public static int countOperand(String input) {
        char c;
        int count = 0;
        for(int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            if(RPN.isOperand(c)) {
                count++;
            }
        }
        return count;
    }
    
    public static String truthTable() throws Exception {
        String postFix = IOFile.ReadFile("input.txt");
        int column = countOperand(postFix);
        int row = countPower(2, column);
        String output = "";
       
        Boolean[][] myArray = new Boolean[row][column];
        Stack<Boolean> myStack = new Stack<>();

        for(int x = 0; x < row; x++) {              
            for(int y = column-1; y >= 0; y--) {
                double k = x / Math.pow(2, y)  % 2;
                if(k < 1) {
                    myArray[x][y] = false;
                    myStack.push(false);
                    output += "F ";
                }
                else {
                   myArray[x][y] = true; 
                   myStack.push(true);
                   output += "T ";
                }                                       
            } 
            
            for(int i = 0; i < postFix.length(); i++) {
                char index = postFix.charAt(i);
                if(RPN.isOperator(index)) {
                    if(index == '~') {
                       boolean only =  myStack.pop();
                       if(only == false) {
                           myStack.push(true);
                           output += "T ";
                       }
                       else {
                           myStack.push(false);   
                           output += "F ";
                       }                       
                    }
                    else {
                        boolean st = myStack.pop();
                        boolean nd = myStack.pop();
                        if(index == '&') {
                            if(st == true && nd == true) {
                                myStack.push(true);
                                output += "T ";
                            }
                        else {
                            myStack.push(false);
                            output += "F ";
                            }
                        }
                    
                        else if(index == '|') { 
                            if(st == false && nd == false) {
                                myStack.push(false);
                                output += "F ";
                            }
                            else {
                                myStack.push(true);
                                output += "T ";
                            }
                        }
                        else if(index == '>') {
                            if(st == true && st == false) {
                                myStack.push(false);
                                output += "F ";
                            }
                            else {
                                myStack.push(true);
                                output += "T ";
                            }
                        }
                        else if(index == '=') {
                            if(st != nd) {
                                myStack.push(false);
                                output += "F ";
                            }
                            else {
                                myStack.push(true);
                                output += "T ";
                            }
                        }
                    }         
                }
            }
            output += "\r\n";
        }
        return output;
    }
    
    public static void main(String[] args) throws Exception {
        IOFile.ReadToWrite("input.txt", "post-fix.txt");
        IOFile.WriteMultiple("input.txt");
    }
}
