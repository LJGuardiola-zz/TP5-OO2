package a.model;

public class Main {
    public static void main(String[] args) {

        Engine normalEngine = new NormalEngine();

        normalEngine.startUp();
        normalEngine.speedUp();
        normalEngine.turnOff();

        Engine economicEngine = new EconomicEngine();

        economicEngine.startUp();
        economicEngine.speedUp();
        economicEngine.turnOff();

        Engine electricEngine = new ElectricEngineAdapter(new ElectricEngine());

        electricEngine.startUp();
        electricEngine.speedUp();
        electricEngine.turnOff();

    }
}
