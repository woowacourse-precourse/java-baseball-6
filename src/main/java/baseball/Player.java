package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player{public void printMessage(String message) {
    System.out.println(message);
}

    public List<Integer> getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");

        List<Integer> userNumbers = new ArrayList<>();
        String userInput = scanner.nextLine();

        try {
            for (int i = 0; i < 3; i++) {
                userNumbers.add(Character.getNumericValue(userInput.charAt(i)));
            }
        } catch (StringIndexOutOfBoundsException | NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 3자리 숫자를 입력하세요.");
        }

        return userNumbers;
    }

    public int getPlayAgainChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
        return scanner.nextInt();
    }
}
