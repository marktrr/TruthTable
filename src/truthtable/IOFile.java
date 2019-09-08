/**
 * Author: Hy Minh Tran (Mark)
 * Convert pre-fix to post-fix on Java code. Then create an truth table.
 * Date: July 16th, 2019.
 * Last Update: September 18th, 2019.
 * Note of Update: Modify IO file.
 **/

package truthtable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class IOFile {
     public static String ReadFile(String input) throws Exception {
        String output = "";
        File fileRead = new File(input);
        BufferedReader br = new BufferedReader(new FileReader(fileRead)); 
        String st; 
        while ((st = br.readLine()) != null) {
            output += RPN.convertToPostfix(st) + "\n";
        }
        return output;
    }
    
    public static void ReadToWrite(String input, String output) throws Exception {
        File fileWrite = new File(output); 
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileWrite)); 
        
        File fileRead = new File(input);
        BufferedReader br = new BufferedReader(new FileReader(fileRead)); 
        String st; 
        while ((st = br.readLine()) != null) {
            bw.write(RPN.convertToPostfix(st) + "\r\n");           
        }
        bw.close();
    }
    
    public static void WriteMultiple(String input) throws Exception {
       File fileWrite = new File("truthtable-result.txt"); 
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileWrite)); 
        
        File fileRead = new File(input);
        BufferedReader br = new BufferedReader(new FileReader(fileRead)); 
        String st; 
        while ((st = br.readLine()) != null) {
            bw.write(TruthTable.truthTable() + "\r\n");           
        }
        bw.close();
    }
}
