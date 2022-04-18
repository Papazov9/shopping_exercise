package input;

import java.util.Scanner;

public class Reader {

    Scanner scanner = new Scanner(System.in);

    public String[] readStringArray(String delimiter) {
        
        return scanner.nextLine().split(delimiter);
    }
}
