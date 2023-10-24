package baseball;

public class BaseBallGame {
    private final static int BASEBALL_GAME_SIZE = 3;
    private final BaseBallUI baseBallUI;
    private final InputReader reader;
    private final AppConfig appConfig;
    private BaseBallGameEngine baseBallGameEngine;

    public BaseBallGame(AppConfig appConfig) {
        baseBallUI = appConfig.getBaseBallUI();
        reader = appConfig.getInputReader();
        this.appConfig = appConfig;
    }

    public void run() {
        baseBallUI.startGame();
        this.playing();
        this.end();
        reader.close();
    }

    private void playing() {
        boolean isPlaying = true;
        baseBallGameEngine = appConfig.getBaseBallGameEngine(BASEBALL_GAME_SIZE);
        while (isPlaying) {
            baseBallUI.playing();
            BaseBallScore baseBallScore = baseBallGameEngine.calculatingBaseBallScore(reader.readLine());
            baseBallUI.printBaseBallScore(baseBallScore);
            isPlaying = isEnd(baseBallScore);
        }
    }

    private void end() {
        baseBallUI.endGame();
        if (baseBallGameEngine.isEnd(reader.readLine()))
            return;
        playing();
        end();
    }

    private boolean isEnd(BaseBallScore baseBallScore) {
        return baseBallScore.getStrike() != BASEBALL_GAME_SIZE;
    }

}
