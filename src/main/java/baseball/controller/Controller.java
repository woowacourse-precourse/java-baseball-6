package baseball.controller;

import baseball.domain.Result;
import baseball.service.Service;

public class Controller {

    private static final Service service = new Service();

    public Result calculateGameResult(String input) {
        return service.calculateGameResult(input);
    }

    public boolean isRestart(String input) {
        return service.isRestart(input);
    }
}
