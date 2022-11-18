package Data;

public class Conditioner {
    public String name;
    public double cooling; //przy wydajnośći 1m3/min
    public boolean active;

    public Conditioner(String name, double cooling, boolean active) {
        this.name = name;
        this.cooling = cooling;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


