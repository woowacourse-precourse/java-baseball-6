package baseball.controller;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballScore;
import baseball.service.BaseballService;
import baseball.view.BaseballInputView;
import baseball.view.BaseballOutputView;

public class BaseballController {
    //컨트롤러에서 서비스의 기능들을 연결시켜준다.
    //상수 private static final 처리 해보기
    //enum 적용 시켜보기

    private static final BaseballService baseballService = new BaseballService();

    public BaseballController() {
        BaseballOutputView.printStartMessage();
    }

    public void play() {
        BaseballNumber computerBaseballNumber = startBaseballGame();
        playBaseballGame(computerBaseballNumber);
        reStartOrEndBaseballGame();
    }

    private BaseballNumber startBaseballGame() {
        return baseballService.initializeComputerNumber();
    }

    private void playBaseballGame(BaseballNumber computerBaseballNumber) {
        BaseballScore resultScore = new BaseballScore(0, 0);
        while (!resultScore.isStrikeThree()) {
            BaseballNumber userBaseballNumber = baseballService.initializeUserNumber(
                    BaseballInputView.readUserNumber());
            resultScore = baseballService.compareBaseballNumber(computerBaseballNumber, userBaseballNumber);
            resultScore.printBaseballScore();
        }
        BaseballOutputView.printEndMessage();
    }

    private void reStartOrEndBaseballGame() {
        if (baseballService.isContinueGame(BaseballInputView.readRestartOrEnd())) {
            play();
        }
    }
}
