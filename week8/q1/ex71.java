import java.util.Random;

class NumberGenerator extends Thread {
    public int number;
    private boolean running = true;

    @Override
    public void run() {
        Random rand = new Random();
        try {
            while (running) {
                number = rand.nextInt(100) + 1;
                System.out.println("Generated number: " + number);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("NumberGenerator interrupted.");
        }
    }

    public void stopGenerating() {
        running = false;
    }
}

class EvenSquare extends Thread {
    private NumberGenerator generator;

    public EvenSquare(NumberGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (generator.number % 2 == 0) {
                    int square = generator.number * generator.number;
                    System.out.println("Square of " + generator.number + " is: " + square);
                }
                Thread.sleep(1000); 
            }
        } catch (InterruptedException e) {
            System.out.println("EvenSquare interrupted.");
        }
    }
}

class OddCube extends Thread {
    private NumberGenerator generator;

    public OddCube(NumberGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (generator.number % 2 != 0) {
                    int cube = generator.number * generator.number * generator.number;
                    System.out.println("Cube of " + generator.number + " is: " + cube);
                }
                Thread.sleep(1000); 
            }
        } catch (InterruptedException e) {
            System.out.println("OddCube interrupted.");
        }
    }
}

public class ex71 {
    public static void main(String[] args) {
        NumberGenerator generator = new NumberGenerator();

        EvenSquare evenSquare = new EvenSquare(generator);
        OddCube oddCube = new OddCube(generator);

        generator.start();
        evenSquare.start();
        oddCube.start();

        try {
            Thread.sleep(10000); 
            generator.stopGenerating(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
