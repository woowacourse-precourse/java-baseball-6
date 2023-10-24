package baseball;

import baseball.application.BaseballApplication;
import baseball.application.config.BaseballConfig;
import baseball.application.config.IoConfig;

public class Application {
    public static void main(String[] args) {
        BaseballConfig baseballConfig = new BaseballConfig();
        IoConfig ioConfig = new IoConfig();

        BaseballApplication baseballApplication
            = new BaseballApplication(baseballConfig, ioConfig);
        baseballApplication.play();
    }
}
