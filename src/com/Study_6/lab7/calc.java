package com.Study_6.lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Do realizacji:
 * 1.logging(Do pliku ??? Sprawdzić E-mail..)                                                              3h
 * 2.wyjątki (dzielenie przez zero)
 * https://www.educative.io/edpresso/arithmetic-exception-division-by-zero-error                           1h
 * 3.inne przypadki użycia przez użytkownika działania wielokrotne itp(Action listener)                    1h
 */
public class calc {
    public static JTextField jt;

    public static void createAndShowGUI() {
        //GUI
        JFrame jf = new JFrame("My Calculator");
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);

        jt = new JTextField("0");
        jt.setEditable(false);
        jt.setHorizontalAlignment(SwingConstants.RIGHT);
        jf.getContentPane().add(jt, BorderLayout.NORTH);

        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(4, 4));
        jf.getContentPane().add(jp, BorderLayout.CENTER);
        //Adding button
        char[] signs = {'1', '2', '3', '+', '4', '5', '6', '-', '7', '8', '9', '*', '0', '=', 'C', '/'};
        for (char tab : signs) {
            JButton jb = new JButton(String.valueOf(tab));
            jb.addActionListener(new MyActionListener());
            jp.add(jb);
        }
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyActionListener implements java.awt.event.ActionListener {
    static private char sign;
    static private int var1;
    static private int var2;
    static private boolean save2var1 = true;
    static private boolean procesed;
    static private char[] shorHistryOfChar = new char[100];
    static private int counterHistorian = 1;

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand().charAt(0)) {
            case '*':
                if (!procesed) {
                    switch (sign) {
                        case '*':
                            var1 = var1 * var2;
                            break;
                        case '/':
                            try{
                                var1 = var1 / var2;
                            } catch (Exception exception) {
                            }

                            break;
                        case '+':
                            var1 = var1 + var2;
                            break;
                        case '-':
                            var1 = var1 - var2;
                            break;
                    }
                    calc.jt.setText(String.valueOf(var1));
                }
                sign = '*';
                save2var1 = false;//Przejscie do kolejnej cyfry var2
                var2 = 0;
                procesed = false;
                shorHistryOfChar[counterHistorian] = '*';
                counterHistorian = counterHistorian + 1;
                //System.out.println("Saved: "+shorHistryOfChar[counterHistorian-1]+" sign at index: "+counterHistorian);
                break;
            case '/':
/*                if (!procesed) {
                    switch (sign) {
                        case '*':
                            var1 = var1 * var2;
                            break;
                        case '/':
                            var1 = var1 / var2;
                            break;
                        case '+':
                            var1 = var1 + var2;
                            break;
                        case '-':
                            var1 = var1 - var2;
                            break;
                    }
                    calc.jt.setText(String.valueOf(var1));
                }*/
                sign = '/';
                save2var1 = false;//Przejscie do kolejnej cyfry var2
                var2 = 0;
                procesed = false;
                shorHistryOfChar[counterHistorian] = '/';
                counterHistorian = counterHistorian + 1;
                //System.out.println("Saved: "+shorHistryOfChar[counterHistorian-1]+" sign at index: "+counterHistorian);
                break;
            case '+':
                if (!procesed) {
                    switch (sign) {
                        case '*':
                            var1 = var1 * var2;
                            break;
                        case '/':
                            var1 = var1 / var2;
                            break;
                        case '+':
                            var1 = var1 + var2;
                            break;
                        case '-':
                            var1 = var1 - var2;
                            break;
                    }
                    calc.jt.setText(String.valueOf(var1));
                }
                sign = '+';
                save2var1 = false;//Przejscie do kolejnej cyfry var2
                var2 = 0;
                procesed = false;
                shorHistryOfChar[counterHistorian] = '+';
                counterHistorian = counterHistorian + 1;
                //System.out.println("Saved: "+shorHistryOfChar[counterHistorian-1]+" sign at index: "+counterHistorian);
                break;
            case '-':
                if (!procesed) {
                    switch (sign) {
                        case '*':
                            var1 = var1 * var2;
                            break;
                        case '/':
                            var1 = var1 / var2;
                            break;
                        case '+':
                            var1 = var1 + var2;
                            break;
                        case '-':
                            var1 = var1 - var2;
                            break;
                    }
                    calc.jt.setText(String.valueOf(var1));
                }
                sign = '-';
                save2var1 = false;//Przejscie do kolejnej cyfry var2
                var2 = 0;
                procesed = false;
                shorHistryOfChar[counterHistorian] = '-';
                counterHistorian = counterHistorian + 1;
                //System.out.println("Saved: "+shorHistryOfChar[counterHistorian-1]+" sign at index: "+counterHistorian);
                break;
            case 'C':
                var1 = 0;
                var2 = 0;
                sign = 0;
                save2var1 = true;
                calc.jt.setText("0");
                procesed = true;
                int i = 0;
                for (char var : shorHistryOfChar) {
                    System.out.println(i + ": " + var);
                    i += 1;
                }
                break;
            case '=':
                System.out.println("After if conditions \nVar1: "+var1+"\nVar2: "+var2);
                if (shorHistryOfChar[counterHistorian - 1] == '+' || shorHistryOfChar[counterHistorian - 1] == '-' || shorHistryOfChar[counterHistorian - 1] == '*' || shorHistryOfChar[counterHistorian - 1] == '/') {
                    //System.out.println("In moment 3 \nVar1: "+var1+"\nVar2: "+var2);
                    var2 = var1;
                    //System.out.println("In moment 1 \nVar1: "+var1+"\nVar2: "+var2);
                    switch (shorHistryOfChar[counterHistorian - 1]) {
                        case '*':
                            var1 = var1 * var2;
                            break;
                        case '/':
                            var1 = var1 / var2;
                            break;
                        case '+':
                            var1 = var1 + var2;
                            break;
                        case '-':
                            var1 = var1 - var2;
                            break;
                    }
                    calc.jt.setText(String.valueOf(var1));
                }
                else {
                    switch (sign) {
                        case '*':
                            var1 = var1 * var2;
                            break;
                        case '/':
                            var1 = var1 / var2;
                            break;
                        case '+':
                            var1 = var1 + var2;
                            break;
                        case '-':
                            var1 = var1 - var2;
                            break;
                    }
                }
                calc.jt.setText(String.valueOf(var1));
                procesed = true;
                shorHistryOfChar[counterHistorian] = '=';
                counterHistorian = counterHistorian + 1;
                //System.out.println("Saved: "+shorHistryOfChar[counterHistorian-1]+" sign at index: "+counterHistorian);

                break;
            default:
                if (shorHistryOfChar[counterHistorian - 1] == '=') {
                    System.out.println("In moment 2 \nVar1: "+var1+"\nVar2: "+var2);
                    var1 = 0;
                    var2 = 0;
                    sign = 0;
                    save2var1 = true;
                }
                //Entering multi digits number
                if (save2var1 || procesed) {
                    String str = String.valueOf(var1);
                    str += e.getActionCommand();
                    shorHistryOfChar[counterHistorian] = e.getActionCommand().charAt(0);
                    counterHistorian = counterHistorian + 1;
                    var1 = Integer.valueOf(str);
                    calc.jt.setText(String.valueOf(var1));
                } else {
                    String str = String.valueOf(var2);
                    str += e.getActionCommand();
                    shorHistryOfChar[counterHistorian] = e.getActionCommand().charAt(0);
                    counterHistorian = counterHistorian + 1;
                    var2 = Integer.valueOf(str);
                    calc.jt.setText(String.valueOf(var2));
                }
                break;
        }
        System.out.println("Var1: " + var1 + "\nVar2: " + var2 + "\nSign: " + sign);
    }
}
