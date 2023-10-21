package baseball.controller;

import baseball.domain.Score;
import baseball.service.Service;

public class Controller {

    private static final Service service = new Service();

    public Score getScore(String input) {
        return service.getScore(input);
    }

    public boolean isRestart(String input) {
        return service.isRestart(input);
    }
}
