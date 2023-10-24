package baseball.application;

import baseball.controller.GameManager;
import baseball.controller.GameRestarter;
import baseball.domain.GameSetting;
import baseball.utils.RandomGenerator;

public class GameExecutor {

    public void playGame(GameSetting gameSetting) {
        RandomGenerator randomGenerator = new RandomGenerator();
        int[] answer = randomGenerator.getRandomNumbers(gameSetting.getSize(), gameSetting.getStartNum(), gameSetting.getEndNum());
        GameManager gameManager = new GameManager(answer, gameSetting);
        gameManager.startGame();

        GameRestarter gameRestarter = new GameRestarter(gameSetting);
        if (gameRestarter.restartOrExit()) {
            playGame(gameSetting);
        }
    }
}
