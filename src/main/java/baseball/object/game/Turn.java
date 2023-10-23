package baseball.object.game;

import baseball.io.Output;
import baseball.object.generic.BallCount;
import baseball.object.number.BaseballNumbers;
import baseball.object.number.WinningNumbers;
import baseball.object.number.generator.BaseballNumbersGenerator;
import baseball.object.number.generator.WinningNumbersGenerator;

public class Turn {

    private boolean isPlaying = true;

    public void play() {
        WinningNumbers winningNumbers = new WinningNumbers(new WinningNumbersGenerator());

        while (isPlaying) {
            BaseballNumbers baseballNumbers = new BaseballNumbers(new BaseballNumbersGenerator());

            BallCount ballCount = winningNumbers.ballCounting(baseballNumbers);

            Output.consoleLine(ballCount);
            updateIsPlayingBy(ballCount);
        }
    }

    private void updateIsPlayingBy(BallCount ballCount) {
        isPlaying = !ballCount.isFullCount();
    }

}
