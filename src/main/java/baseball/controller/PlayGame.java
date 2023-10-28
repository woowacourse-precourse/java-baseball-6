package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.ReplayNumber;
import baseball.model.UserNumber;
import baseball.service.Hint;
import baseball.view.Input;
import baseball.view.Output;
import java.util.List;

public class PlayGame {
    ComputerNumber computerNumber = new ComputerNumber();
    ReplayNumber checkReplayGame = new ReplayNumber();
    Hint hint = new Hint();
    Output output = new Output();
    Input input = new Input();
    int ballCount;
    int strikeCount;
    int newGame;

    public void startGame() {
        output.printStart();
        do {
            List<Integer> computer = computerNumber.makeComputerNum();
            boolean checkEndGame = false;
            do {
                List<Integer> user = UserNumber.makeUserNum();
                hint.checkBall(computer, user);
                hint.checkStrike(computer, user);
                ballCount = hint.ballCount;
                strikeCount = hint.strikeCount;

                ballCount -= strikeCount;
                if (isStrike(ballCount, strikeCount) == 1) {
                    output.printCount(strikeCount);
                    output.printStrike();
                }
                if (isStrike(ballCount, strikeCount) == 2) {
                    output.printCount(ballCount);
                    output.printBall();
                }
                if (isStrike(ballCount, strikeCount) == 3) {
                    output.printCount(ballCount);
                    output.printBallAndStrike();
                    output.printCount(strikeCount);
                    output.printStrike();
                }
                if (isStrike(ballCount, strikeCount) == 4) {
                    output.printNothing();
                }
                checkEndGame = hint.checkEndGame();
                hint.resetCount();
            } while (!checkEndGame);
            output.printEndGame();
            newGame = Integer.parseInt(input.inputNewGame());
            if (newGame != 1 && newGame != 2) {
                throw new IllegalArgumentException();
            }
        } while (checkReplayGame.checkReplay(newGame));
    }

    public static int isStrike(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount != 0) {
            return 1;
        }
        if (ballCount != 0 && strikeCount == 0) {
            return 2;
        }
        if (ballCount != 0 && strikeCount != 0) {
            return 3;
        }
        if (ballCount == 0 && strikeCount == 0) {
            return 4;
        }
        return 0;
    }
}
