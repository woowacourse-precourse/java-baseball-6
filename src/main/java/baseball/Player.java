package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Player {

    private final int MAX_LENGTH = 3;
    private final String INITIAL_MESSAGE = "숫자를 입력해주세요 : ";
    private final String NUMBERS_LENGTH_ERROR = "3개의 수를 입력해주세요.";
    private final String DUPLICATE_NUMBER_ERROR = "중복된 숫자는 허용되지 않습니다.";
    private final String NOT_NUMBER_ERROR = "숫자만 입력해주세요.";
    private static final Pattern PLAYER_REGEX = Pattern.compile("[1-9]{3,3}");

    private String pickedPlayerNumbers;
    private List<Character> playerNumbers = new ArrayList<>();

    public List<Character> getPlayerNumbers() {
        return playerNumbers;
    }

    public void setPlayerNumbers() {
        System.out.print(INITIAL_MESSAGE);
        String input = Console.readLine();
        validatePlayerNumber(input);
        stringToList(input);
    }

    private void stringToList(String numbers) {

        for (int i = 0; i < MAX_LENGTH; i++) {
            this.playerNumbers.add(numbers.charAt(i));
        }

    }

    private void validatePlayerNumber(String numbers) {
        validateNumbersLength(numbers);
        validateNumbersType(numbers);
        validateDuplicateNumbers(numbers);
    }

    private void validateNumbersLength(String numbers) {
        if (numbers.length() != MAX_LENGTH) {
            throw new IllegalArgumentException(NUMBERS_LENGTH_ERROR);
        }
    }

    private void validateDuplicateNumbers(String numbers) {
        Set<Character> numberSet = new HashSet<>();

        for (char c : numbers.toCharArray()) {

            if (numberSet.contains(c)) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR);
            }
            numberSet.add(c);
        }

    }

    private void validateNumbersType(String numbers) {
        if (!PLAYER_REGEX.matcher(numbers).matches()) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
    }


}
