package baseball;

import baseball.service.BaseballService;

public class ApplicationConfig {

    public BaseballService baseballService() {
        return new BaseballService();
    }
}
