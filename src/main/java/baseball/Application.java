package baseball;

import baseball.enumeration.GameRestartStatus;
import baseball.gamemanager.GameManager;
import baseball.result.BaseballGameResult;
import baseball.ui.ConsoleDisplayFactory;
import baseball.ui.GameRestartChoiceDisplay;
import baseball.ui.GameStartDisplay;
import baseball.ui.PrintMessage;
import baseball.ui.PrintResultMessage;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();

        gameManager.start();

        PrintMessage start = ConsoleDisplayFactory.requestInput();
        PrintResultMessage resultDrawer = ConsoleDisplayFactory.result();
        PrintResultMessage endDrawer = ConsoleDisplayFactory.end();
        PrintMessage restartDrawer = ConsoleDisplayFactory.restartDrawer();

        while (true) {
            start.print(GameStartDisplay.NUMBER_INPUT_MESSAGE);

            gameManager.requestUserInput();

            BaseballGameResult baseballGameResult = gameManager.calculateResult();
            resultDrawer.print(baseballGameResult);

            if (!gameManager.isThreeStrike()) {
                continue;
            }

            endDrawer.print(baseballGameResult);

            restartDrawer.print(GameRestartChoiceDisplay.RESTART_MESSAGE);

            if (gameManager.requestGameRestartChoice() == GameRestartStatus.END) {
                break;
            }

            gameManager.restart();
        }

    }

}
