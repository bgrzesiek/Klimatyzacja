package App;

import java.util.Scanner;

public class DataReader {
    private Scanner scanner = new Scanner(System.in);

    public void close(){
        scanner.close();
    }

    public double readTargetTemerature() {
        System.out.println("Zadaj temepraturę");
        return scanner.nextDouble();
    }

    public int getIn(){
        return scanner.nextInt();
    }
}
