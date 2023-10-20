package baseball.service;

import static baseball.domain.number.NumberConstant.MAX_INDEX;
import static baseball.domain.number.NumberConstant.MIN_INDEX;

import baseball.domain.player.Computer;
import baseball.domain.player.Player;
import baseball.domain.result.Result;
import baseball.domain.number.Numbers;
import java.util.List;
import java.util.stream.IntStream;

public class BaseBallService {
    private Computer computer;
    private Player player;

    private BaseBallService() {
    }

    public static BaseBallService create() {
        return new BaseBallService();
    }


    public void resetComputer() {
        computer = Computer.create();
    }

    public void playerNumberChange(Numbers numbers) {
        player = Player.create(numbers);
    }


    public Result calculateResult() {
        Numbers inputNumbers = player.getNumbers();
        Numbers answerNumbers = computer.getNumbers();

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
