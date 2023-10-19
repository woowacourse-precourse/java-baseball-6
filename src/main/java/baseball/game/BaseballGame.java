package baseball.game;

import baseball.game.validate.NumberValidation;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGame {

    private OutputView outputView;
    private InputView inputView;

    public BaseballGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        outputView.showStartMessage();
    }

    public void process() {
        boolean running = true;

        while (running) {
            outputView.showInputNumberMessage();
            String number = inputView.inputNumber();
            List<Integer> numbers = toNumbers(number);
            running = false;
        }
    }

    public void checkRestart() {
        outputView.showOptionMenu();
    }

    private List<Integer> toNumbers(String number) {
        NumberValidation.validate(number);
        return Arrays.stream(number.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
