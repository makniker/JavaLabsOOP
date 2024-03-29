package lab1;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Strategy {
    public static void main(String[] args)
    {
        Hero hero = new Hero(100);
        HashMap<String, IVehicle> vehicles = new HashMap<>();
        vehicles.put("Foot", new Foot());
        vehicles.put("Cart", new Cart());
        vehicles.put("Horse", new Horse());
        vehicles.put("Dragon", new Dragon());
        String name;
        int time;
        Scanner in = new Scanner(System.in);
        while (!hero.isRoadComplete())
        {
            System.out.println("Enter name of vehicle and time:\n");
            try{
                name = in.next();
                time = in.nextInt();
                if (vehicles.containsKey(name) && time > 0) {
                    hero.setVehicle(vehicles.get(name));
                    hero.move(time);
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
        in.close();
        System.out.println("Hero finished his road!");
    }
}
