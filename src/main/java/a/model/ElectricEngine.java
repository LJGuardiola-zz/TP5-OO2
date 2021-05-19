package a.model;

public class ElectricEngine {

    public void connect() {
        System.out.println(this + " conectado");
    }

    public void activate() {
        System.out.println(this + " activado");
    }

    public void moveFaster() {
        System.out.println(this + " moviéndose mas rápido");
    }

    public void stop() {
        System.out.println(this + " detenido");
    }

    public void disconnect() {
        System.out.println(this + " desconectado");
    }

    @Override
    public String toString() {
        return "Motor eléctrico";
    }

}
