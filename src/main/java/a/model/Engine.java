package a.model;

public abstract class Engine implements Movable {

    public Engine() {
        System.out.println(this + " creado");
    }

    @Override
    public void startUp() {
        System.out.println(this + " arrancado");
    }

    @Override
    public void speedUp() {
        System.out.println(this + " acelerado");
    }

    @Override
    public void turnOff() {
        System.out.println(this + " apagado");
    }

}
