package baseball.service;

import baseball.domain.BaseballJudge;
import baseball.domain.RandomNumberGenerator;
import baseball.domain.vo.JudgeResult;
import baseball.presentation.BaseballInputResolver;
import baseball.presentation.BaseballView;

public class BaseballGameService {
    private final RandomNumberGenerator randomNumberGenerator;
    private final BaseballView baseballView;
    private final BaseballInputResolver baseballInputResolver;

    public BaseballGameService(
            RandomNumberGenerator randomNumberGenerator,
            BaseballView baseballView,
            BaseballInputResolver baseballInputResolver
    ) {
        this.randomNumberGenerator = randomNumberGenerator;
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
            String input = baseballInputResolver.inputBaseballNumber();

            JudgeResult judgeResult = baseballJudge.judge(input);

            baseballView.printJudgeResult(judgeResult);

            if(judgeResult.isThreeStrike()) {
                break;
            }
        }
    }

    private BaseballJudge createBaseballJudge() {
        return new BaseballJudge(randomNumberGenerator.generate());
    }
}
