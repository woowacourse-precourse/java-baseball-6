package baseball.controller;

import baseball.controller.constant.GameCommand;
import baseball.controller.dto.Result;
import baseball.domain.Computer;
import baseball.domain.NumberBaseBallComputer;
import baseball.domain.Rule;
import baseball.domain.User;
import baseball.strategy.DuplicateAllowancePolicy;
import baseball.strategy.DigitPolicy;
import baseball.strategy.NumberGeneratePolicy;
import baseball.view.Console;
import baseball.view.Input;
import baseball.view.Output;

import static baseball.controller.constant.GameCommand.EXIT;
import static baseball.controller.constant.GameCommand.from;

public class NumberBaseBallGame {

    private final Rule rule;
    private final Console console;

    public NumberBaseBallGame(
            Input input,
            Output output,
            NumberGeneratePolicy numberGeneratePolicy,
            DuplicateAllowancePolicy duplicateAllowancePolicy,
            DigitPolicy digitPolicy
    ) {

        this.rule = new Rule(numberGeneratePolicy, duplicateAllowancePolicy, digitPolicy);
        this.console = new Console(input, output);
    }

    public void run() {
        console.printStartMessage();
        Computer computer = new NumberBaseBallComputer(rule);

        while (true) {
            String number = console.getNumber();
            User user = new User(number,rule);
            Result result = computer.calculateResult(user);
            console.printGameResult(result.strikeCount(), result.ballCount());

            if (result.clearedGame(rule.digits())) {
                console.printEndMessage();
                console.printRestartMessage();
                GameCommand command = from(console.getRestartCode());
                if (command.equals(EXIT)) {
                    break;
                }
                computer = new NumberBaseBallComputer(rule);
            }
        }
    }

}
