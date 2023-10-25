package baseball.config;

import baseball.controller.BaseballGameController;
import baseball.service.BaseballGameService;

public class BaseballGameConfig {
    public static BaseballGameService baseballGameService = new BaseballGameService();
    public static BaseballGameController baseballGameController = new BaseballGameController(baseballGameService);
}
