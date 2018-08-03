
/**
 * Java. Level 1. Lesson 7
 *
 * @author Denis Surov
 * @version 03.08.2018
 
*https://github.com/dsurov/git-repo
 */




import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Test.testString(120000);
        //Test.testStringBuilder(120000);
        //Test.testBufferedReader("C:\\Program Files\\AVAST Software\\Avast\\AvastUI.exe");
        //Test.testFileReader("C:\\Program Files\\AVAST Software\\Avast\\AvastUI.exe");
        //Singleton s1 = Singleton.getInstance();
        //Singleton s2 = Singleton.getInstance();
        //System.out.println(s1 + " : " + s2);
        //Cat cat = new Cat("Barsik", 25);
        int SIZE=5;
        Cat[] cat = new Cat[SIZE];
        cat[0] = new Cat("Barsik", 25);
        cat[1] = new Cat("Murzik", 10);
        cat[2] = new Cat("Pushok", 15);
        cat[3] = new Cat("Snezhok", 5);
        cat[4] = new Cat("Vasya", 12);
        Plate plate = new Plate(20);
        for (int i = 0; i < SIZE; i++) {
            System.out.println("В тарелке еды:"+plate.getfood());
            cat[i].eat(plate);
            System.out.println("Кот--" + cat[i].getName() + "--сыт: " + cat[i].getSatiety());
            System.out.println("\n-------------------------\n");
        }


    }
}





class Cat {
    private String name;
    private int appetite;
    private boolean satiety=false;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety=satiety;
    }

    void eat(Plate plate) {

        this.satiety=plate.dicreaseFood(this.appetite);

        System.out.println("В тарелке осталось "+ plate);

    }
    String getName()
    {
        return this.name;
    }
    boolean getSatiety()
    {
        return this.satiety;
    }
}

class Plate {
    private int food;
    private boolean satiety;

    Plate(int food) {
        this.food = food;
    }


    boolean dicreaseFood(int food) {
        if(this.food>=food) {
            this.food -= food;
            this.satiety=true;
            return this.satiety;

        }
        else{System.out.println("---Кот не смог поесть, слишком мало еды---");
            this.satiety=false;
            getPlatefood();

        }
        return satiety;
    }
    boolean getSatiety()
    {
        return this.satiety;
    }
    int getfood()
    {
        return this.food;
    }

    int getPlatefood()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добавить еды в тарелку? 1-да, 2-нет");
        int getPlateFood = scanner.nextInt();
        if(getPlateFood==1) {

        this.food=this.food+10;
        }
        else {
            return this.food;
        }
        return this.food;
    }

    @Override
    public String toString() {
        return "Food: " + food;
    }
}

/**
 * First simple design pattern: Singleton
 */
class Singleton {
    private static Singleton singleton = null;
    // more fields...

    private Singleton() { } // block creation of an instance

    static Singleton getInstance() {
        if (singleton == null)
            singleton = new Singleton();
        return singleton;
    }
    // more methods...
}

class Test {
    /**
     * Testing class String (immutable)
     */
    static void testString(int cycles) {
        System.out.print("Testing String... ");
        long t1 = System.currentTimeMillis();

        String a = "";
        for (int i = 0; i < cycles; i++)
            a += "w";

        long t2 = System.currentTimeMillis();
        System.out.println("It took " + (t2 - t1) + " mc");
    }

    /**
     * Testing class StringBuilder (mutable)
     */
    static void testStringBuilder(int cycles) {
        System.out.print("Testing StringBuilder... ");
        long t1 = System.currentTimeMillis();

        StringBuilder a = new StringBuilder("");
        for (int i = 0; i < cycles; i++)
            a.append("w");

        long t2 = System.currentTimeMillis();
        System.out.println("It took " + (t2 - t1) + " mc");
    }

    /**
     * Testing class FileReader
     */
    static void testFileReader(String fileName) {
        System.out.print("Testing FileReader... ");
        long t1 = System.currentTimeMillis();

        try (FileReader file = new FileReader(fileName)) {
            int x = -1;
            do
                x = file.read();
            while (x != -1);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        long t2 = System.currentTimeMillis();
        System.out.println("It took " + (t2 - t1) + " mc");
    }

    /**
     * Testing class BufferedReader
     */
    static void testBufferedReader(String fileName) {
        System.out.print("Testing BufferedReader... ");
        long t1 = System.currentTimeMillis();

        try (BufferedReader file = new BufferedReader(
                new FileReader(fileName))) {
            int x = -1;
            do
                x = file.read();
            while (x != -1);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        long t2 = System.currentTimeMillis();
        System.out.println("It took " + (t2 - t1) + " mc");
    }
}
