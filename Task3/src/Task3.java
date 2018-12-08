
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maria Mikhaleva
 */
public class Task3 {

    /**
     * @param args the command line arguments
     */
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
            
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Выберите игру. 1 - Угадай число / 2 - Угадай слово. ");
        int chooseGame = sc.nextInt();
        switch (chooseGame){        //in case there will be more games
            case 1: 
                numberGuess();
            case 2: 
                wordGuess();
            default: 
                System.out.println("До свидания!");
        }
        
        
    }
    
    //.task1
   static void numberGuess(){
 
        int fin;
        int x;
        System.out.println("Игра \"Угадай число\"");
        do{
            int number = rand.nextInt(10);
            for (int i = 1; i <= 3; i++){
                System.out.println("Введите число: ");
                x = sc.nextInt();
                if (x == number){
                    System.out.println("Вы угадали");
                    break;
                } else System.out.println("Попробуйте еще раз");
            }
             System.out.println("Хотите сыграть еще раз? 1 - да/0 - нет"); 
             fin = sc.nextInt();
        } while(fin == 1);
   }
   
   //.task2
   static void wordGuess(){
       boolean check = false;
       String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                    "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                    "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                    "pepper", "pineapple", "pumpkin", "potato"};
       
       System.out.println("Игра \"Угадай слово\"");
       String word = mask(words[rand.nextInt(words.length)]);
       System.out.println("Загаданное слово:" + word); //to check
       String guess;
       
       do{
           System.out.println("Введите слово:");
           guess = mask(sc.next());
           if(word.equals(guess)){
               System.out.println("Слово угадано");
               check = true;
           } else{
           for (int i = 0; i < 15; i++)
               if ((guess.charAt(i) == word.charAt(i)))
                   System.out.print(guess.charAt(i));
           }
       }while (check == false);
   
   }
   
   static String mask(String s){
   for (int i = s.length(); i < 15; i++)
       s+= "#";
   return s;
   }
    
}
