package Data;

public class Building {

    Room[] rooms = new Room[4];

    Conditioner BasicAirConditoner = new Conditioner("Basic", 1, true);
    Conditioner ProAirConditoner = new Conditioner("Pro", 2, true);

    public Building() {
        rooms[0] = new Room("salon", ProAirConditoner, 30, 25, 24);
        rooms[1] = new Room("lazienka", BasicAirConditoner, 10, 25, 24);
        rooms[2] = new Room("sypialnia", BasicAirConditoner, 10, 25, 23);
        rooms[3] = new Room("kuchnia", BasicAirConditoner, 10, 26, 24);
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
            room.isTemperatureOK();
        }
        return rooms[0].isTemperatureOK() == true ||rooms[1].isTemperatureOK() == true || rooms[2].isTemperatureOK() == true || rooms[3].isTemperatureOK() == true;
    }

}




