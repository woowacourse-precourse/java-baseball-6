package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Result;
import baseball.domain.User;
import baseball.strategy.DuplicateAllowancePolicy;
import baseball.strategy.NumberGeneratePolicy;
import baseball.view.Input;
import baseball.view.Output;

import java.util.List;

import static baseball.controller.RestartCode.*;

public class BaseBallGame {

    private final Input input;
    private final Output output;

    public BaseBallGame(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void run(NumberGeneratePolicy numberGeneratePolicy, DuplicateAllowancePolicy duplicateAllowancePolicy, int numberCount) {
        output.printStartMessage();
        Computer computer = new Computer();
        List<Integer> numbers = computer.generateNumbers(numberGeneratePolicy, duplicateAllowancePolicy, numberCount);
        while (true) {
            System.out.println(numbers);
            String number = input.getNumber();
            User user = new User(number);

            Result result = computer.calculateResult(user);
            output.printGameResult(result.getStrikeCount(), result.getBallCount());

            if (result.hasClearedGame(numberCount)) {
                output.printEndMessage();
                output.printRestartMessage();
                if (input.getRestartCode().equals(EXIT.getCode())) {
                    break;
                }
                computer = new Computer();
                numbers = computer.generateNumbers(numberGeneratePolicy, duplicateAllowancePolicy, numberCount);
            }
        }

    }

}
