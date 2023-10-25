package baseball.controller;

import baseball.domain.ComputerNumbers;
import baseball.domain.PlayerNumbers;
import baseball.dto.BallCountDto;
import baseball.dto.GameResultDto;
import baseball.dto.NumbersStringDto;
import baseball.exception.RetryInputException;
import baseball.service.BallCountService;
import baseball.service.GameResultService;

public class Computer {

    private final ComputerNumbers computerNumbers;
    private PlayerNumbers playerNumbers;
    public Computer() {
        computerNumbers = new ComputerNumbers();
    }

    public void getPlayerNumbers(NumbersStringDto numbersStringDto) {
        playerNumbers = new PlayerNumbers(numbersStringDto.show());

    }

    public GameResultDto calculateGameResult() {
        BallCountDto ballCountDto = calculateBallCount();
        GameResultService gameResultService = new GameResultService();
        return gameResultService.calculateGameResult(ballCountDto);

    }

    private BallCountDto calculateBallCount() {
        BallCountService ballCountService = new BallCountService();
        return ballCountService.calculateBallCount(playerNumbers, computerNumbers);
    }


}
