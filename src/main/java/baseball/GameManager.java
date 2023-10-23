package baseball;

import static baseball.MessagePrinter.*;

public class GameManager {
    private InputManager inputManager = InputManager.getInstance();
    private int answerNumber;
    private int digitSize = 3;

    public void launch() {
        while (true) {
            init();
            while (true) {
                System.out.print(INPUT_YOUR_NUMBER);
                String inputNumber = inputManager.readNumber();

                BallCount result = calculateNumber(inputNumber);
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

    private BallCount calculateNumber(String inputNumber) {
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

    public void init() {
        answerNumber = NumberFactory.createNumber();
        System.out.println(GAME_START_MESSAGE);
    }
}
