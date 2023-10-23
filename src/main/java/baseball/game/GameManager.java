package baseball.game;

import static baseball.resources.GameConst.*;


import baseball.domain.ComputerNum;
import baseball.domain.UserNum;
import baseball.printer.Printer;
import baseball.resources.GameMessage;
import camp.nextstep.edu.missionutils.Console;

public class GameManager {

    private final UserNum userNum;
    private final ComputerNum computerNum;
    private final BallCounter ballCounter;
    private final Printer printer;

    private Integer strike;
    private Integer ball;

    public GameManager() {
        this.userNum = new UserNum();
        this.computerNum = new ComputerNum();
        this.ballCounter = new BallCounter();
        this.printer = new Printer();
    }

    public void startGame() {
        printer.printStartMessage();
    }

    public void inputUserNumber() {
        printer.printInputMessage();
        userNum.setNum(Console.readLine());
    }

    public void showBallCount() {
        int correctNumberSize = ballCounter.countCorrect(userNum.getNum(), computerNum.getNum());
        strike = ballCounter.countStrike(userNum.getNum(), computerNum.getNum());
        ball = correctNumberSize - strike;

        printer.printBallCount(strike, ball);
    }

    public boolean checkGameOver() {
        if (strike == ALL_STRIKE) {
            printer.printCorrectMessage();
            return true;
        }
        return false;
    }

    public boolean askRestartGame() {
        printer.printAskRestart();
        Integer enterValue = Integer.parseInt(Console.readLine());

        if (enterValue == WANT_RESTART) {
            return true;
        } else if (enterValue == WANT_END) {
            return false;
        }

        throw new IllegalArgumentException();
    }
}
