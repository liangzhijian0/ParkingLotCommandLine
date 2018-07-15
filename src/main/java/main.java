import control.Control;
import model.ParkingBoy;
import view.Input;
import view.Output;

public class main {
    public  static void main(String[] args){
        Control control = new Control(new Input(),new Output());
        ParkingBoy parkingBoy = control.initParkingBoy(4);
        control.startExecution(parkingBoy);
    }
}
