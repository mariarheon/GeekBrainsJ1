/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

/**
 *
 * @author Maria Mikhaleva
 */
public class Task1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a = -2, b = 25, c = 4, d = 3, year = 2020;
        String str = "мир";
        boolean check = true;
        double pi = 3.1415;
        char sym = 's';
        
        System.out.println("t1: " + calculate(a, b, c, d));
        System.out.println("t2: " + checkBorder(a, b));;
        checkMoreLess(a);
        System.out.println("t4: " + checkLess(a));
        greet(str);
        leapYear(year);

    }
    
    static int calculate(int a, int b, int c, int d){
        if (d == 0){
            System.out.println("Error: denominator equals 0");
            System.exit(1);
        }
        return a * ( b + ( c / d ));
    }
    
    static boolean checkBorder(int a, int b){
        return (a+b >= 10 && a+b <= 20);
    }
    
    static void checkMoreLess(int a){
        if (a >= 0)
            System.out.println("t3: a>=0");
        else System.out.println("t3: a<0");
    }
    
    static boolean checkLess(int a){
        return (a<0);
    }
    
    static void greet(String a){
        System.out.println("t5: Привет, " + a + "!");
    }
    
    static void leapYear(int year){
        if (year%4 == 0 && year%100 != 0 || year%400 == 0)
            System.out.println("t6: leap year");    
        else System.out.println("t6: not a leap year");
    }
}
