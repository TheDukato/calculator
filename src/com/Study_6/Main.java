package com.Study_6;


import com.Study_6.lab6.myOperOnFile;
import com.Study_6.lab6.myOperOnURL;
import com.Study_6.lab7.calc;

public class Main {

    public static void main(String[] args) {
/*    String file = "src/com/Study_6/ala.txt";
    String URL1 = "https://www.interia.pl";
    String URL2 = "https://java1.orzechowski.it";
    System.out.println(new myOperOnFile().read(file, 3));
    //System.out.println(new myOperOnURL().read(URL1));
    new myOperOnFile().copy(file,"src/com/Study_6/Kopia-ala.txt");*/

    javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                calc.createAndShowGUI();
                //calc.example();
            }
    });

    }

}
