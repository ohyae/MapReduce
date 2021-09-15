/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.edu.ihu.mapreduce;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Hyae Cinth Ochotorena
 */
public class Map {
    
    public static String filename = "C:\\Users\\Hyae\\Downloads\\workshop.txt";
    private  ArrayList<String> arr = new ArrayList<String>(); 
    
    public ArrayList<String> getList(){
        return this.arr;
    }
    
    public void map(){
        try{
            FileReader f2 = new FileReader(filename);
            Scanner s = new Scanner(f2); 
                while (s.hasNextLine()) { 
                    String line = s.nextLine(); 
                    String[] words = line.split("\\s"); 
                    for (int i=0;i<words.length; i++){ 
                        String word = words[i];
                            //word = word.replaceAll("[.,*+/&%\\\"+|\\\"+;$[:?!]()]","").trim();
                        if(! word.isEmpty()) {   
                        //if (words[i].length()>0 && Character.isLetterOrDigit(words[i].charAt(0))){
                            //word = word.replaceAll("[0-9]","");
                            word = word.toLowerCase(); 
                            word = word.replaceAll("'s","");                            
                            word = word.replaceAll("[.,*+/&%\\\"+|\\\"+;[:?!]()]",""); 
                            arr.add(word);
                        }     
                    }   
                }                
                f2.close();                
        }catch(IOException ex1){                             
            System.out.println("An error occurred."); 
            ex1.printStackTrace(); 
        } 
    }
    
    //the following code is to test if text is successfully loaded to ArrayList
    public void sort (ArrayList<String> arr){
        Collections.sort(arr);
        Iterator<String> it1 = arr.iterator();
        while (it1.hasNext()){
            String word = it1.next().toString();
            System.out.println(word);            
        }
    }
          
    public static void main(String[] args) { 
        Map m = new Map();         
        m.map();
        ArrayList<String> arr = m.getList();
        m.sort(arr);   
    }    
        
}
