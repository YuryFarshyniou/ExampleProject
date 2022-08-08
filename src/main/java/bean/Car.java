package bean;

public class Car extends Vehicle {

    private Integer seats;

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    @Override
    public String getVehicleInformation() {
        return  String.valueOf(this.seats)+" In our Car!";
    }
}
