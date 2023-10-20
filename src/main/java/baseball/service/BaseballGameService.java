package baseball.service;

import baseball.domain.BaseballJudge;
import baseball.domain.RandomNumberGenerator;
import baseball.domain.vo.JudgeResult;
import baseball.presentation.BaseballInputResolver;
import baseball.presentation.BaseballView;

public class BaseballGameService {
    private final BaseballView baseballView;
    private final BaseballInputResolver baseballInputResolver;

    public BaseballGameService(
            BaseballView baseballView,
            BaseballInputResolver baseballInputResolver
    ) {
        this.baseballView = baseballView;
        this.baseballInputResolver = baseballInputResolver;
    }

    public void game() {
        baseballView.printGameStartMessage();

        boolean isRestart;
        do {
            startGame();

            baseballView.printGameEndMessage();
            isRestart = baseballInputResolver.inputIsRestart();
        } while(isRestart);
    }

    private void startGame() {
        BaseballJudge baseballJudge = createBaseballJudge();

        while(true) {
            JudgeResult result = playTurn(baseballJudge);

            baseballView.printJudgeResult(result);

            if(result.isThreeStrike()) {
                break;
            }
        }
    }

    private BaseballJudge createBaseballJudge() {
        return new BaseballJudge(RandomNumberGenerator.generate());
    }

    private JudgeResult playTurn(BaseballJudge baseballJudge) {
        String input = baseballInputResolver.inputBaseballNumber();

        return baseballJudge.judge(input);
    }
}
