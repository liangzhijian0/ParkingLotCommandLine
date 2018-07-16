import controller.ParkingController;
import model.Car;
import model.Receipt;
import view.Request;
import view.Response;

public class Router {
    private String currentPage;
    private ParkingController controller;
    private Response response = new Response();

    public Router(String currentPage,ParkingController controller){
        this.currentPage = currentPage;
        this.controller = controller;
    }


    public void handleRequest(Request request) {
        switch (currentPage){
            case "main" :
                mainPage(request);
                break;
            case "park" :{
                parkPage(request);
                break;
            }
            case "unpark" :{
                unparkPage(request);
                break;
            }
        }
    }

    private void unparkPage(Request request) {
        try {
            Car car = controller.unpark(request.getParameter());
            response.send("车已取出，您的车牌号是:"+ car.getCarId());
        } catch (RuntimeException exception) {
            response.send("非法小票，无法取出车，请查证后再输");
        }
        this.currentPage = "main";
        printMainInterface();
    }

    private void parkPage(Request request) {
        Receipt receipt = controller.park(request.getParameter());
        this.currentPage = "main";
        response.send("停车成功，您的小票是：\n"+receipt.getReceiptId());
        printMainInterface();
    }

    public void mainPage(Request request){
        switch (request.getParameter()){
            case "1" :
                if(controller.isFull()){
                    response.send("车已停满，请晚点再来");
                    printMainInterface();
                }else{
                    this.currentPage = "park";
                    response.send("请输入车牌号码: ");
                }
                break;
            case "2" :
                this.currentPage = "unpark";
                response.send("请输入小票编号：");
                break;
            default:
                response.send("非法指令，请查证后再输");
                printMainInterface();
        }
    }

    public void printMainInterface(){
        response.send("1. 停车\n" + "2. 取车 \n" + "请输入您要进行的操作：");
    }
}
