package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private int userNumber;

    public void inputUserNumber() {
        Scanner scanner = new Scanner(System.in);
        userNumber = scanner.nextInt();
        scanner.close();
    }
}
