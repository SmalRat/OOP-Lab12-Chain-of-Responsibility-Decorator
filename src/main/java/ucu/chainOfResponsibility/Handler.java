package ucu.chainOfResponsibility;

import lombok.Setter;

public abstract class Handler {
    private final int quantity;
    @Setter
    private Handler next;
    public Handler(int quantity) {
        this.quantity = quantity;
    }

    public String process(int amount){
        String results = "";
        if (next != null){
            results = next.process(amount % quantity);
        }
        else if (amount % quantity > 0){
            throw new IllegalArgumentException();
        }
        return quantity + " * " + amount / quantity + "\n" + results;
    }

}
