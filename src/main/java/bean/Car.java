package bean;

public class Car extends Vehicle {

    private int seats;

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Car() {

    }

    public Car(Integer seats, Vehicle vehicle) {
        this.seats = seats;
        vehicle.customMethod();
    }

    @Override
    public String getVehicleInformation() {
        return this.seats + " In our Car!";
    }

    public void someMethod(String carName, int engPower) {
        System.out.println(carName + " " + engPower + " HorsePowers");
    }
}
