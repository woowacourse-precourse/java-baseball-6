package baseball.game;

import baseball.game.enums.TurnStatus;
import baseball.io.Output;
import baseball.collaborator.generic.BallCount;
import baseball.collaborator.number.BaseballNumbers;
import baseball.collaborator.number.WinningNumbers;
import baseball.collaborator.number.generator.BaseballNumbersGenerator;
import baseball.collaborator.number.generator.WinningNumbersGenerator;

public class Turn {

    private TurnStatus turnStatus = TurnStatus.PLAYING;

    public void play() {
        WinningNumbers winningNumbers = getWinningNumbers();

        while (turnStatus.isPlaying()) {
            BaseballNumbers baseballNumbers = getBaseballNumbers();
            BallCount ballCount = winningNumbers.ballCounting(baseballNumbers);

            announceResultOf(ballCount);
            updateIsPlayingBy(ballCount);
        }
    }

    private static WinningNumbers getWinningNumbers() {
        return new WinningNumbers(new WinningNumbersGenerator());
    }

    private static BaseballNumbers getBaseballNumbers() {
        return new BaseballNumbers(new BaseballNumbersGenerator());
    }

    private static void announceResultOf(BallCount ballCount) {
        Output.consoleLine(ballCount);
    }

    private void updateIsPlayingBy(BallCount ballCount) {
        if (ballCount.isFullCount()) {
            return;
        }
        turnStatus = TurnStatus.TURNOVER;
    }

}
