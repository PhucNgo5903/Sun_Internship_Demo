public class InterfaceDemo {

    public static void main(String[] args) {
        Soundable.info();
        System.out.println();

        Dog dog = new Dog();
        dog.run();
        dog.sound();
        dog.stop(); 
        System.out.println();

        Duck duck = new Duck();
        duck.run();
        duck.swim();
        duck.sound();
        duck.stop(); 
}

}
