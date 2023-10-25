package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.UserNumber;
import baseball.view.BaseballGameView;

public class BaseballGameController {
    private final BaseballGameView view;

    public BaseballGameController() {
        view = new BaseballGameView();
    }

    public void startGame() {
        ComputerNumber computerNumber = new ComputerNumber();
        boolean gameContinue = true;

        view.printStartMessage();

        while (gameContinue) {
            String userInput = view.getUserNumberInput();
            UserNumber userNumber = new UserNumber(userInput);
            String result = computerNumber.getResultComparedWithUserNumber(userNumber);
            view.printResult(result);

            if (result.contains("3스트라이크")) {
                view.printEndGameMessage();
                gameContinue = view.askForNewGame();
                if (gameContinue) {
                    computerNumber = new ComputerNumber();
                }
            }
        }
    }
}
