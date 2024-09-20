// Abstract class Animal
abstract class Animal {
    // Abstract method for making sound
    abstract void makeSound();
    
    // Abstract method for eating
    abstract void eat();
}

// Subclass Dog
class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog says: Woof Woof");
    }
    
    @Override
    void eat() {
        System.out.println("Dog is eating dog food.");
    }
}

// Subclass Cat
class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Cat says: Meow Meow");
    }
    
    @Override
    void eat() {
        System.out.println("Cat is eating cat food.");
    }
}

// Subclass Bird
class Bird extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bird says: Tweet Tweet");
    }
    
    @Override
    void eat() {
        System.out.println("Bird is eating seeds.");
    }
}

// Main class to test the implementation
public class Main {
    public static void main(String[] args) {
        // Creating objects of each subclass
        Animal dog = new Dog();
        Animal cat = new Cat();
        Animal bird = new Bird();
        
        // Calling makeSound and eat methods
        dog.makeSound();
        dog.eat();
        
        cat.makeSound();
        cat.eat();
        
        bird.makeSound();
        bird.eat();
    }
}