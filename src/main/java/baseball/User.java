package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static final String USER_WANT_RESTART = "1";
    private static final String USER_WANT_END = "2";

    private final List<Integer> userNumbers = new ArrayList<>();

    public void askUserNumbers() {
        userNumbers.clear();

        System.out.print("숫자를 입력해주세요: ");

        String userInput = Console.readLine();

        if (userInput.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }

        for (char number : userInput.toCharArray()) {
            userNumbers.add(Character.getNumericValue(number));
        }
    }

    public boolean isWantRestart() {
        String userResponse = askUserWantRestart();

        if (userResponse.equals(USER_WANT_RESTART)) {
            return true;
        }

        if (userResponse.equals(USER_WANT_END)) {
            return false;
        }

        throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
    }

    private String askUserWantRestart() {
        System.out.println("게임을 새로 시작하려면 " + USER_WANT_RESTART + ", 종료하려면 " + USER_WANT_END + "를 입력하세요.");
        return Console.readLine();
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }
}
