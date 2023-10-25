package baseball.model;

import baseball.validator.Validator;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private static final int NUMBERS_SIZE = 3;
    private static final String SPLIT_WORD_INTO_CHARS = "";

    private List<Integer> numbers;

    public Numbers() {
        numbers = new ArrayList<>();

        while (numbers.size() < NUMBERS_SIZE) {
            addRandomNumber();
        }
    }

    private void addRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);

        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber);
        }
    }

    public Numbers(String userNumber) {
        Validator.validateUserNumber(userNumber);
        this.numbers = changeStringToList(userNumber);
    }

    private List<Integer> changeStringToList(String input) {
        return Arrays.stream(input.split(SPLIT_WORD_INTO_CHARS))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public GameResult compareNumbers(Numbers input) {
        int strike = 0;
        int ball = 0;

        for (int num : numbers) {
            strike += isStrike(input, num);
            ball += isBall(input, num);
        }

        return new GameResult(strike, ball);
    }

    private int isStrike(Numbers input, int num) {
        if (input.indexOf(num) == numbers.indexOf(num)) {
            return 1;
        }

        return 0;
    }

    private int isBall(Numbers input, int num) {
        if (input.indexOf(num) != numbers.indexOf(num) && input.contains(num)) {
            return 1;
        }

        return 0;
    }

    private int indexOf(int num) {
        return numbers.indexOf(num);
    }

    private boolean contains(int num) {
        return numbers.contains(num);
    }
}
