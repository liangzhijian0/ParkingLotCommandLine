package view;

import model.Car;
import model.Receipt;

public class Output {
    public String showExecutionMessage(){
        String msg = "1. 停车\n" + "2. 取车 \n" + "请输入您要进行的操作：";
        System.out.println(msg);
        return msg;
    }
    public void showErrorExecutionMessage(){
        System.out.println("非法指令，请查证后再输");
    }
    public void showInputCarIdMessage(){
        System.out.println("请输入车牌号码：");
    }
    public void showParkSuccessfullyMessage(Receipt receipt){
        System.out.println("停车成功，您的小票是：\n"+receipt.getReceiptId());
    }
    public void showInputReciptIdMessage(){
        System.out.println("请输入小票编号：");
    }
    public void showUnpartSuccessfullyMessage(Car car){
        System.out.println("车已取出，您的车牌号是:"+car.getCarId());
    }
    public void showParkFullMessage(){
        System.out.println("车已停满，请晚点再来");
    }

    public void showtReciptIdErrorMessage(){
        System.out.println("非法小票，无法取出车，请查证后再输");
    }
}
