package com.Study_6.lab7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
/**
 *Do realizacji:
 *      1.logging(Do pliku ??? Sprawdzić E-mail..)                                                              3h
 *      2.wyjątki (dzielenie przez zero)
 *      https://www.educative.io/edpresso/arithmetic-exception-division-by-zero-error                           1h
 *      3.inne przypadki użycia przez użytkownika działania wielokrotne itp(Action listener)                    1h
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
            jf.getContentPane().add(jt,BorderLayout.NORTH);

            JPanel jp = new JPanel();
            jp.setLayout(new GridLayout(4,4));
            jf.getContentPane().add(jp, BorderLayout.CENTER);
            //Adding button
            char[] signs = {'1','2','3','+','4','5','6','-','7','8','9','*','0','=','C','/'};
            for(char tab : signs){
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
        public void MyActionListener(){
                var1 = 0;
                var2 = 0;
                save2var1 = true;
        }
        public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand().charAt(0)){
                        case '*':
                                sign = '*';
                                save2var1 = false;//Przejscie do kolejnej cyfry var2
                                var2 = 0;
                                break;
                        case '/':
                                sign = '/';
                                save2var1 = false;//Przejscie do kolejnej cyfry var2
                                var2 = 0;
                                break;
                        case '+':
                                if(sign != '0'){
                                        switch (sign){
                                                case '*':
                                                        var1=var1*var2;
                                                        break;
                                                case '/':
                                                        var1=var1/var2;
                                                        break;
                                                case '+':
                                                        var1=var1+var2;
                                                        break;
                                                case '-':
                                                        var1=var1-var2;
                                                        break;
                                        }
                                        calc.jt.setText(String.valueOf(var1));
                                }
                                sign = '+';
                                save2var1 = false;//Przejscie do kolejnej cyfry var2
                                var2 = 0;
                                break;
                        case '-':
                                sign = '-';
                                save2var1 = false;//Przejscie do kolejnej cyfry var2
                                var2 = 0;
                                break;
                        case 'C':
                                var1=0;
                                var2=0;
                                sign=0;
                                save2var1 = true;
                                calc.jt.setText("0");
                                break;
                        case '=':
                                //System.out.print(String.valueOf(var1)+sign+String.valueOf(var2)+"=");
                                switch (sign){
                                        case '*':
                                                var1=var1*var2;
                                                break;
                                        case '/':
                                                var1=var1/var2;
                                                break;
                                        case '+':
                                                var1=var1+var2;
                                                break;
                                        case '-':
                                                var1=var1-var2;
                                                break;
                                }
                                //System.out.print(var1);
                                calc.jt.setText(String.valueOf(var1));
                                //var2=0;
                                sign=0;
                                break;
                        default:
                                //Entering multi digits number
                                if(save2var1){
                                        String str = String.valueOf(var1);
                                        str += e.getActionCommand();
                                        var1 = Integer.valueOf(str);
                                        //System.out.println("I'm var1 " + var1);
                                        calc.jt.setText(String.valueOf(var1));
                                }
                                else{
                                        String str = String.valueOf(var2);
                                        str += e.getActionCommand();
                                        var2 = Integer.valueOf(str);
                                        //System.out.println("I'm var2 " + var2);
                                        calc.jt.setText(String.valueOf(var2));
                                }
                                break;
                }
                /**
                 * Mozliwe ze przyjmiemy:
                 *      cyfra                                           GIT
                 *      operator                                        GIT
                 *      operator po operatorze                          GIT
                 *      rowna sie po cyfrze                             GIT
                 *      ###################################################
                 *      operacje z dwoma znakami wywala się             GIT
                 *      12+3-5 '=====' 15-5                             GIT
                 *      jakie przypadki jeszcze?
                 */
        }
}
