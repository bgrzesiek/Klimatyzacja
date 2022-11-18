package App;

import Data.Building;
import Data.Conditioner;
import Data.Room;

public class ConditionerSimulator {
    public static void main(String[] args) {
        //javazadania - Klimatyzacja ver 0.1

        Building building= new Building();
        building.controlLoop();
    }
}

