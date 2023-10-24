package baseball.game;

import baseball.io.Output;
import baseball.collaborator.generic.BallCount;
import baseball.collaborator.number.BaseballNumbers;
import baseball.collaborator.number.WinningNumbers;
import baseball.collaborator.number.generator.BaseballNumbersGenerator;
import baseball.collaborator.number.generator.WinningNumbersGenerator;

public class Turn {

    private boolean isPlaying = true;

    // TODO : new 구문도 메서드 추출하는 것이 의미를 이해하는 것에 도움이 될 수 있을 것 같음.
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
