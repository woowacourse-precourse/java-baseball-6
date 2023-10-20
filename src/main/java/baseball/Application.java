package baseball;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView view = new OutputView();
        GameData gameData = init();
        BaseballManageController controller = new BaseballManageController(gameData, view);

        do {
            controller.printStart();
            controller.generateComNums();
            System.out.println("computer is " + controller.getComputerNumbers());

            do {
                gameData = init();

                controller.printRequirePlayerInput();
                controller.setPlayerNumbers(controller.playerNumsInput());

                System.out.println(controller.getPlayerNumbers());
                controller.countBall(controller.getComputerNumbers(), controller.getPlayerNumbers());
                controller.countStrike(controller.getComputerNumbers(), controller.getPlayerNumbers());

                controller.printResult(controller.getBallCnt(), controller.getStrikeCnt());

            } while (controller.getStrikeCnt() != 3);

                controller.printEndgame();
                controller.printAskRestart();
                controller.restartInput();

            if (controller.getGameRepetition().equals("2")) {
                break;
            }

        } while (controller.getGameRepetition().equals("1"));

    }

    private static GameData init() {
        GameData gameData = new GameData();

        gameData.setGameRepetition("1");
        gameData.setStrikeCnt(0);
        gameData.setBallCnt(0);
        gameData.setComputerNumbers(new ArrayList<>());

        return gameData;
    }

}
