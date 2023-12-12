package baseball;

import baseball.domain.Computer;
import baseball.domain.RandomGenerator;
import baseball.domain.Score;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    private static InputView inputView;
    private static OutputView outputView;
    private static Computer computer;
    private static RandomGenerator generator;


    public static void main(String[] args) {
        gameInit();
        outputView.startGame();
        gameLoop();
        outputView.endGame();
    }

    private static void gameInit() {
        inputView = new InputView();
        outputView = new OutputView();
        generator = new RandomGenerator(Randoms::pickNumberInRange);
        computer = new Computer(generator.generate());
    }

    private static void gameLoop() {
        Score score;
        do {
            outputView.enterNumbers();
            score = computer.getScore(inputView.getUserNumber());
            outputView.GameResult(score);
        } while (!gameOver(score));
    }

    static private boolean gameOver(Score score) {
        if (score.isWon()) {
            outputView.wonGame();
            if (inputView.getUserRestart()) {
                computer = new Computer(generator.generate());
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
