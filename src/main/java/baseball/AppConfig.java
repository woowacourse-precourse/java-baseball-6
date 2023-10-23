package baseball;

import baseball.controller.BaseballGameController;
import baseball.controller.StrikeBallCountable;
import baseball.controller.StrikeBallCountableImpl;
import baseball.member.RestartOption;

public class AppConfig {
    public static BaseballGameController baseballGameController() {
        return new BaseballGameController(strikeBallCountable(), restartOption());
    }
    private static StrikeBallCountable strikeBallCountable() {
        return new StrikeBallCountableImpl();
    }

    private static RestartOption restartOption() {
        return new RestartOption();
    }
}
