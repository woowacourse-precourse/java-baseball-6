package baseball.model;

import baseball.validator.Validator;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private List<Integer> numbers;

    public Numbers() {
        numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public Numbers(String userNumber) {
        Validator.validateUserNumber(userNumber);
        this.numbers = changeStringToList(userNumber);
    }

    private List<Integer> changeStringToList(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public GameResult compareNumbers(Numbers input) {
        int strike = countStrike(input);
        int ball = countBall(input);

        return new GameResult(strike, ball);
    }

    private int countStrike(Numbers input) {
        int strike = 0;

        for (int num : numbers) {
            if (input.indexOf(num) == numbers.indexOf(num)) {
                strike++;
            }
        }

        return strike;
    }

    private int countBall(Numbers input) {
        int ball = 0;

        for (int num : numbers) {
            if (input.indexOf(num) != numbers.indexOf(num) && input.contains(num)) {
                ball++;
            }
        }

        return ball;
    }

    private int indexOf(int num) {
        return numbers.indexOf(num);
    }

    private boolean contains(int num) {
        return numbers.contains(num);
    }
}
