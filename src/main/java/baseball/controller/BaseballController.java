package baseball.controller;

import baseball.domain.Referee;
import baseball.service.BaseballService;

public class BaseballController {

    private final BaseballService baseballService;

    public BaseballController( BaseballService service) {
      this.baseballService = service;
    }

    public Referee startBaseBall(int[] numbers){
        baseballService.scoreReset();
        baseballService.userAnswerCheck(numbers);

        return baseballService.decision();
    }
}