/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** Java1. Lesson 7.Практика ООП и работа со строками
 *
 * @author Maria Mikhaleva
 * @version dated Dec 10 2018
 */
public class Task7 {


    public static void main(String[] args) {
        Cat[] cats = {new Cat("Barsik", 0), new Cat("Pushok", 20), new Cat("Dog", 100)};
        Plate plate = new Plate(100);
        for (Cat c : cats){
            System.out.println("Before: " + c);
            c.eatFood(plate);
            System.out.println("After: " + c);
            System.out.println(plate);
            System.out.println("---------");
        }
        System.out.println("Let's add some food to the plate:");
        plate.addFood(10);
        System.out.println(plate);
    }
    
}

class Cat{
    String name;
    int appetite;
    boolean full;
    
    Cat(String name, int appetite){
        this.name = name;
        this.appetite = appetite;
        this.full = (appetite == 0);
    }
    
    void eatFood(Plate plate){
        if(!full){
            appetite = plate.takeFood(appetite);
            full = (appetite==0);
        }
        else System.out.println("Kotik is already full");
    }
    
    @Override
    public String toString(){
        return name + ", " + appetite + ", full: " + full;
    }
}

class Plate{
    int size;
    
    Plate (int size){
        this.size = size;
    }
    
    void addFood (int food){
        size+=food;
    }
    
    public int takeFood(int eatten_food){
        if (eatten_food >= size){
            eatten_food -= size;
            size = 0;
            System.out.println("Kotik ate all plate");
        }
        else{
            size -= eatten_food;
            System.out.println("Kotik ate: " + eatten_food);
            eatten_food = 0;
        }

       return eatten_food;
    }
    @Override
    public String toString(){
        return "Plate: " + size;
    }
}