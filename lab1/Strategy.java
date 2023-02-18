package lab1;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Strategy {
    public static void main(String[] args)
    {
        Road road = new Road(100);
        Hero hero = new Hero(road);
        HashMap<String, Vehicle> vehicles = new HashMap<>();
        vehicles.put("Foot", new Foot());
        vehicles.put("Cart", new Cart());
        vehicles.put("Horse", new Horse());
        vehicles.put("Dragon", new Dragon());
        String name;
        int time;
        Scanner in = new Scanner(System.in);
        while (!road.isComplete())
        {
            System.out.println("Enter name of next vehicle and time: ");
            try{
                name = in.next();
                time = in.nextInt();
                if (vehicles.containsKey(name) && time > 0) {
                    hero.move(vehicles.get(name), time);
                }
                else
                {
                    System.out.println("bad data!");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("time must be int");
            }
        }
        System.out.println("Hero finished his road!");
    }
}
