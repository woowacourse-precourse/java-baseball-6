package baseball.controller;

import baseball.model.BaseballStadium;
import baseball.view.BaseballView;

public class BaseballController {

    private final BaseballStadium baseballStadium;
    private final BaseballView baseballView;

    public BaseballController(BaseballStadium baseballStadium, BaseballView baseballView) {
        this.baseballStadium = baseballStadium;
        this.baseballView = baseballView;
    }


}
