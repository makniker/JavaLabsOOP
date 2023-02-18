package lab1;

public class Hero {
    Hero(Road road)
    {
        Hero.road = road;
    }
    private static Road road;
    public void move(Vehicle vehicle, int time) {
        road.moveForward(vehicle.ride(time));
        System.out.println("Hero moves on the " + vehicle.getName() + " by " + time + " hours");
        System.out.println(road.getDistanceLeft() + " km left");
    }
}
