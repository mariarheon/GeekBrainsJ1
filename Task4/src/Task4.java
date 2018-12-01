
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Java. Level 1. Lesson 4. Homework/
 * 
 * @author Maria Mikhaleva
 * @version dated Nov 30, 2018
 */
class Task4  {

    final int SIZE = 5;
    final int WIN_SIZE = 4;
    final char DOT_X = 'x';
    final  char DOT_O = 'o';
    final char DOT_EMPTY = '.';
 
    char[][] map = new char[SIZE][SIZE];
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    
    public static void main(String[] args) {
        new Task4().game();
    }
    
    void game(){
        initMap();
        while(true){
            humanTurn();
            printMap();
            if (turnCheck(DOT_X)) break;
            aiTurn();
            printMap();
            if (turnCheck(DOT_O)) break;          
        }
        System.out.println("GAME OVER!");
        printMap();
    }
    
    boolean turnCheck(char dot){
        String name = "Winner: ";
        name += (dot == DOT_X) ? ("Human") : ("AI");
        if(checkWin(dot)){
                System.out.println(name);
                return true;
            }
            if(isMapFull()){
                System.out.println("It's a draw");
                return true;
            }
        return false;
    }
    void initMap(){
        for (int i = 0; i < SIZE; i++) 
            for(int j = 0; j < SIZE; j++)
                map[i][j] = DOT_EMPTY;
    }
    
    void printMap(){
        for (int i = 0; i < SIZE; i++)
            for(int j = 0; j < SIZE; j++)
                System.out.println(map[i][j]);
    }
    
   
    void humanTurn(){
        int x, y;
        do{
            System.out.printf("Enter x and y (1..%d) \n", SIZE);
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;//exception
        } while(!isCellValid(x, y));
         map[x][y] = DOT_X;
    }
    
    void aiTurn(){
        System.out.println("AI turn");
        int x, y;
        for(int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++)
                if(isCellValid(i, j)){
                    //win
                    map[i][j] = DOT_O;      
                    if(checkWin(map[i][j])) return;
                    //block
                    map[i][j] = DOT_X;      
                    if(checkWin(map[i][j])){
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;  
                }
        }
        do{
            x = rand.nextInt(SIZE) ;
            y = rand.nextInt(SIZE);
        } while(!isCellValid(x, y));
         map[x][y] = DOT_O;
    }
    
    
    boolean isMapFull(){
        for (int i = 0; i < SIZE; i++) 
            for(int j = 0; j < SIZE; j++)
                if(map[i][j] == DOT_EMPTY)
                    return false;
        return true;
    }
    boolean checkWin(char dot) {                  
        for (int x = 0; x < SIZE; x++)
            for (int y = 0; y < SIZE; y++)
                for (int dx = -1; dx < 2; dx++)
                    for (int dy = -1; dy < 2; dy++)
                        if (comb(x, y, dx, dy, dot) == WIN_SIZE)
                            return true;
        return false;
    }    
     int comb(int x, int y, int dx, int dy, char dot) {
        int count = 0;                              
        if (dx == 0 && dy == 0)
            return 0;
        for (int i = 0, x_ = x, y_ = y; i < WIN_SIZE; i++, x_ += dx, y_ += dy)
            if (x_ >= 0 && y_ >= 0 && x_ < SIZE && y_ < SIZE && map[x_][y_] == dot)
                count++;
        return count;
    }
 
    boolean isCellValid(int x, int y){
        if(x < 0 || y < 0 || x >= SIZE || y >= SIZE)
            return false;
        return map[x][y] == DOT_EMPTY;
    }

}
