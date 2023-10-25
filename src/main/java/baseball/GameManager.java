package baseball;

import static baseball.CommandConst.*;
import static baseball.MessageConst.*;

public class GameManager {
    private final InputManager inputManager = InputManager.getInstance();
    private int answerNumber;
    private int digitSize = 3;
    private boolean quitFlag = false;

    public void launch() {
        init();
        while (!quitFlag) {
            System.out.print(INPUT_GUESS_NUMBER);
            String inputNumber = inputManager.readNumber();

            BallCount result = calculateBallCount(inputNumber);
            printResultMessage(result);

            if(isGameClear(result)) {
                executeGameClearProcess();
            }
        }
    }

    private boolean isGameClear(BallCount result) {
        return result.strike() == digitSize;
    }

    private BallCount calculateBallCount(String inputNumber) {
        int strike = 0, ball = 0;

        String answer = String.valueOf(answerNumber);

        for (int i = 0; i < digitSize; i++) {
            if(answer.contains(String.valueOf(inputNumber.charAt(i)))) {
                if(answer.charAt(i) == inputNumber.charAt(i)) strike++;
                else ball++;
            }
        }

        return new BallCount(strike, ball);
    }

    private void printResultMessage(BallCount ballCount) {
        int strike = ballCount.strike();
        int ball = ballCount.ball();

        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING);
        } else if (strike > 0 && ball == 0) {
            System.out.printf(ONLY_STRIKE_COUNT + "%n", strike);
        } else if (ball > 0 && strike == 0) {
            System.out.printf(ONLY_BALL_COUNT + "%n", ball);
        } else if (strike > 0 && ball > 0) {
            System.out.printf(STRIKE_BALL_COUNT + "%n", ball, strike);
        }
    }

    private void executeGameClearProcess() {
        System.out.println(GAME_CLEAR_MESSAGE);

        String command = inputManager.readWeatherRestartOrEnd();

        if(command.equals(GAME_RESTART_COMMAND)) init(); // 재시작
        if(command.equals(GAME_END_COMMAND)) quitFlag = true; // 종료
    }

    private void init() {
        answerNumber = NumberFactory.createNumber(digitSize);
        System.out.println(GAME_START_MESSAGE);
        System.out.println(answerNumber);
    }
}
