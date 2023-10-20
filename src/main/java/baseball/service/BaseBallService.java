package baseball.service;

import baseball.domain.Computer;
import baseball.domain.Human;
import baseball.domain.Player;
import baseball.domain.Result;
import baseball.domain.number.Numbers;
import java.util.List;

public class BaseBallService {
    private Player computer;
    private Player human;

    private BaseBallService() {
    }

    public static BaseBallService create() {
        BaseBallService baseBallService = new BaseBallService();
        baseBallService.setComputer(Computer.create());
        baseBallService.setHuman(Human.create());

        return baseBallService;
    }


    public void resetComputer() {
        computer.reset();
    }

    public void playerNumberChange(Numbers numbers) {
        human.changeNumbers(numbers);
    }

    private void setComputer(Computer computer) {
        this.computer = computer;
    }

    private void setHuman(Human human) {
        this.human = human;
    }


    public Result calculateResult() {
        return getResult(human.getNumbers(), computer.getNumbers());
    }

    private static Result getResult(Numbers inputNumbers, Numbers answerNumbers) {
        List<Integer> inputNumberList = inputNumbers.getNumberList();
        List<Integer> answerNumberList = answerNumbers.getNumberList();

        int numberCount = answerNumberList.size();

        int ball = 0;
        int strike = 0;

        for (int i = 0; i < numberCount; i++) {
            Integer inputNumber = inputNumberList.get(i);
            Integer answerNumber = answerNumberList.get(i);

            if (inputNumber == answerNumber) {
                strike += 1;
                continue;
            }

            if (answerNumberList.contains(inputNumber)) {
                ball += 1;
            }
        }

        return Result.create(ball, strike);
    }
}
