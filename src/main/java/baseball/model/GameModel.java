package baseball.model;

import baseball.util.GameConfig;
import baseball.util.NumValidator;
import baseball.util.ScoreChecker;

public class GameModel {
    private Result result;
    private boolean isRunning;
    private boolean isExit;

    public GameModel(Result result, boolean isRunning, boolean isExit) {
        this.result = result;
        this.isRunning = isRunning;
        this.isExit = isExit;
    }

    public boolean isGameRunning() {
        // 게임 진행 여부 확인
        return isRunning;
    }

    public boolean isExit() {
        return isExit;
    }

    public Value processUserInput(String userInput, Value valueInstance) throws IllegalArgumentException {
        // 사용자 입력 처리
        NumValidator.isValid(userInput);
        return valueInstance.makeValue(userInput);
    }

    public Score calculateScore(Value value) {
        // 점수 계산
        return ScoreChecker.checkScore(value, result);
    }

    public boolean isGameOver(Score score) {
        // 게임 종료 여부 확인
        return score.getStrike() == GameConfig.GAME_NUM_SIZE.getValue();
    }

    public void resetGame() {
        // 게임 재시작
        this.isRunning = false;
        this.isExit = true;
    }

    public void endGame() {
        // 게임 종료
        this.isRunning = false;
        this.isExit = false;
    }

    public void updateResult(Result result) {
        this.result = result.makeResult(GameConfig.GAME_NUM_SIZE.getValue());
        this.isRunning = true;
    }
}
