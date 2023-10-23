package baseball;

import baseball.utils.ExceptionMessage;
import baseball.utils.PlayMessage;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Player {

    private final int MAX_LENGTH = 3;
    private static final Pattern PLAYER_REGEX = Pattern.compile("[1-9]{3,3}");
    private static final String START = "1";
    private static final String END = "9";

    private String pickedPlayerNumbers;
    private List<Character> playerNumbers = new ArrayList<>();

    public List<Character> getPlayerNumbers() {
        return playerNumbers;
    }

    public void setPlayerNumbers() {
        System.out.print(PlayMessage.INPUT_MESSAGE.getMessage());
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
            throw new IllegalArgumentException(ExceptionMessage.NUMBERS_LENGTH_ERROR.getMessage());
        }
    }

    private void validateDuplicateNumbers(String numbers) {
        Set<Character> numberSet = new HashSet<>();

        for (char c : numbers.toCharArray()) {

            if (numberSet.contains(c)) {
                throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBER_ERROR.getMessage());
            }
            numberSet.add(c);
        }

    }

    private void validateNumbersType(String numbers) {
        if (!PLAYER_REGEX.matcher(numbers).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_ERROR.getMessage());
        }
    }


}
