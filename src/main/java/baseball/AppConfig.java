package baseball;

import baseball.controller.BaseballGameController;
import baseball.controller.RestartService;
import baseball.controller.StrikeBallCountService;
import baseball.controller.StrikeBallCountServiceImpl;
import baseball.controller.RestartServiceImpl;

public class AppConfig {
    public static BaseballGameController baseballGameController() {
        return new BaseballGameController(strikeBallCountService(), restartService());
    }
    private static StrikeBallCountService strikeBallCountService() {
        return new StrikeBallCountServiceImpl();
    }

    private static RestartService restartService() {
        return new RestartServiceImpl();
    }
}
