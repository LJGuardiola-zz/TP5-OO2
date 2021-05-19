package c.model;

public class Main {
    public static void main(String[] args) {

        Combinable combinable =
                new Additional("Coca Cola de 1L", 220,
                        new Additional("Cono de papas fritas", 150,
                                new Combo("Sandwich de milanesa", 250)
                        )
                );

        System.out.println(combinable + " - $ARS " + combinable.getCost());

    }
}
