package SummaryOfPillars;

// 1) interface for ALL Vehicle
interface Vehicle {
    void start();
    void stop();
    void fast(double speed);
}


// 2) Abstract BluePrint Class for ALL Vehicle (implementing the interface)
abstract class BaseVehicle implements Vehicle{
    protected String brand;
    protected String model;
    protected double speed;
    // Constructor
    public BaseVehicle(String brand, String model){
        this.brand = brand;
        this.model = model;
        this.speed = 0;
    }
    // implementing start, stop and fast
    public void start(){
        System.out.println(brand + " " + model + " is starting.");
    }
    public void stop(){
        speed = 0;
        System.out.println(brand + " " + model + " is stopping.");
    }
    public void fast(double speed){
        this.speed += speed + 50;
        System.out.println(brand + " " + model + " is now going at " + this.speed + " km/h");
    }
    // Method Overloading - fast with two parameters
    public void fast(double speed, String roadType) {
        if (roadType.equalsIgnoreCase("Highway")) {
            this.speed += speed + 60;
        } else {
            this.speed += speed;
        }
        System.out.println(brand + " " + model + " is now going at " + this.speed + " km/h on " + roadType + ".");
    }
    // Finally Abstract method to get the type of vehicle
    public abstract void getVehicleType();
}



// 3) Concrete CLass (subClass of the abstract class)
class Car extends BaseVehicle{
    private int doors;
    // Constructor
    public Car(String brand, String model, int doors) {
        super(brand, model);
        this.doors = doors;
    }
    // first implement the abstract methods
    public void getVehicleType() {
        System.out.println("This is a Car.");
    }
    @Override
    public void fast(double speed){
        this.speed += speed;
        System.out.println(brand + " " + model + " CAR is now going at " + this.speed + " km/h.");
    }
    // Car-specific method
    public void openTrunk() {
        System.out.println("Trunk is open.");
    }
}
// 4) Another Concrete CLass (subClass of the abstract class)
class MotorCycle extends BaseVehicle {
    // Constructor
    public MotorCycle(String brand, String model){
        super(brand, model);
    }
    // first implement the abstract method
    public void getVehicleType() {
        System.out.println("This is a Motorcycle.");
    }
    @Override
    public void fast(double speed){
        this.speed += speed;
        System.out.println(brand + " " + model + " MOTORCYCLE is now going at " + this.speed + " km/h.");
    }

}
// 5) Main Class
public class VehicleManagement {
    public static void main(String[] args) {
        Car myNewCar = new Car("Tesla", "Model S", 4);
        MotorCycle myNewMotor = new MotorCycle("MotorEasy", "Iron-93");
        myNewCar.openTrunk();;
        myNewCar.stop();
        myNewCar.start();
        myNewCar.fast(50, "Highway");

        myNewMotor.fast(25);
        myNewMotor.getVehicleType();
    }
}
