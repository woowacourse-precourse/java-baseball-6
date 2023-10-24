package baseball;

import baseball.utils.InputReader;
import baseball.utils.NumberGenerator;
import baseball.utils.Printer;
import baseball.utils.ScoreCounter;

import java.util.List;

public class Game {

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isGameActive = true;
        while (isGameActive) {
            newGame();
            isGameActive = askRestartOrExit();
        }
        System.out.println("게임이 종료됩니다.");
    }

    private void newGame() {
        List<Integer> computer = NumberGenerator.generateUnique3DigitNum();
        playGame(computer);
    }

    private int playGame(List<Integer> computer) {
        int ball;
        int strike = 0;
        while (strike != 3) {
            List<Integer> user = InputReader.getUserNumber();
            ball = ScoreCounter.countBall(computer, user);
            strike = ScoreCounter.countStrike(computer, user);
            Printer.printGameResult(ball, strike);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        return strike;
    }

    private boolean askRestartOrExit() {
        return InputReader.getUserGameAction() == 1;
    }

}
