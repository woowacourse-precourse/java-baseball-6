package baseball.view;

import baseball.exception.InputException;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {

    private final static String GET_GAME_NUM = "숫자를 입력해주세요 : ";
    private final static String GET_DECISION_NUM = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public List<Integer> getGameNum() {
        System.out.print(GET_GAME_NUM);
        String gameNum = Console.readLine();

        validateNum(gameNum);
        validateCount(gameNum);
        validateDuplicate(gameNum);

        return stringToList(gameNum);
    }

    public int getDecisionNum() {
        System.out.println(GET_DECISION_NUM);
        String decisionNum = Console.readLine();
        validateDecision(decisionNum);
        return Integer.parseInt(decisionNum);
    }

    private void validateDecision(String line) {
        if (!line.equals("1") && !line.equals("2")) {
            throw new IllegalArgumentException(InputException.INVALID_DECISION_NUM.getExceptionMessage());
        }
    }

    private void validateNum(String line) {
        if (!line.matches("\\d+")) {
            throw new IllegalArgumentException(InputException.NOT_INTEGER.getExceptionMessage());
        }
    }

    private void validateCount(String line) {
        if (line.length() != 3) {
            throw new IllegalArgumentException(InputException.MISMATCH_COUNT.getExceptionMessage());
        }
    }

    private void validateDuplicate(String line) {
        Set<Character> set = new HashSet<>();
        for (char c : line.toCharArray()) {
            if (set.contains(c)) {
                throw new IllegalArgumentException(InputException.DUPLICATE_NUM.getExceptionMessage());
            }
            set.add(c);
        }
    }

    private static List<Integer> stringToList(String line) {
        List<Integer> result = new ArrayList<>();
        for (char c : line.toCharArray()) {
            int digit = Character.getNumericValue(c);
            result.add(digit);
        }
        return result;
    }
}
