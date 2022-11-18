package Data;

public class Room {
    public String name;
    public Conditioner conditioner;
    public double volume;
    public double currentTemperature;
    public double targetTemperature;

    public Room(String name, Conditioner conditioner, double volume, double currentCemperature, double targetTemperatur) {
        this.name = name;
        this.conditioner = conditioner;
        this.volume = volume;
        this.currentTemperature = currentCemperature;
        this.targetTemperature = targetTemperatur;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Conditioner getConditioner() {
        return conditioner;
    }

    public void setConditioner(Conditioner conditioner) {
        this.conditioner = conditioner;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public void printStatus() {
        System.out.println("Temperatura zadana: " + targetTemperature +" Temperatura w " + getName() + " to: " + String.format("%.2f", currentTemperature) + " stopni c.");
    }

    public void conditionerON() {
        conditioner.setActive(true);
    }

    public void conditionerOFF() {
        conditioner.setActive(false);
    }

    public double cooling() {
        return conditioner.getCooling() / getVolume();
    }

    public void coolTemperature() {
        if (isConditionerON()==false) {
            System.out.println("Nie można chłodzić, włącz klimatyzator w pomieszczeniu: " + getName() +".");
        }
       else if (currentTemperature > targetTemperature) {
            setCurrentTemperature(getCurrentTemperature() - cooling());
        }
    }

    private boolean isConditionerON(){
        return conditioner.active==true;
    }
    public boolean isTemperatureOK(){
        return getCurrentTemperature()== getTargetTemperature();
    }

    public void sleepOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}