package baseball;

import baseball.io.Output;

public class BaseballGame {

    public void play() {
        WinningNumbers winningNumbers = new WinningNumbers();

        while (true) {
            BaseballNumbers baseballNumbers = new BaseballNumbers();

            BallCount ballCount = winningNumbers.ballCounting(baseballNumbers);

            Output.consoleLine(ballCount);
            if (ballCount.isFullCount()) break;
        }
        Output.consoleLine("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
