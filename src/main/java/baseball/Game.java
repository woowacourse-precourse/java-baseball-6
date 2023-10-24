package baseball;

import baseball.utils.InputReader;
import baseball.utils.NumberGenerator;
import baseball.utils.Printer;
import baseball.utils.ScoreCounter;

import java.util.List;

public class Game {

    private static Printer printer = new Printer();
    private static ScoreCounter scoreCounter = new ScoreCounter();
    private static InputReader inputReader = new InputReader();

    public void start() {
        printer.printGameStart();
        boolean isGameActive = true;
        while (isGameActive) {
            newGame();
            isGameActive = askRestartOrExit();
        }
        printer.printGameEnd();
    }

    private void newGame() {
        List<Integer> computer = NumberGenerator.generateUnique3DigitNum();
        playGame(computer);
    }

    private int playGame(List<Integer> computer) {
        int ball;
        int strike = 0;
        while (strike != 3) {
            List<Integer> user = inputReader.getUserNumber();
            ball = scoreCounter.countBall(computer, user);
            strike = scoreCounter.countStrike(computer, user);
            printer.printGameResult(ball, strike);
        }
        printer.printCorrect();
        return strike;
    }

    private boolean askRestartOrExit() {
        return inputReader.getUserGameAction() == 1;
    }

}
