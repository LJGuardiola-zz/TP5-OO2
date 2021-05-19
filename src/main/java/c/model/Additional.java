package c.model;

public class Additional implements Combinable {

    private final String description;
    private final double price;

    private final Combinable combinable;

    public Additional(String description, double price, Combinable combinable) {
        this.description = description;
        this.price = price;
        this.combinable = combinable;
    }

    @Override
    public double getCost() {
        return price + combinable.getCost();
    }

    @Override
    public String toString() {
        return combinable.toString() + " + " + description;
    }

}
