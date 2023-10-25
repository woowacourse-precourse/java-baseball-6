package baseball.setting;

import baseball.controller.BaseballController;
import baseball.repository.BaseballRepository;
import baseball.service.BaseballService;

public class ReadyGame {
    public BaseballController injection(){
        return new BaseballController(
            new BaseballService(
                new BaseballRepository()
            )
        );
    }
}