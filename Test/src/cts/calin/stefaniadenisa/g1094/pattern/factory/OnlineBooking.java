package cts.calin.stefaniadenisa.g1094.pattern.factory;

public abstract class OnlineBooking {
    String eventName;
    int price;

    public OnlineBooking(String eventName, int price) {
        super();
        this.eventName = eventName;
        this.price = price;
    }

    public abstract String getType();

    public void displayDescription() {
        System.out.println(
                String.format("It's a {0} type ticket for {1} with a price of {2}", this.getType(), eventName, price));
    }
}
