package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView view = new OutputView();
        GameData gameData = new GameData();
        BaseballManageController controller = new BaseballManageController(gameData, view);

        do {
            gameData = init();

            view.printStart();
            view.printRequirePlayerInput();

            gameData.setPlayerNumbers(controller.playerNumsInput());
            controller.countBall(gameData.getComputerNumbers(), gameData.getPlayerNumbers());
            controller.countStrike(gameData.getComputerNumbers(), gameData.getPlayerNumbers());






        } while (gameData.getGameRepetition() == 1);

    }

    private static GameData init() {
        GameData gameData = new GameData();

        gameData.setGameRepetition(1);
        gameData.setStrikeCnt(0);
        gameData.setBallCnt(0);
        gameData.setComputerNumbers(new ArrayList<>());
        gameData.generateComNums(gameData.getComputerNumbers());

        return gameData;
    }

}
