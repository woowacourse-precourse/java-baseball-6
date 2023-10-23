package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.ComputerBalls;
import baseball.domain.PlayResult;
import baseball.domain.User;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallController {
    private final InputView inputView;
    private final OutputView outputView;

    public BaseBallController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        outputView.printMainMessage();
        ComputerBalls computer = new ComputerBalls();
        User user = new User(new Balls(inputView.readUserNumber()));
        PlayResult result = computer.play(user);
        outputView.printResult(result);
    }
}
