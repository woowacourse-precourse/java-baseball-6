package baseball.controller;

import baseball.domain.Score;
import baseball.service.BaseBallGameService;
import java.util.List;

public class BaseBallGameController {

    private final BaseBallGameService baseBallGameService;

    public BaseBallGameController(BaseBallGameService baseBallGameService) {
        this.baseBallGameService = baseBallGameService;
    }

    public List<Integer> createAnswerNumber() {
        return baseBallGameService.createRandomNumbers();
    }

    public Score competeWith(List<Integer> tryNumbers, List<Integer> answerNumbers) {
        return baseBallGameService.createGameResult(tryNumbers, answerNumbers);
    }
}
