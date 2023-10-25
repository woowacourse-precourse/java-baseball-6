package baseball.controller;


import baseball.model.Game;
import baseball.model.Validator;
import baseball.view.Messages;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;


public class GameController {
    private final Validator validator;
    private final Game game;

    public GameController() {
        this.validator = new Validator();
        this.game = new Game();
    }

    public void gameModule() {
        Messages.printInitiateGameMessage();
        List<Integer> computer = game.generateComputersNumber(); // 게임이 시작할 때마다 컴퓨터의 숫자를 생성
        boolean isThreeStrike = false;

        while (!isThreeStrike) {
            Messages.printInputMessage();
            String userInput = Console.readLine();
            validator.validateUserInput(userInput);

            List<Integer> userGuess = validator.splitNumbersByDigits(Integer.parseInt(userInput));
            List<Integer> result = game.evaluateUserInput(userGuess, computer);

            isThreeStrike = game.returnResult(result);

        }
    }


    public void run() {
        boolean isContinue = true;
        do {
            gameModule();
            isContinue = game.retryHandler();
        } while (isContinue);

        Messages.printEndGameMessage();
    }


}