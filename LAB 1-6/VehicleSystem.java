class Vehicle {
    String brand;
    int speed;

    Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    void displayInfo() {
        System.out.println(" Vehicle Brand: " + brand);
        System.out.println(" Speed: " + speed + " km/h");
    }
}

class Car extends Vehicle {
    int seats;

    Car(String brand, int speed, int seats) {
        super(brand, speed); 
        this.seats = seats;
    }
 
    void displayInfo() {
        super.displayInfo();
        System.out.println(" Seats: " + seats);
    }
}

class ElectricCar extends Car {
    int batteryCapacity;

    ElectricCar(String brand, int speed, int seats, int batteryCapacity) {
        super(brand, speed, seats); 
        this.batteryCapacity = batteryCapacity;
    }

    void displayInfo() {
        super.displayInfo(); 
        System.out.println(" Battery Capacity: " + batteryCapacity + " kWh");
    }
}

public class VehicleSystem {
    public static void main(String[] args) {
        Vehicle v = new Vehicle("Generic Vehicle", 100);
        Car c = new Car("Toyota", 180, 5);
        ElectricCar e = new ElectricCar("Tesla", 250, 5, 100);

        System.out.println("\n Vehicle Info ");
        v.displayInfo();

        System.out.println("\n Car Info ");
        c.displayInfo();

        System.out.println("\n Electric Car Info ");
        e.displayInfo();
    }
}
