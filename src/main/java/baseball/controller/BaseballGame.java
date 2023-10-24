package baseball.controller;

import baseball.model.Number;
import baseball.view.ViewGame;

import java.util.List;

public class BaseballGame {
    Number number = new Number();
    Computer computer = new Computer();
    NumberCheck numbercheck = new NumberCheck();
    ViewGame viewgame = new ViewGame();


    public void runGame() {
        boolean isgameRunning = true;

        while (isgameRunning) {
            viewgame.viewStartGame();
            computer.startGame(number);
            GuessingAnswer();
            isgameRunning = askRestartGame();
        }
    }

    private void GuessingAnswer() {
        boolean correctAnswer = false;

        while (!correctAnswer) {
            SavePlayerNumbers();
            correctAnswer = computer.proceedComputerToDo(number);
            sendEndMessage(correctAnswer);
        }
    }

    private void SavePlayerNumbers() {
        number.setPlayer_Input(ViewGame.enterGameNumber());
        List<Integer> playerNumbers = numbercheck.toValidateData(number.getPlayer_Input());
        number.setPlayer_Number(playerNumbers);
    }

    private void sendEndMessage(boolean correctAnswer) {
        if (correctAnswer) {
            ViewGame.viewEndGame();
        }
    }

    private boolean askRestartGame() {
        String answer = ViewGame.enterAnswerRestartGame();
        return RestartGame(answer);
    }

    public boolean RestartGame(String answer) {
        if (answer.equals("1")) {
            return true;
        } else if (answer.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
    }
}
