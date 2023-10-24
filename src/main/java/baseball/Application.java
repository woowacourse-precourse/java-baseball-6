package baseball;

import baseball.domain.computer.Computer;
import baseball.game.BaseballGame;
import baseball.generator.RandomNumberGenerator;
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
