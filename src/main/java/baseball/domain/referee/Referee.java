package baseball.domain.referee;

import static baseball.domain.number.NumberConstant.MAX_INDEX;
import static baseball.domain.number.NumberConstant.MIN_INDEX;

import baseball.domain.number.Numbers;
import baseball.domain.result.Result;
import java.util.List;
import java.util.stream.IntStream;

public class Referee {

    private Referee() {
    }

    public static Referee create() {
        return new Referee();
    }

    public Result calculateResult(Numbers inputNumbers, Numbers answerNumbers) {
        return Result.create(calculateBall(inputNumbers, answerNumbers), calculateStrike(inputNumbers, answerNumbers));
    }

    private Integer calculateBall(Numbers inputNumbers, Numbers answerNumbers) {
        return (int) IntStream.rangeClosed(MIN_INDEX, MAX_INDEX)
                .filter(idx -> isBall(inputNumbers, answerNumbers, idx))
                .count();

    }

    private static boolean isBall(Numbers inputNumbers, Numbers answerNumbers, int idx) {
        List<Integer> inputNumberList = inputNumbers.getNumberList();
        List<Integer> answerNumberList = answerNumbers.getNumberList();

        Integer inputNumber = inputNumberList.get(idx);

        return answerNumberList.contains(inputNumber)
                && !inputNumber.equals(answerNumberList.get(idx));
    }

    private Integer calculateStrike(Numbers inputNumbers, Numbers answerNumbers) {
        List<Integer> inputNumberList = inputNumbers.getNumberList();
        List<Integer> answerNumberList = answerNumbers.getNumberList();

        return (int) IntStream.rangeClosed(MIN_INDEX, MAX_INDEX)
                .filter(idx -> inputNumberList.get(idx).equals(answerNumberList.get(idx)))
                .count();
    }

}
