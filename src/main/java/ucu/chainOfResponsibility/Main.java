package ucu.chainOfResponsibility;

public class Main {
    public static void main(String[] args){
        ATM atm = new ATM();
        System.out.println(atm.process(100));
    }
}
