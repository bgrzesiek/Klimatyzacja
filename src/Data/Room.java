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
        if (currentTemperature<=targetTemperature){
            this.currentTemperature=targetTemperature;
            conditionerOFF();
        }else
            this.currentTemperature = currentTemperature;
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public void runConditioner() {
        configureConditioner();
        cooling();
    }
    public void configureConditioner() {
        if (isTargetTemperatureDone()==false && isConditionerON()==false) {
            conditionerON();
        }
    }

    public void cooling() {
            setCurrentTemperature(getCurrentTemperature() - conditioner.getCooling()/getVolume());
    }

    private boolean isConditionerON(){
        return conditioner.active==true;
    }

    public boolean isTargetTemperatureDone(){
        return getCurrentTemperature()<=getTargetTemperature();
    }

    public void printStatus() {
        System.out.println(getName() + ": target: " + targetTemperature +  " current: " + String.format("%.2f", currentTemperature) + " conditioner: " + printConditionerStatus());
    }

    private String printConditionerStatus(){
        if (conditioner.isActive()==true) {
            return "ON";
        }
        else
            return "OFF";
    }

    public static void sleepOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void conditionerON() {
        conditioner.setActive(true);
    }

    public void conditionerOFF() {
        conditioner.setActive(false);
    }
}
