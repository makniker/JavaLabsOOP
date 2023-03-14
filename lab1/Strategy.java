package lab1;

import java.util.HashMap;
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
            name = in.next();
            if (in.hasNextInt()) {
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
            else {
                System.out.println("Time must be int");
            }
        }
        in.close();
        System.out.println("Hero finished his road!");
    }
}
