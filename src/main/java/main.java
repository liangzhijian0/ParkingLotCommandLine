import control.Control;
import model.ParkingBoy;
import view.Input;
import view.Output;

public class main {
    public  static void main(String[] args){
        Output output = new Output();
        Input input = new Input();
        Control control = new Control(input,output);
        ParkingBoy parkingBoy = control.initParkingBoy(4);

        while (true) {
            output.showExecutionMessage();
            int inputOrder = control.executecommand(parkingBoy);
            if(inputOrder == 0) {
                continue;
            }else if (inputOrder == 1) {
                control.park(parkingBoy);
            }else{
                control.unpark(parkingBoy);
            }
        }
        

    }
}
