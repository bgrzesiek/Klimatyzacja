package Data;

public class Conditioner {
    public double cooling; //przy wydajnośći 1m3/min
    public boolean active;

    public Conditioner(double cooling, boolean active) {

        this.cooling = cooling;
        this.active = active;
    }

    public double getCooling() {
        return cooling;
    }

    public void setCooling(double cooling) {
        this.cooling = cooling;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}


