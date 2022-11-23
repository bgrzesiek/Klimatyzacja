package Data;

import App.DataReader;

public class Building {

    Room[] rooms = new Room[4];


    Conditioner Pro1 = new Conditioner(2, true);
    Conditioner Pro2 = new Conditioner(2, false);
    Conditioner Basic1 = new Conditioner( 1, false);
    Conditioner Basic2 = new Conditioner( 1, false);

    public Building() {
        rooms[0] = new Room("salon", Pro1, 20, 25.5, 22);
        rooms[1] = new Room("lazienka", Basic1, 5, 25.5, 22);
        rooms[2] = new Room("sypialnia", Pro2, 10, 26, 22);
        rooms[3] = new Room("kuchnia", Basic2, 10, 26, 22);
    }

    public void controlLoop(){
        do {
            for (Room room: rooms){
            room.runConditioner();
            }
            for (Room room: rooms){
            room.printStatus();
            }
        System.out.println();
        Room.sleepOneSecond();
    }
        while (isAllTemperatureOK()==false);
}

    private boolean isAllTemperatureOK(){
        for (Room room: rooms){
            if (room.getCurrentTemperature()>room.getTargetTemperature())
                return false;
        }
        return true;
    }

    public void controlTemperature(int room, double targetTemperature){
        rooms[room-1].setTargetTemperature(targetTemperature);
    }
}




