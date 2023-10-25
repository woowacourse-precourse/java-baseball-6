package baseball.domain;

import baseball.dto.BaseballGameResultDto;

public class BaseballGame {
    private GameState gameState;

    public BaseballGame(GameState gameState) {
        this.gameState = gameState;
    }

    public void changeMode(GameState gameState) {
        this.gameState = gameState;
    }

    public void restart() {
        changeMode(GameState.PLAY);
    }

    public boolean isGameEnd() {
        return gameState.equals(GameState.END);
    }

    public BaseballGameResultDto judge(BaseballNumber guess, Referee referee) {
        BaseballGameResultDto baseballGameResultDto = referee.judge(guess);
        if (isHitNumber(baseballGameResultDto)) {
            changeMode(GameState.END);
        }
        return baseballGameResultDto;
    }

    private boolean isHitNumber(BaseballGameResultDto baseballGameResultDto) {
        return baseballGameResultDto.getStrike() == 3;
    }
}
