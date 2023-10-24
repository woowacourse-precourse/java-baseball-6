package baseball.game;

import baseball.domain.command.Command;
import baseball.domain.computer.Computer;
import baseball.domain.number.GameNumber;
import baseball.domain.result.Result;
import baseball.game.validate.IntegerValidator;
import baseball.game.validate.NegativeNumberValidator;
import baseball.rule.Rule;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BaseballGame {

    private OutputView outputView;
    private InputView inputView;
    private Rule rule;
    private Computer computer;

    public BaseballGame(InputView inputView, OutputView outputView, Rule rule, Computer computer) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.rule = rule;
        this.computer = computer;
    }

    public void start() {
        outputView.showStartMessage();
    }

    public void process() {
        boolean running = true;
        while (running) {
            outputView.showInputNumberMessage();
            Result result = rule.check(inputUserNumber(), computer);
            outputView.showResult(result);
            if (result.isGameClear()) {
                running = checkRestart();
            }
        }
        outputView.showEndMessage();
    }

    private boolean checkRestart() {
        outputView.showOptionMenu();
        Command command = inputUserCommand();
        if (command.isRestartCommand()) {
            computer.changeNumbers();
            return true;
        }
        return false;
    }

    private Command inputUserCommand() {
        return new Command(validateNumber(inputView.inputNumber()));
    }

    private GameNumber inputUserNumber() {
        return toGameNumber(inputView.inputNumber());
    }

    private GameNumber toGameNumber(String number) {
        return new GameNumber(Arrays.stream(number.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    private Integer validateNumber(String input) {
        IntegerValidator.validate(input);
        Integer number = Integer.valueOf(input);
        NegativeNumberValidator.validate(number);
        return number;
    }
}
