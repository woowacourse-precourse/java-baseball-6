package baseball;

import baseball.controller.BaseballGameController;
import baseball.controller.StrikeBallCountService;
import baseball.controller.StrikeBallCountServiceImpl;
import baseball.controller.RestartServiceImpl;

public class AppConfig {
    public static BaseballGameController baseballGameController() {
        return new BaseballGameController(strikeBallCountable(), restartOption());
    }
    private static StrikeBallCountService strikeBallCountable() {
        return new StrikeBallCountServiceImpl();
    }

    private static RestartServiceImpl restartOption() {
        return new RestartServiceImpl();
    }
}
