package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserBalls {
    private final List<Integer> userBalls;
    private final static String ErrorMessage = "1~9까지의 숫자 중 3개를 선택하여 중복없이 입력해 주세요.(예: 453)";

    public UserBalls(List<Integer> userBalls) {
        this.userBalls = userBalls;
    }

    public static UserBalls makeUserBalls(String userInput) {
        validateUserInput(userInput);
        List<Integer> userBalls = stringToList(userInput);
        validateDuplication(userBalls);
        return new UserBalls(userBalls);
    }

    private static void validateDuplication(List<Integer> userBalls) {
        Set<Integer> set = new HashSet<>(userBalls);
        if (set.size() != RandomBalls.BALLS_COUNT) {
            throw new IllegalArgumentException(ErrorMessage);
        }
    }

    private static List<Integer> stringToList(String userInput) {
        List<Integer> userBalls = new ArrayList<>();
        for (String s : userInput.split("")) {
            userBalls.add(Integer.parseInt(s));
        }
        return userBalls;
    }

    private static void validateUserInput(String userInput) {
        if (!checkLength(userInput)) {
            throw new IllegalArgumentException(ErrorMessage);
        } else if (!checkNumberFormat(userInput)) {
            throw new IllegalArgumentException(ErrorMessage);
        }
    }

    private static boolean checkNumberFormat(String userInput) {
        for (char c : userInput.toCharArray()) {
            if (c < '1' || c > '9') {
                return false;
            }
        }
        return true;
    }

    private static boolean checkLength(String userInput) {
        return userInput.length() == RandomBalls.BALLS_COUNT;
    }

    public static String getUserInput() {
        return readLine();
    }

    public int getBall(int idx) {
        return userBalls.get(idx);
    }

    public boolean contains(int currentBall) {
        return this.userBalls.contains(currentBall);
    }
}
