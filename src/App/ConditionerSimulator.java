package App;

import Data.Building;
import Data.Conditioner;
import Data.Room;

public class ConditionerSimulator {
    public static void main(String[] args) {
        AirConditioningSystemControl airConditioningSystemControl = new AirConditioningSystemControl();
        airConditioningSystemControl.controlLoop();
    }
}


