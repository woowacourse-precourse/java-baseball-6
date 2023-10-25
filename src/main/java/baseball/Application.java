package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        GameData gameData = new GameData();
        OutputView view = new OutputView();
        BaseballGameController controller = new BaseballGameController(gameData, view);

        boolean continuePlaying = true;
        while (continuePlaying) {
            controller.playGame();
            view.printAskRestart();
            String restartChoice = Console.readLine();
            if (restartChoice.equals("2")) {
                continuePlaying = false;
            }
        }
    }
}