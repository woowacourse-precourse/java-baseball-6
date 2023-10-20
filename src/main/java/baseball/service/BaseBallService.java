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
    private Player computer;
    private Player human;

    private BaseBallService() {
    }

    public static BaseBallService create() {
        BaseBallService baseBallService = new BaseBallService();
        baseBallService.setComputer(Computer.create());
        baseBallService.setHuman(Player.create());

        return baseBallService;
    }


    public void resetComputer() {
        computer.reset();
    }

    public void humanNumberChange(Numbers numbers) {
        human.changeNumbers(numbers);
    }

    private void setComputer(Computer computer) {
        this.computer = computer;
    }

    private void setHuman(Player player) {
        this.human = player;
    }


    public Result calculateResult() {
        List<Integer> inputNumberList = human.getNumberList();
        List<Integer> answerNumberList = computer.getNumberList();

        return Result.create(calculateBall(inputNumberList, answerNumberList), calculateStrike(inputNumberList, answerNumberList));
    }

    private Integer calculateBall(List<Integer> inputNumberList, List<Integer> answerNumberList) {

        return (int) IntStream.rangeClosed(MIN_INDEX, MAX_INDEX)
                .filter(idx -> isBall(inputNumberList, answerNumberList, idx))
                .count();

    }

    private static boolean isBall(List<Integer> inputNumberList, List<Integer> answerNumberList,
            int idx) {

        Integer inputNumber = inputNumberList.get(idx);

        return answerNumberList.contains(inputNumber)
                && !inputNumber.equals(answerNumberList.get(idx));
    }

    private Integer calculateStrike(List<Integer> inputNumberList, List<Integer> answerNumberList) {

        return (int) IntStream.rangeClosed(MIN_INDEX, MAX_INDEX)
                .filter(idx -> inputNumberList.get(idx).equals(answerNumberList.get(idx)))
                .count();
    }

}
