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
            // 2-1) 야구숫자 생성
            BaseballNumbers baseballNumbers = new BaseballNumbers(new BaseballNumbersGenerator());
            // 2-2) 정답숫자-야구숫자 매칭 -> 볼카운트 생성
            BallCount ballCount = winningNumbers.ballCounting(baseballNumbers);
            // 2-3) 볼카운트 출력
            Output.consoleLine(ballCount);
            // 2-4) 게임이 끝났는지 확인, 게임 진행 상태 업데이트
            isPlaying = ballCount.isFullCount();
        }
    }

}
