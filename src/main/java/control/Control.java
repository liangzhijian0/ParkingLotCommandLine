package control;

import model.Car;
import model.ParkingBoy;
import model.ParkingLot;
import model.Receipt;
import view.Input;
import view.Output;

import java.util.ArrayList;
import java.util.List;

public class Control {
    private Input input;
    private Output output;

    public Control(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public ParkingBoy initParkingBoy(int N) {
        List<ParkingLot> parkingLotlist = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            parkingLotlist.add(new ParkingLot(2));
        }
        return new ParkingBoy(parkingLotlist);
    }


    public int executecommand(ParkingBoy parkingBoy) {
        int inputOrder = input.inputOperationChoice();

        try{
            if(inputOrder == 1){
                if (parkingBoy.isFull()){
                    output.showParkFullMessage();
                    inputOrder = 0;
                }else{
                    output.showInputCarIdMessage();
                }
            }else if(inputOrder == 2){
                output.showInputReciptIdMessage();
            }else{
                output.showErrorExecutionMessage();
                inputOrder = 0;
            }
        }catch (Exception e){
            output.showErrorExecutionMessage();
        }
        return inputOrder;
    }

    public void park(ParkingBoy parkingBoy){
        Car car = new Car(input.inputCarId());
        Receipt receipt = parkingBoy.park(car);
        output.showParkSuccessfullyMessage(receipt);
    }

    public void unpark(ParkingBoy parkingBoy) {
        String str = input.inputReceiptId();
        try {
            Car myCar = parkingBoy.unPark(new Receipt(str));
            output.showUnpartSuccessfullyMessage(myCar);
        } catch (RuntimeException exception) {
            output.showtReciptIdErrorMessage();
        }
    }
}


