package controller;

import model.Car;
import model.ParkingBoy;
import model.Receipt;
import view.Request;
import view.Response;

public class ParkingController {
    private Request request;
    private Response response;
    private ParkingBoy parkingBoy;

    public ParkingController(Request request, Response response,ParkingBoy parkingBoy) {
        this.request = request;
        this.response = response;
        this.parkingBoy = parkingBoy;
    }

    public Receipt park(String carId){
        Car car = new Car(carId);
        return parkingBoy.park(car);
    }

    public Car unpark(String parameter){
        return parkingBoy.unPark(new Receipt(parameter));
    }

    public boolean isFull() {
        return parkingBoy.isFull();
    }
}
