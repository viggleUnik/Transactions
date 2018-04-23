
package test_prob1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author vicol
 */
/* Calculating the maximum profit of a series of numbers representing the 
values in bitcoin on a time internval. With the rule: 1 transation at time, 
one operation for buying and one operation for selling. The data is 
chronological and you can not return to the values already read in the string 
of numbers*/


public class Profit {
    public Profit(){};
    
    public void readFile(){
        try {
            /////////////////////////////////////////////////////
            File f = new File("C:/Users/vicol/Desktop/one_transaction.txt");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            /////////////////////////////////////////////////////
            List<Integer> profituri = new ArrayList<>();
            int i = 0;
            while ((readLine = b.readLine()) != null) {
                //System.out.println(readLine);
                if(i !=0 && (i % 2== 0)){
                    List<Integer> number_line  = new ArrayList<>();
                    List<String> numberS =  Arrays.asList(readLine.trim().split(" "));
                    
                    numberS.forEach((s) -> {
                        number_line.add(Integer.valueOf(s));
                    });
                    int p = calcProfit(number_line);
                    profituri.add(p);
                    
                        
                }
                i++;
            }
            writeOut(profituri);
           
        } catch (IOException e) {}
            
    }
    ////////////////////////////////////////////////////////////
    public int calcProfit(List<Integer> n){
        
        int profit = 0;
        int temp = 0;
        for(int i=0; i < n.size(); i++){
                for(int j=i+1; j < n.size();j++){
                    temp =  n.get(j) - n.get(i);
                    if (profit < temp ){
                        profit = temp;
                    } 
                }
                
        }
        return profit;
        
        
    }
    ///////////////////////////////////////////////////////////////////////
    public void writeOut(List<Integer> l) throws FileNotFoundException, IOException{
        File fout = new File("one_transaction.out");
	FileOutputStream fos = new FileOutputStream(fout);
        
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        for(int i = 0; i < l.size(); i++){
              bw.write("TEST #"+(i+1)+": " + l.get(i));
		bw.newLine();
        }   
        bw.close();
    }
    
    
}
