import controller.ParkingController;
import model.ParkingBoy;
import model.ParkingLot;
import view.Cli;
import view.Request;
import view.Response;

import java.util.ArrayList;
import java.util.List;


public class main {
    public  static void main(String[] args){
        Request request = new Request() ;
        Response response = new Response();

        List<ParkingLot> parkingLotlist = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            parkingLotlist.add(new ParkingLot(2));
        }
        ParkingBoy parkingBoy =  new ParkingBoy(parkingLotlist);

        Cli cli = new Cli();
        ParkingController parkingController = new ParkingController(request,response,parkingBoy);
        Router router = new Router("main",parkingController);
        router.printMainInterface();

        while (true) {
            String command = cli.read();
            request.setParameter(command);
            router.handleRequest(request);
        }
    }
}
