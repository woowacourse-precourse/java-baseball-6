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

    public List<Integer> convertInputToList() {
        List<Integer> user = new ArrayList<>();
        user.add(userNumber / 100);                     // 100의 자리
        user.add((userNumber % 100) / 10);             // 10의 자리
        user.add(userNumber % 10);                     // 1의 자리
        return user;
    }
}
