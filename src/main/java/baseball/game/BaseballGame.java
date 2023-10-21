package baseball.game;

import baseball.computer.Computer;
import baseball.domain.command.Command;
import baseball.domain.number.GameNumber;
import baseball.domain.result.Result;
import baseball.game.validate.NumberValidation;
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

    public BaseballGame(InputView inputView, OutputView outputView, Rule rule) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.rule = rule;
        this.computer = new Computer();
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
        String command = inputView.inputNumber();
        NumberValidation.validate(command);
        return new Command(Integer.valueOf(command));
    }

    private GameNumber inputUserNumber() {
        String number = inputView.inputNumber();
        return toGameNumber(number);
    }

    private GameNumber toGameNumber(String number) {
        NumberValidation.validate(number);
        return new GameNumber(Arrays.stream(number
                        .split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }
}
