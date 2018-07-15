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


    public void startExecution(ParkingBoy parkingBoy) {
        int tryConut = 100;
        while (tryConut > 0) {
            tryConut --;
            output.showExecutionMessage();
            try{
                int inputOrder = input.inputOperationChoice();
                if (inputOrder != 1 && inputOrder != 2) {
                    output.showErrorExecutionMessage();
                } else {
                    switch (inputOrder) {
                        case 1: {
                            if (parkingBoy.isFull())
                                output.showParkFullMessage();
                            else {
                                output.showInputCarIdMessage();
                                Car car = new Car(input.inputCarId());
                                Receipt receipt = parkingBoy.park(car);
                                output.showParkSuccessfullyMessage(receipt);
                            }
                        }
                        break;
                        case 2: {
                            output.showInputReciptIdMessage();
                            String str = input.inputReceiptId();
                            try {
                                Car myCar = parkingBoy.unPark(new Receipt(str));
                                output.showUnpartSuccessfullyMessage(myCar);
                            } catch (RuntimeException exception) {
                                output.showtReciptIdErrorMessage();
                            }

                        }
                        break;
                    }
                }
            }catch (Exception e){
                output.showErrorExecutionMessage();
            }

        }
    }
}


