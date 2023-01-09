package ucu.chainOfResponsibility;

public class ATM {
    Handler firstHandler;
    public ATM(){
        Handler handler50 = new Handler50();
        Handler handler20 = new Handler20();
        Handler handler5 = new Handler5();
        handler50.setNext(handler20);
        handler20.setNext(handler5);
        firstHandler = handler50;
    }
    public String process(int amount){
        return firstHandler.process(amount);
    }
}
