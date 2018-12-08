/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**Java1 lesson 6, Продвинутое ООП
 *
 * @author Maria Mikhaleva
 * @version dated  Dec 8 2018
 */
public class Task6 {


    public static void main(String[] args) {
        Animal[] animals = {new Cat(200, 2),
                new Dog(10, 0.5)};
        
        for (Animal animal : animals)
            System.out.println(animal.getClass().getName() +
            "\n\trun: " + animal.run(500) + "\n\tswim: " + animal.swim(5) +
            "\n\tjump: " + animal.jump(1.5) + "\n----------");
        
    }
    
}

interface IAnimal{
    boolean run(int length);
    boolean swim(int length);
    boolean jump(double height);
}

abstract class Animal implements IAnimal{
    public int run_max;
    public double jump_max;
    public int swim_max;
    
    Animal (int run_max, int swim_max, double jump_max){
        this.run_max = run_max;
        this.swim_max = swim_max;
        this.jump_max = jump_max;
    }
    
    public boolean run(int length){
        return run_max >= length;
    }
    
    public boolean swim(int length){
        return swim_max >= length;
    }
    
    public boolean jump(double height){
        return jump_max >= height;
    }
    
}

class Cat extends Animal{
    Cat(int run_max,  int swim_max, double jump_max){
        super(run_max, swim_max, jump_max);
    }
    
    Cat (int run_max, double jump_max){
        super(run_max, -1, jump_max);
    }
    
    @Override
    public boolean swim(int length){
        return false;
    }

}

class Dog extends Animal{
    Dog(int run_max,  int swim_max, double jump_max){
        super(run_max, swim_max, jump_max);
    }
    
    Dog(int swim_max, double jump_max){
        super((400 + (int) (Math.random() * 199) ), swim_max, jump_max);
    }   
    
} 