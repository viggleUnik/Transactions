/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/* Calculating the maximum profit of a series of numbers representing the values 
in bitcoin on a time internval. With the rule: 1 transation at time, many 
operations for buying and many operations for selling. The data is chronological
and you can not return to the values already read in the string of numbers */

public class Profit1 {
    public Profit1(){};
    
    public void readFile1(){
        try {
            /////////////////////////////////////////////////////
            File f;
            f = new File("C:/Users/vicol/Desktop/many_transactions.txt");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            /////////////////////////////////////////////////////
            List<Integer> profituri = new ArrayList<>();
            int i = 0;
            while ((readLine = b.readLine()) != null){
                //System.out.println(readLine);
                if(i !=0 && (i % 2== 0)){
                    List<Integer> number_line  = new ArrayList<>();
                    List<String> numberS =  Arrays.asList(readLine.trim().split(" "));
                    
                    numberS.forEach((s) -> {
                        number_line.add(Integer.valueOf(s));
                    });
                    int p = calcProfit2(number_line);
                    profituri.add(p);
                    
                        
                }
                i++;
            }
            
            writeOut(profituri);
           
        } catch (IOException e) {}
            
    }
    /////////////////////////////////////////////
    public int calcProfit2(List<Integer> n){
        
        int profit = 0;
        int temp = 0;
        int i=0;
        while(i < n.size()){
                for(int j=i; j <= (n.size()-1);j++){
                    if(n.get(i)<= n.get(j)){
                        if( j == n.size()-1 ){
                            profit += n.get(j) - n.get(i);
                            i=j+1;
                            break;
                        }
                        else if(n.get(j) > n.get(j+1)){
                             profit+=n.get(j) - n.get(i);
                             i=j+1;
                             break;
                         }
                    }else{
                        i = j + 1;
                        break;
                    }
                }
        }
        return profit;
        
     
    }
   //////////////////////////////////////////////////////////////////////////////
    public void writeOut(List<Integer> l) throws FileNotFoundException, IOException{
        File fout = new File("many_transaction.out");
	FileOutputStream fos = new FileOutputStream(fout);
 
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        for(int i = 0; i < l.size(); i++){
              bw.write("TEST #"+(i+1)+": " + l.get(i));
		bw.newLine();
        }   
        bw.close();
    }
    
}
