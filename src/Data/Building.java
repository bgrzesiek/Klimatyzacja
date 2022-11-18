package Data;

public class Building {

    Room[] rooms = new Room[4];

    Conditioner BasicAirConditioner = new Conditioner("Basic", 1, true);
    Conditioner ProAirConditioner = new Conditioner("Pro", 2, false);

    public Building() {
        rooms[0] = new Room("salon", ProAirConditioner, 30, 24.5, 24);
        rooms[1] = new Room("lazienka", BasicAirConditioner, 10, 25, 24);
        rooms[2] = new Room("sypialnia", BasicAirConditioner, 10, 25, 23);
        rooms[3] = new Room("kuchnia", BasicAirConditioner, 10, 26, 24);
    }

    public void controlLoop(){
        do {
            for (Room room: rooms){
            room.coolTemperature();
            }
            for (Room room: rooms){
            room.printStatus();
            }
        System.out.println();
        rooms[0].sleepOneSecond();
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

}




