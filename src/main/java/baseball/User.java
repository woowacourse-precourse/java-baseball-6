package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    public static final String NEW_GAME = "1";
    public static final String END_GAME = "2";
    private static final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String USER_NUMBER_ERROR_MESSAGE = "1~9사이의 숫자를 이용해서 서로 다른 세 자리 숫자를 입력해주세요.";

    public static String startNewGameOrNot() throws IllegalArgumentException {
        System.out.printf("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.", NEW_GAME, END_GAME);
        System.out.println();

        String startNewGameOrNotInPut = Console.readLine();
        if (END_GAME.equals(startNewGameOrNotInPut) || NEW_GAME.equals(startNewGameOrNotInPut)) {
            return startNewGameOrNotInPut;
        }
        throw new IllegalArgumentException(NEW_GAME + "이나 " + END_GAME + "를 입력하지 않아 강제종료합니다.");
    }

    public static List<Integer> createUserNumber() {
        List<Integer> userNumber = new ArrayList<>();
        System.out.print(USER_INPUT_MESSAGE);

        String userInput = Console.readLine();
        validate(userInput);
        userNumber.add(Integer.parseInt(userInput));

        return userNumber;
    }

    private static void validate(String userInput) {
        isNumber(userInput);
        hasZero(userInput);
        isDistinctThreeDightNumber(userInput);
    }

    private static void isNumber(String userInput) throws IllegalArgumentException {
        try {
            int userInputToInt = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(USER_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void hasZero(String userInput) throws IllegalArgumentException {
        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) == '0') {
                throw new IllegalArgumentException(USER_NUMBER_ERROR_MESSAGE);
            }
        }
    }

    private static void isDistinctThreeDightNumber(String userInput) throws IllegalArgumentException {
        Set<Character> setForDistinctThreeDigitNumber = new HashSet<>();

        for (char userInputToChar : userInput.toCharArray()) {
            setForDistinctThreeDigitNumber.add(userInputToChar);
        }

        if (setForDistinctThreeDigitNumber.size() != 3) {
            throw new IllegalArgumentException(USER_NUMBER_ERROR_MESSAGE);
        }
    }
}
