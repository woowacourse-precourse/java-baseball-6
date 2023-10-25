package baseball.game;

import java.util.List;

public record BaseballGameStatus(boolean gameIsRunning, List<Integer> generatedNumbers) {
    public static BaseballGameStatus newGame(List<Integer> generatedNumbers) {
        return new BaseballGameStatus(true, generatedNumbers);
    }

    public static BaseballGameStatus terminate() {
        return new BaseballGameStatus(false, null);
    }
}