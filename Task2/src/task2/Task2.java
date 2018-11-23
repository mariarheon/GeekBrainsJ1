/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2;

import java.util.Arrays;

/**
 *
 * @author Univer
 */
public class Task2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arr1 = {1,0,1,1,1,0,1};
        System.out.println("t1: \narr before - " + Arrays.toString(arr1) +
                " arr after - " + change(arr1));
        
        int[] arr2 = new int[8];
        System.out.println("t2: " + fill(arr2));
        
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("t3: " + changeSix(arr3));
        
        int[][] arr4 = new int[4][4];
        System.out.println("t4: ");
        fillDiag(arr4); 
        
        int[] arr5 = {-7, 5, 3, 2, 11, -14, 5, 32, 4, 18, 9, 1};
        System.out.println("t5: ");
        minMax(arr5);
        
        int[] arr6 = {1, 1, 1, 2, 1};
        System.out.println("t6(true): " + checkBalance(arr6));
        System.out.println("t6(false): " + checkBalance(new int[] {2, 1, 1, 2, 1}));
        System.out.println("t6(true): " + checkBalance(new int[] {10,10}));
        
        int[] arr7 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("t7 shift right:" + shift(arr7, 5));
        shift(arr7,-5); //changing back to normal
        System.out.println("shift left:" + shift(arr7, -5)); //comparing to the original
    }
    //.task1 
    static String change (int[] arr){
        //System.out.println("check:" + Arrays.toString(arr));
       for (int i = 0; i< arr.length; i++)
           arr[i] = arr[i] == 0 ? 1 : 0;
        return Arrays.toString(arr);
    }
    //.task2
    static String fill(int[] arr){
        for (int i = 0; i < arr.length; i++)
            arr[i] += 3*i;
        return Arrays.toString(arr);
    }
    
    //.task3
    static String changeSix(int[] arr){
        for (int i = 0; i < arr.length; i++)
            arr[i] = arr[i] < 6 ? arr[i]*2 : arr[i];
        return Arrays.toString(arr);
    }
    
    //.task4
    static void fillDiag(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            arr[i][i] = 1;
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    
    //.task5
    static void minMax(int[] arr){
        int min = arr[0], max = arr[0];
        for(int i:arr){
            min = i <= min ? i : min;
            max = i >= max ? i : max;
        }
         System.out.println(" min: " + min + " max: " + max);  
    }
    
    ///.task6
    static boolean checkBalance(int[] arr){
        int sumLeft = 0, sumRight = 0;
        for (int i = 0; i <= arr.length; i++){
            sumLeft = 0;
            sumRight = 0;
            for (int l = 0; l < i; l++)
                sumLeft += arr[l];
            for (int r = i; r < arr.length; r++)
                sumRight += arr[r];
            if(sumRight == sumLeft) return true;
        }
        return false;
    }
    
    //.task7
    static String shift (int[] arr, int n){
        while(n != 0){
            if(n>0){
                int tmp = arr[arr.length - 1];
                for (int i = arr.length-1; i > 0; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[0] = tmp;
                n--;
            }
            if(n<0){
                int tmp = arr[0];
                for (int i = 0 ; i < arr.length - 1; i++)
                    arr[i] = arr[i+1];
                arr[arr.length-1] = tmp;
                n++;
            }
        }
        return Arrays.toString(arr);
    }
    
}
