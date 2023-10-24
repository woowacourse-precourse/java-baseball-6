package baseball;

import baseball.utils.InputReader;
import baseball.utils.NumberGenerator;
import baseball.utils.Printer;
import baseball.utils.ScoreCounter;

import java.util.List;

public class Game {

    private final Printer printer = new Printer();
    private final ScoreCounter scoreCounter = new ScoreCounter();
    private final InputReader inputReader = new InputReader();

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

    private void playGame(List<Integer> computer) {
        int ball;
        int strike = 0;
        while (strike != 3) {
            List<Integer> user = inputReader.getUserNumber();
            ball = scoreCounter.countBall(computer, user);
            strike = scoreCounter.countStrike(computer, user);
            printer.printGameResult(ball, strike);
        }
        printer.printCorrect();
    }

    private boolean askRestartOrExit() {
        return inputReader.getUserGameAction() == 1;
    }

}
