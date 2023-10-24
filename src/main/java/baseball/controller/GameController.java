package baseball.controller;

import baseball.domain.Answer;
import baseball.utils.Setting;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private InputView inputView;
    private OutputView outputView;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {

        // Print Start Game
        outputView.printStartGame();

        // Setting Answer
        Answer answer = new Answer();
        answer.setAnswerNumber();

        Boolean correct;

        do {  // Start Game
            outputView.printInputNumber();
            String clientInputNumber = inputView.readClientInputNumber();

            // InputNumber IllegalArgumentException
            if (clientInputNumber.length() != Setting.NUM_LENGTH)
                outputView.printClientInputNumberException();

            correct = answer.isCorrect(clientInputNumber);

        } while(!correct);

        // Ask Restart Game
        askRestartGame();
    }

    public void askRestartGame() {

        // Print Restart Game
        outputView.printRestartGame();
        String restartNumber = inputView.readRestartNumber();

        if (restartNumber.equals("1"))
            startGame();
        else if (!restartNumber.equals("1") && !restartNumber.equals("2"))
            outputView.printRestartNumberException();  // RestartNumber IllegalArgumentException
    }
}
