package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<Integer> userNumbers = new ArrayList<>();

    public void askUserNumbers() {
        userNumbers.clear();

        System.out.print("숫자를 입력해주세요: ");

        String userInput = Console.readLine();
        for (char number : userInput.toCharArray()) {
            userNumbers.add(Character.getNumericValue(number));
        }
    }

    public boolean isWantRestart() {
        String userResponse = askUserWantRestart();

        if (userResponse.equals("1")) {
            return true;
        }

        if (userResponse.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
    }

    private String askUserWantRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }


    public List<Integer> getUserNumbers() {
        return userNumbers;
    }
}
