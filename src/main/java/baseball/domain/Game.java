package baseball.domain;

import baseball.dto.GameResultDto;

public class Game {

    private GameState gameState;

    public Game(GameState gameState) {
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

    public GameResultDto judge(BaseballNumber guess, Referee referee) {
        GameResultDto gameResultDto = referee.judge(guess);
        if (isHitNumber(gameResultDto))
            changeMode(GameState.END);

        return gameResultDto;
    }

    private boolean isHitNumber(GameResultDto gameResultDto) {
        return gameResultDto.getStrike() == 3;
    }
}
