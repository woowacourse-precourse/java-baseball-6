package baseball;

import static baseball.MessageConst.*;

public class GameManager {
    private final InputManager inputManager = InputManager.getInstance();
    private int answerNumber;
    private int digitSize = 3;

    public void launch() {
        while (true) {
            init();
            while (true) {
                System.out.print(INPUT_YOUR_NUMBER);
                String inputNumber = inputManager.readNumber();

                BallCount result = calculateBallCount(inputNumber);
                printResultMessage(result);

                if(isGameClear(result)) {
                    int restartOrEnd = inputManager.readWeatherRestartOrEnd();
                    if(restartOrEnd == 1) break; // 재시작
                    if(restartOrEnd == 2) return; // 종료
                }
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

        if(strike == 0 && ball == 0){
            System.out.println(NOTHING);
        } else if (strike == 3) {
            System.out.println(GAME_CLEAR_MESSAGE);
        } else {
            System.out.println(String.format(STRIKE_BALL_COUNT, ball, strike));
        }
    }

    private void init() {
        answerNumber = NumberFactory.createNumber();
        System.out.println(GAME_START_MESSAGE);
    }
}
