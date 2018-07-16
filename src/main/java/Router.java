import controller.ParkingController;
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
                currentPage = controller.mainPage(request);
                break;
            case "park" :{
                controller.parkPage(request);
                currentPage = "main";
                break;
            }
            case "unpark" :{
                controller.unparkPage(request);
                currentPage = "main";
                break;
            }
        }
    }


}
