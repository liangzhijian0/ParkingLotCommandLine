package view;

import java.util.Scanner;

public class Input {

    public int inputOperationChoice(){
        Scanner read = new Scanner(System.in);
        return read.nextInt();
    }

    public String inputCarId(){
        Scanner read = new Scanner(System.in);
        return read.nextLine();
    }

    public String inputReceiptId(){
        Scanner read = new Scanner(System.in);
        return read.nextLine();
    }
}
