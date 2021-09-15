package gr.edu.ihu.mapreduce;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

/**
 *
 * @author Ohyae
 */
public class Reduce extends Map {
    
    public static String outputname = ("C:\\Users\\mapreducehw.txt");
    private Hashtable<String, Integer> tab = new Hashtable<String, Integer>();
    public void setTab(Hashtable<String, Integer> tab){
        this.tab = tab;
    }      
    public Hashtable<String, Integer> getTab(){
        return this.tab;
    }
    
    public void reduce (ArrayList<String> arr) {
        //Iterator<String> it1 = arr.iterator();        
        for (int i=0; i<arr.size(); i++){
            String word = arr.get(i);
            if (tab.containsKey(word)){
                int x = tab.get(word);
                x++;
                tab.put(word,x);
            } else {
                tab.put(word,1);
            }
        }
    }
    
    public void output() {
        try {
        FileWriter f1 = new FileWriter(outputname, true);
        Iterator<String> it2 = tab.keySet().iterator();
        while (it2.hasNext()){
            String word = it2.next().toString();
            f1.write(word + ":" + tab.get(word) + "\n");            
        }
        f1.close();
        } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Reduce r = new Reduce();
        r.map();
        ArrayList<String> arr = r.getList();        
        r.reduce(arr);
        r.output();
    } 
        
}
