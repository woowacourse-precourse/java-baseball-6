package baseball;

import baseball.domain.BaseballJudge;
import baseball.domain.RandomNumberGenerator;
import baseball.presentation.BaseballInputResolver;
import baseball.presentation.BaseballView;
import baseball.service.BaseballGameService;

public class Application {
    public static void main(String[] args) {
        BaseballGameService baseballGameService = new BaseballGameService(
                new RandomNumberGenerator(),
                new BaseballView(),
                new BaseballInputResolver()
        );

        baseballGameService.game();
    }
}
