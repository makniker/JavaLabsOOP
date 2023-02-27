package lab1;

public class Hero {
    private static Road road;
    private IVehicle IVehicle = new Foot();
    Hero(Road road) {
        Hero.road = road;
    }

    public void setVehicle(IVehicle IVehicle1) {
        this.IVehicle = IVehicle1;
    }

    public void move(int time) {
        road.moveForward(IVehicle.ride(time));
        System.out.println("Hero moves on the " + IVehicle.getName() + " by " + time + " hours");
        System.out.println(road.getDistanceLeft() + " km left");
    }
}
