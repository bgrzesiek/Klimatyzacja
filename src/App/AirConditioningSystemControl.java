package App;

import Data.Building;
import Data.Room;

public class AirConditioningSystemControl {

        private static final int EXIT = 0;
        private static final int SYSTEM_RUN = 1;
        private static final int SET_TARGET_TEMPERATURES = 2;
        private static final int SALON = 1;
        private static final int LAZIENKA = 2;
        private static final int SYPIALNIA = 3;
        private static final int KUCHNIA = 4;

        private DataReader dataReader = new DataReader();
        private Building building = new Building();
        private Room[] rooms = new Room[4];

        public void controlLoop () {
            int option;
            do {
                printOption();
                option = dataReader.getIn();
                switch (option) {
                    case SYSTEM_RUN:
                        building.controlLoop();
                        break;
                    case SET_TARGET_TEMPERATURES:
                        SetTemperatureControlLoop();
                        break;
                    case EXIT:
                        exit();
                        break;
                    default:
                        System.out.println("Nie ma takiej opcji, wprowadź ponownie: ");
                }
            } while (option != EXIT);
        }

        private void printOption () {
            System.out.println("Wybierz opcje:");
            System.out.println(EXIT + "- wyjście z programu");
            System.out.println(SYSTEM_RUN + "- System start");
            System.out.println(SET_TARGET_TEMPERATURES + "- Ustaw temperaturę docelową");
        }

         private void printOption2 () {
            System.out.println("Wybierz pomieszczenie:");
            System.out.println(SALON + "- Salon");
            System.out.println(LAZIENKA + "- Lazienka");
            System.out.println(SYPIALNIA + "- Sypialnia");
            System.out.println(KUCHNIA + "- Kuchnia");
            System.out.println(EXIT + "- Wstecz");
    }

        private void exit () {
            System.out.println("Do zobaczenia!");
            dataReader.close();
        }

        private int SetTemperatureControlLoop () {
            int option;
            do {
                printOption2();
                option = dataReader.getIn();
                switch (option) {
                    case SALON:
                        setTargetTemperature(SALON);
                        break;
                    case LAZIENKA:
                        setTargetTemperature(LAZIENKA);
                        break;
                    case SYPIALNIA:
                        setTargetTemperature(SYPIALNIA);
                        break;
                    case KUCHNIA:
                        setTargetTemperature(KUCHNIA);
                        break;
                    case EXIT:
                        controlLoop();
                        break;
                    default:
                        System.out.println("Nie ma takiej opcji, wprowadź ponownie: ");
                }
            } while (option != EXIT);
            return option;
        }

        private void setTargetTemperature(int room) {
            double newTemperature = dataReader.readTargetTemerature();
            building.controlTemperature(room, newTemperature);
        }
    }



