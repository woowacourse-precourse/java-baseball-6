package baseball.controller;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballNumbers;
import baseball.service.BaseballService;
import baseball.view.OutputView;

import java.util.List;
import java.util.Map;

public class BaseballController {
    private final BaseballService baseballService;

    public BaseballController(BaseballService baseballService) {
        this.baseballService = baseballService;
    }

    public void start() {
        int gameStatus = 0; // 0:게임진행중 / 1:재시작 / 2:게임종료
        BaseballNumbers computerNumbers = baseballService.makeBaseballNumbers();
        OutputView.outputGameStart();

        while(gameStatus != 2) {
            if(gameStatus == 1) {
                computerNumbers = baseballService.makeBaseballNumbers();
                gameStatus = 0;
            }
            gameStatus = processGame(computerNumbers);
        }
    }

    private int processGame(BaseballNumbers computerNumbers) {
        BaseballNumbers userNumbers = baseballService.inputBaseballNumbers();
        Map<String, Integer> matchedResultInfo = baseballService.matchBaseballNumbers(computerNumbers, userNumbers);
        return baseballService.calculateMatchResult(matchedResultInfo);
    }
}