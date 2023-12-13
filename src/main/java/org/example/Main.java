package org.example;

public class Main {
    public static void main(String[] args) {
        Cage cage = new Cage();
        cage.openCage();


        Dog dog = new Dog();
        Cat cat = new Cat();
        Hamster hamster = new Hamster();
        System.out.println("--------------");

        dog.setAge(10);
        cat.setAge(6);
        hamster.setAge(2);

        CountOption NumDog = new CountOption(new DogOption(10));
        CountOption NumCat = new CountOption(new CatOption(15));
        CountOption Numhamster = new CountOption(new HamsterOption(30));

        NumDog.excute();
        NumCat.excute();
        Numhamster.excute();

        NumDog.count();
        NumCat.count();
        Numhamster.count();

        System.out.println("--------------");

        dog.getAge();
        cat.getAge();
        hamster.getAge();
        System.out.println("--------------");

        dog.run();
        cat.run();
        hamster.run();
        System.out.println("--------------");
        cage.closeCage();

    }
    private static void execute(Dog dog){//Liskov Substitution Principle
        if(dog instanceof Dog){
            System.out.println("This is dog");
        }else if(dog instanceof Cat){
            System.out.println("This is cat");
        }else if(dog instanceof Hamster){
            System.out.println("This is hamster");
        }
    }
}
//Dependency Inversion Principle
interface Count{
    void count();
}
class CountOption{
    private Count option;
    public CountOption(Count option){
        this.option = option;
    }
    public void excute(){
        option.count();
    }
    public void count(){
        System.out.println();
    }
}
class DogOption implements Count{
    private int num;

    public DogOption(int i) {
        this.num = i;
    }
    @Override
    public void count(){
        System.out.println("number of dog: "+num);
    }
}
class CatOption implements Count{
    private int num;
    public CatOption(int i) {
        this.num = i;
    }
    @Override
    public void count(){
        System.out.println("number of cat: "+num);
    }
}
class HamsterOption implements Count{
    private int num;
    public HamsterOption(int i) {
        this.num = i;
    }
    @Override
    public void count(){
        System.out.println("number of hamster: "+num);
    }
}

// Interface Segregation Principle
interface Switch{
    void openCage();
    void closeCage();
}
class Use{
    private Switch switchable;
    public Use(Switch switchable){
        this.switchable = switchable;
    }
    public void openCage(){
        switchable.openCage();
    }
    public void closeCage(){
        switchable.closeCage();
    }
}
class Cage implements Switch{
    @Override
    public void openCage(){
        System.out.println("Cage open");
    }
    @Override
    public void closeCage(){
        System.out.println("Cage close");
    }
}

//Single Responsibility Principle
class Dog {
    private String animal = "dog";
    private int age;
    void run(){
        System.out.println("Dog is run");
    }
    void setAge(int i){
        this.age = i;
    }
    int getAge(){
        System.out.println(animal +" age: "+age);
        return age;
    }

}
class Cat extends Dog {
    private int age;
    private String animal = "cat";
    //Open-Closed Principle
    @Override
    void run(){
        System.out.println("Cat is run");
    }
    @Override
    void setAge(int i){
        this.age = i;
    }
    @Override
    int getAge(){
        System.out.println(animal +" age: "+age);
        return age;
    }
}
class Hamster extends Dog{
    private int age;
    private String animal = "hamster";
    //Open-Closed Principle
    @Override
    void run(){
        System.out.println("Hamster is run");
    }
    @Override
    void setAge(int i){
        this.age = i;
    }

    int getAge(){
        System.out.println(animal +" age: "+age);
        return age;
    }
}
