package baseball.domain;


import baseball.domain.numberBalls.NumberBalls;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Hitter {

    private static final String WRONG_INTEGER_ERROR_MESSAGE = "[ERROR] 숫자만 입력가능합니다.";
    private NumberBalls numberBalls;

    private Hitter() {
    }

    public static Hitter create(String numberBallString) {
        Hitter hitter = new Hitter();
        hitter.setNumbers(convertStringToNumberBalls(numberBallString));

        return hitter;
    }

    private static NumberBalls convertStringToNumberBalls(String numberString) {
        validateIsInteger(numberString);

        return NumberBalls.create(Arrays.stream(numberString.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList()));
    }

    private static void validateIsInteger(String input) {
        try {
            Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_INTEGER_ERROR_MESSAGE);
        }
    }

    private void setNumbers(NumberBalls numberBalls) {
        this.numberBalls = numberBalls;
    }


    public Result hit(NumberBalls opponentNumberBalls) {
        return numberBalls.calculateResult(opponentNumberBalls);
    }

}
