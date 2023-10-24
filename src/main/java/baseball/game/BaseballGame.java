package baseball.game;


public class BaseballGame {
    private GameState currentGameState = GameState.RUNNING;

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        executeGameLoop();
    }

    private void executeGameLoop() {
        while (currentGameState != GameState.STOPPED) {
            generateGameNumbers();
            playUntilRoundWon();
            promptForGameRestart();
        }
    }

    private void generateGameNumbers() {
        // todo: generate game numbers
    }

    private void playUntilRoundWon() {
        // todo: play until round won
    }

    private void promptForGameRestart() {
        // todo: prompt for game restart
    }

    public enum GameState {
        RUNNING, STOPPED, ROUND_WON
    }
}
