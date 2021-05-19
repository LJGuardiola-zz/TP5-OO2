package c.model;

public class Combo implements Combinable {

    private final String description;
    private final double price;

    public Combo(String description, double price) {
        this.description = description;
        this.price = price;
    }

    @Override
    public double getCost() {
        return price;
    }

    @Override
    public String toString() {
        return description;
    }

}
