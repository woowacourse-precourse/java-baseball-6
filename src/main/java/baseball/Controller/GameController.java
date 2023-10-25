package baseball.Controller;

import baseball.Model.PlayNumber;
import baseball.View.InputView;
import baseball.View.OutputView;
import java.util.List;

public class GameController {
    private static final String wrongAnswerRestartMSG = "1 또는 2만 입력이 가능합니다.";

    PlayNumber playNumber = new PlayNumber();
    CheckAnswer checkAnswer = new CheckAnswer();
    NumberValidation numberValidation = new NumberValidation();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void playGame() {
        boolean gameStata = true;

        while (gameStata) {
            outputView.printStartMsg();
            checkAnswer.startGame(playNumber);
            againAskAnswer();
            gameStata = askRestartGame();
        }
    }

    private boolean askRestartGame() {
        String answer = inputView.enterAskRestart();
        return wantRestartGame(answer);
    }

    private boolean wantRestartGame(String answer) {
        if (answer.equals("1")) {
            return true;
        } else if (answer.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException(wrongAnswerRestartMSG);
    }

    private void againAskAnswer() {
        boolean correctAns = false;

        while (!correctAns) {
            setAndSavePlayerNumbers();
            correctAns = checkAnswer.toDo(playNumber);
            sendEndMsgCorrect(correctAns);
        }
    }

    private void setAndSavePlayerNumbers() {
        playNumber.setInputNumber(inputView.enterAskNumber());
        List<Integer> playerNumber = numberValidation.validationNumber(playNumber.getInputNumber());
        playNumber.setPlayerNumber(playerNumber);
    }

    private void sendEndMsgCorrect(boolean correctAns) {
        if (correctAns) {
            outputView.printEndMsg();
        }
    }
}
