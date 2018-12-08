
/**
 * Java lesson 5, Введение в ООП
 *
 * @author Maria Mikhaleva
 * @version dated Dec 3 2018
 */

public class Task5 {

    public static void main(String[] args) {
        
        Employee[] emp = new Employee[5];
        emp[0] = new Employee ("A B", "engineer", "ab@mail.ru", "+79995001010", 3000, 35);
        emp[1] = new Employee ("B C", "CEO", "bc@mail.ru", "+79991001010", 50000, 65);
        emp[2] = new Employee ("C D", "technician", "cd@mail.ru", "+79998881010", 6000, 41);
        emp[3] = new Employee ("D E", "developer", "de@mail.ru", "+79991231010", 12000, 45);
        emp[4] = new Employee ("E F", "web designer", "ef@mail.ru", "+79999871010", 8000, 25);
        
        System.out.println("Employees over 40: ");
        for (Employee emp_in : emp){
            if(emp_in.getAge() > 40) emp_in.print();
        }
        System.out.println("\ntoString override: ");
        System.out.println(emp[3].toString());
        
    }
    
}

class Employee{
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    Employee(String name, String position, String email, String phone, int salary, int age){
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    
    int getAge(){
        return age;
    }
    void print() {
        System.out.println(name + " " + position + " " +
                email + " " + phone + " " + salary + " " + age);   
    }
    
    @Override
    public String toString(){
        return name + " is fired. \nSend notification here: " + email;
    }

}