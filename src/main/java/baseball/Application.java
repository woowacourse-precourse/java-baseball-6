package baseball;

import baseball.computer.Computer;
import baseball.computer.generator.RandomNumberGenerator;
import baseball.game.BaseballGame;
import baseball.rule.BaseballGameRule;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer(new RandomNumberGenerator());
        BaseballGame baseballGame = new BaseballGame(new InputView(), new OutputView(),
                new BaseballGameRule(), computer);
        baseballGame.start();
        baseballGame.process();
    }
}
