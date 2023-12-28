package baseball;

import baseball.service.BaseballService;

public class ApplicationConfig {

    public static BaseballService baseballService() {
        return new BaseballService();
    }
}
