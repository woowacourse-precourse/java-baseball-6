package baseball.domain.numbers;

import static baseball.domain.numbers.NumbersConstant.MAX_INDEX;
import static baseball.domain.numbers.NumbersConstant.MIN_INDEX;

import baseball.domain.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Numbers {

    private List<Integer> numberList;

    private Numbers() {
    }

    public static Numbers create(List<Integer> numberList) {
        validateNumberList(numberList);

        Numbers numbers = new Numbers();
        numbers.setNumberList(numberList);

        return numbers;
    }

    private static void validateNumberList(List<Integer> numberList) {
        NumbersValidator numbersValidator = NumbersValidator.create();

        numbersValidator.validateNumberSize(numberList);
        numbersValidator.validateNumberRange(numberList);
        numbersValidator.validateDuplicateNumber(numberList);
    }


    public List<Integer> getNumberList() {
        return new ArrayList<>(numberList);
    }

    private void setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public Result calculateResult(Numbers opponentNumbers) {
        List<Integer> opponentNumberList = opponentNumbers.getNumberList();

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
