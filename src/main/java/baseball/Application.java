package baseball;

import baseball.presentation.BaseballInputResolver;
import baseball.presentation.BaseballView;
import baseball.service.BaseballGameService;

public class Application {
    public static void main(String[] args) {
        BaseballGameService baseballGameService = new BaseballGameService(
                new BaseballView(),
                new BaseballInputResolver()
        );

        baseballGameService.game();
    }
}
