package baseball.game;

import static baseball.resources.GameConst.*;


import baseball.domain.ComputerNum;
import baseball.domain.UserNum;
import baseball.resources.GameMessage;
import camp.nextstep.edu.missionutils.Console;

public class GameManager {

    private final UserNum userNum;
    private final ComputerNum computerNum;
    private final BallCounter ballCounter;

    public GameManager() {
        this.userNum = new UserNum();
        this.computerNum = new ComputerNum();
        this.ballCounter = new BallCounter();
    }

    public void startGame() {
        System.out.println(GameMessage.GAME_START);
    }

    public void inputUserNumber() {
        System.out.print(GameMessage.INPUT_NUMBER);
        userNum.setNum(Console.readLine());
    }

    public boolean checkResult() {
        int strike = ballCounter.countStrike(userNum.getNum(), computerNum.getNum());
        int ball = ballCounter.countBall(userNum.getNum(), computerNum.getNum());

        printBallCount(strike, ball);

        if (strike == ALL_STRIKE) {
            System.out.println(GameMessage.CORRECT_MESSAGE);
            return GAME_OVER;
        }

        return NOT_GAME_OVER;
    }

    public boolean askRestartGame() {
        System.out.println(GameMessage.ASK_RESTART);
        Integer enterValue = Integer.parseInt(Console.readLine());

        if (enterValue == WANT_RESTART) {
            return RESTART;
        } else if (enterValue == WANT_EXIT) {
            return EXIT_GAME;
        }

        throw new IllegalArgumentException();
    }

    private void printBallCount(int strike, int ball) {
        if (strike == ZERO && ball == ZERO) {
            System.out.println(GameMessage.NOTHING);
        } else if (strike == ZERO && ball > ZERO) {
            System.out.printf(GameMessage.ONLY_BALL, ball);
        } else if (strike > ZERO && ball == ZERO) {
            System.out.printf(GameMessage.ONLY_STRIKE, strike);
        } else if (strike > ZERO && ball > ZERO) {
            System.out.printf(GameMessage.BALL_AND_STRIKE, ball, strike);
        }
    }
}
