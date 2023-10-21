package baseball.controller;

import baseball.application.NumberService;
import baseball.view.ViewService;

public class GameController {

    private final NumberService numberService;
    private final ViewService viewService;

    public GameController(NumberService numberService, ViewService viewService) {
        this.numberService = numberService;
        this.viewService = viewService;
    }
}
