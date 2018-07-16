package view;

import model.Car;
import model.Receipt;

public class Output {
    private String msg;

    public String getString() {
        return msg;
    }

    public void setString(String msg) {
        this.msg = msg;
    }

    public void showExecutionMessage(){
        String msg = "1. 停车\n" + "2. 取车 \n" + "请输入您要进行的操作：";
        System.out.println(msg);
        this.setString(msg);
    }
    public void showErrorExecutionMessage(){
        String msg = "非法指令，请查证后再输";
        System.out.println(msg);
        this.setString(msg);
    }
    public void showInputCarIdMessage(){
        String msg = "请输入车牌号码：";
        System.out.println(msg);
        this.setString(msg);
    }
    public void showParkSuccessfullyMessage(Receipt receipt){
        String msg = "停车成功，您的小票是：\\n\"+receipt.getReceiptId()";
        System.out.println(msg);
        this.setString(msg);
    }
    public void showInputReciptIdMessage(){
        String msg = "请输入小票编号：";
        System.out.println(msg);
        this.setString(msg);
    }
    public void showUnpartSuccessfullyMessage(Car car){
        String msg = "车已取出，您的车牌号是:"+car.getCarId();
        System.out.println(msg);
        this.setString(msg);
    }
    public void showParkFullMessage(){
        String msg = "车已停满，请晚点再来";
        System.out.println(msg);
        this.setString(msg);
    }

    public void showtReciptIdErrorMessage(){
        String msg = "非法小票，无法取出车，请查证后再输";
        System.out.println(msg);
        this.setString(msg);
    }
}
