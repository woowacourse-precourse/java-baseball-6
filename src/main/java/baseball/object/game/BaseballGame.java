package baseball.object.game;

import baseball.io.Output;
import baseball.object.number.BaseballNumbers;
import baseball.object.number.WinningNumbers;
import baseball.object.number.generator.BaseballNumbersGenerator;
import baseball.object.number.generator.WinningNumbersGenerator;
import baseball.object.generic.BallCount;

public class BaseballGame {

    public void play() {
        WinningNumbers winningNumbers = new WinningNumbers(new WinningNumbersGenerator());

        while (true) {
            BaseballNumbers baseballNumbers = new BaseballNumbers(new BaseballNumbersGenerator());

            BallCount ballCount = winningNumbers.ballCounting(baseballNumbers);

            Output.consoleLine(ballCount);
            if (ballCount.isFullCount()) break;
        }
        Output.consoleLine("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
