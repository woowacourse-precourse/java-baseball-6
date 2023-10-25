package baseball.engine;

import baseball.config.GameProperty;
import baseball.handler.io.OutputHandler;
import baseball.handler.io.UserInputHandler;
import baseball.handler.validation.Validator;
import baseball.oppenent.Computer;
import java.util.List;
import java.util.Map;

public class GameEngine {

    private Computer computer;

    public GameEngine() {
        this.computer = new Computer();
    }

    public void startGame() {
        OutputHandler.startGame();
        boolean continueous;
        do {
            this.computer.setRandomNumber();
            continueous = continueGame();
        } while (continueous);
    }

    public boolean continueGame() {
        List<Integer> userAnswer;
        boolean isCorrect;
        do {
            userAnswer = UserInputHandler.userSubmit();
            Validator.answerValidate(userAnswer);
            isCorrect = isFinish(userAnswer);
            if (isCorrect && UserInputHandler.isContinue()) {
                return true;
            }
        } while (!isCorrect);
        return false;
    }

    public boolean isFinish(List<Integer> userAnswer) {
        Map<String, Integer> hint = computer.getHint(userAnswer);
        OutputHandler.provideHint(hint);
        if (hint.get("strike") == GameProperty.getAnswerlength()) {
            OutputHandler.correctAnswer();
            return true;
        } else {
            return false;
        }
    }

}

