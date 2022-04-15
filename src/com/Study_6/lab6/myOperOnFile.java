package com.Study_6.lab6;

import java.io.*;
import java.util.Hashtable;

public class myOperOnFile {
    public String read(String filepath, int numOfLine){
        Hashtable<Integer, String> myDict = new Hashtable<Integer, String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            for(int i = 0; i < numOfLine;i++) {
                myDict.put(i,reader.readLine());
                myDict.get(i);
            }
        } catch (IOException e) {
            System.out.print("I catch exeption for you, no need to say thank you ");
            e.printStackTrace();
 ///////////return ;
        }
        return myDict.get(0);
    }
    public boolean myWrite(String filepath,String text){
        try (PrintWriter out = new PrintWriter(filepath)) {
            out.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean copy(String src, String dest){
        File file = new File(src);
        int len = (int) file.length();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(src));
            PrintWriter writer = new PrintWriter(dest);

            int i = 1;
            //len = 100;//Not working :(
            len = 10000;//Working
            while(i < len) {
                //System.out.println("I copy " + i + " line");
                writer.println(reader.readLine());
                i++;
            }
        } catch (IOException e) {
            System.out.print("I catch exeption for you, no need to say thank you ");
            e.printStackTrace();
        }
            return true;
    }
}
