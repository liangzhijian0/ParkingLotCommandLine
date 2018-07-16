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

    public void unparkPage(Request request) {
        try {
            Car car = unpark(request.getParameter());
            response.send("车已取出，您的车牌号是:"+ car.getCarId());
        } catch (RuntimeException exception) {
            response.send("非法小票，无法取出车，请查证后再输");
        }
        printMainInterface();
    }

    public void parkPage(Request request) {
        Receipt receipt = park(request.getParameter());
        response.send("停车成功，您的小票是：\n"+receipt.getReceiptId());
        printMainInterface();
    }

    public String mainPage(Request request){
        String currentPage = "main";
        switch (request.getParameter()){
            case "1" :
                if(isFull()){
                    response.send("车已停满，请晚点再来");
                    printMainInterface();
                }else{
                    currentPage = "park";
                    response.send("请输入车牌号码: ");
                }
                break;
            case "2" :
                currentPage = "unpark";
                response.send("请输入小票编号：");
                break;
            default:
                response.send("非法指令，请查证后再输");
                printMainInterface();
        }
        return currentPage;
    }

    public void printMainInterface(){
        response.send("1. 停车\n" + "2. 取车 \n" + "请输入您要进行的操作：");
    }
}
