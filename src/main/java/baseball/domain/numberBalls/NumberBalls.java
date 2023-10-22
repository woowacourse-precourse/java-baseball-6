package baseball.domain.numberBalls;

import static baseball.domain.numberBalls.NumberBallsConstant.MAX_INDEX;
import static baseball.domain.numberBalls.NumberBallsConstant.MIN_INDEX;

import baseball.domain.Result;
import java.util.List;
import java.util.stream.IntStream;

public class NumberBalls {

    private List<Integer> numberList;

    private NumberBalls() {
    }

    public static NumberBalls create(List<Integer> numberList) {
        validateNumberList(numberList);

        NumberBalls numberBalls = new NumberBalls();
        numberBalls.setNumberList(numberList);

        return numberBalls;
    }

    private static void validateNumberList(List<Integer> numberList) {
        NumberBallsValidator numberBallsValidator = NumberBallsValidator.create();

        numberBallsValidator.validateNumberSize(numberList);
        numberBallsValidator.validateNumberRange(numberList);
        numberBallsValidator.validateDuplicateNumber(numberList);
    }

    private void setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public Result calculateResult(NumberBalls opponentNumberBalls) {
        return opponentNumberBalls.calculateResultByList(numberList);
    }

    private Result calculateResultByList(List<Integer> opponentNumberList) {
        return Result.create(calculateBall(opponentNumberList), calculateStrike(opponentNumberList));
    }

    private Integer calculateBall(List<Integer> opponentNumberList) {
        return (int) IntStream.rangeClosed(MIN_INDEX, MAX_INDEX)
                .filter(idx -> isBall(opponentNumberList, idx))
                .count();

    }

    private boolean isBall(List<Integer> opponentNumberList, int idx) {
        Integer inputNumber = numberList.get(idx);

        return opponentNumberList.contains(inputNumber) &&
                !inputNumber.equals(opponentNumberList.get(idx));
    }

    private Integer calculateStrike(List<Integer> opponentNumberList) {

        return (int) IntStream.rangeClosed(MIN_INDEX, MAX_INDEX)
                .filter(idx -> numberList.get(idx).equals(opponentNumberList.get(idx)))
                .count();
    }
}
