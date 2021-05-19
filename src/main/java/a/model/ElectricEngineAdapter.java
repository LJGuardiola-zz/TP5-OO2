package a.model;

public class ElectricEngineAdapter extends Engine {

    private final ElectricEngine engine;

    public ElectricEngineAdapter(ElectricEngine engine) {
        this.engine = engine;
    }

    @Override
    public void startUp() {
        engine.connect();
        engine.activate();
    }

    @Override
    public void speedUp() {
        engine.moveFaster();
    }

    @Override
    public void turnOff() {
        engine.stop();
        engine.disconnect();
    }

    @Override
    public String toString() {
        return "Adaptador de Motor eléctrico";
    }

}
