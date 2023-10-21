package baseball.model;

import baseball.service.BaseballService;
import baseball.service.NumberService;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Status status;
    private Number computerNumber;
    private final BaseballService baseballService;
    private final NumberService numberService;
    private static final int STRIKE_INDEX = 1;
    public static final int SIZE = 3;

    public Game(Status status, BaseballService baseballService, NumberService numberService) {
        this.status = status;
        this.baseballService = baseballService;
        this.numberService = numberService;
        this.computerNumber = numberService.generate();
    }

    public List<Integer> playRound(String userInput){
        Number userNumber = numberService.toNumber(userInput);
        List<Integer> result = new ArrayList<>();
        int ballCount = baseballService.getBallCount(computerNumber , userNumber);
        int strikeCount = baseballService.getStrikeCount(computerNumber , userNumber);
        result.add(ballCount);
        result.add(strikeCount);
        return result;
    }

    public void reset() {
        computerNumber = numberService.generate();
        status.resetStatus();
    }

    public boolean isOngoing() {
        return status.isOngoing();
    }


    public boolean isWin(List<Integer> result) {
        return result.get(STRIKE_INDEX).equals(Game.SIZE);
    }
}
