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

/*calculating the maximum profit of a series of numbers representing the values 
in bitcoin on a time internval. With the rule: 1 transation at time, n 
operations for buying and n operations for selling. Number n of transactions
(buy/sell) is specified in the input file The data is chronological
and you can not return to the values already read in the string of numbers */

public class Profit2 {
     public Profit2(){};
    
    public void readFile1(){
        try {
            /////////////////////////////////////////////////////
            File f;
            f = new File("C:/Users/vicol/Desktop/at_most_transactions.txt");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            /////////////////////////////////////////////////////
            List<Integer> profituri = new ArrayList<>();
            int i = 0;
            int nrTranz = 0;
            while ((readLine = b.readLine()) != null){
                //System.out.println(readLine);
                if(i !=0 && (i % 2 != 0)){
                   List<Integer> number_line1  = new ArrayList<>();
                   List<String> numberS1 =  Arrays.asList(readLine.trim().split(" "));
                    
                    numberS1.forEach((s) -> {
                        number_line1.add(Integer.valueOf(s));
                    }); 
                    nrTranz = number_line1.get(1);
                    
                }
                if(i !=0 && (i % 2== 0)){
                    List<Integer> number_line  = new ArrayList<>();
                    List<String> numberS2 =  Arrays.asList(readLine.trim().split(" "));
                    
                    numberS2.forEach((s) -> {
                        number_line.add(Integer.valueOf(s));
                    });
                    int p = calcProfit2(number_line, nrTranz);
                    profituri.add(p);
                    
                        
                }
                i++;
            }
            
            writeOut(profituri);
           
        } catch (IOException e) {}
            
    }
    ///////////////////////////////////////////////////////
    public int calcProfit2(List<Integer> n, int nrTranz){
        List<Integer> profit_tabel  = new ArrayList<>();
        int profit = 0;
        int temp = 0;
        int i=0;
        
        while(i < n.size()){
                for(int j=i; j <= (n.size()-1);j++){
                    if(n.get(i)<= n.get(j)){
                        if( j == n.size()-1 ){
                            profit_tabel.add(n.get(j) - n.get(i));
                            i=j+1;
                            break;
                        }
                        else if(n.get(j) > n.get(j+1)){
                             profit_tabel.add(n.get(j) - n.get(i));
                             i=j+1;
                             break;
                         }
                    }else{
                        i = j + 1;
                        break;
                    }
                }
        }
        int k=0;
        int max = 0;
        int pos = 0;
        while(k < nrTranz ){
            for(int q =0; q < profit_tabel.size(); q++ ){
               if(profit_tabel.get(q) > max ){
                max = profit_tabel.get(q);
                pos = q;
               }
               if( q == (profit_tabel.size()-1)){
                   profit_tabel.set(pos, 0);
                   profit+= max;
                   max=0;
                   k++;
               }
            }
        }
        return profit;
        
        
    }
   ////////////////////////////////////////////////////////////////////////
    public void writeOut(List<Integer> l) throws FileNotFoundException, IOException{
        File fout = new File("at_most_transactions.out");
	FileOutputStream fos = new FileOutputStream(fout);
 
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        for(int i = 0; i < l.size(); i++){
              bw.write("TEST #"+(i+1)+": " + l.get(i));
		bw.newLine();
        }   
        bw.close();
    }
    
    
}
