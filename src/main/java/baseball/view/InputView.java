package baseball.view;

import baseball.exception.InputException;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {

    private final static String GET_GAME_NUM = "숫자를 입력해 주세요 : ";

    public List<Integer> getGameNum() {
        System.out.println(GET_GAME_NUM);
        String gameNum = Console.readLine();

        validateNum(gameNum);
        validateCount(gameNum);
        validateDuplicate(gameNum);

        return stringToList(gameNum);
    }

    public void validateNum(String line) {
        if (!line.matches("\\d+")) {
            throw new IllegalArgumentException(InputException.NOT_INTEGER.getExceptionMessage());
        }
    }

    public void validateCount(String line) {
        if (line.length() != 3) {
            throw new IllegalArgumentException(InputException.MISMATCH_COUNT.getExceptionMessage());
        }
    }

    public void validateDuplicate(String line) {
        Set<Character> set = new HashSet<>();
        for (char c : line.toCharArray()) {
            if (set.contains(c)) {
                throw new IllegalArgumentException(InputException.DUPLICATE_NUM.getExceptionMessage());
            }
            set.add(c);
        }
    }

    public static List<Integer> stringToList(String line) {
        List<Integer> result = new ArrayList<>();
        for (char c : line.toCharArray()) {
            int digit = Character.getNumericValue(c);
            result.add(digit);
        }
        return result;
    }
}
