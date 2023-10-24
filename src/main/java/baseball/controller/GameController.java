package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.PlayerAnswer;
import baseball.view.GameView;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    Computer computer = new Computer();
    Player player = new Player();
    ComputerController computerController = new ComputerController();
    GameView gameView = new GameView();
    PlayerAnswer playerAnswer = new PlayerAnswer();

    public void playGame() {
        List<Integer> computerRandomNumberList;
        boolean proceedGameFlag = true;

        gameView.printStartGameMessage();

        while (proceedGameFlag) {
            computerRandomNumberList = computer.getComputerRandomNumber();
            proceedGameFlag = repeatFindAnswer(computerRandomNumberList);
        }
    }

    private boolean repeatFindAnswer(List<Integer> computerRandomNumberList) {
        boolean correctAnswerFlag = false;
        List<Integer> playerNumberList = new ArrayList<>();
        String playerRetry;

        while (!correctAnswerFlag) {
            gameView.printInputNumberMessage();
            playerNumberList = player.getPlayerNumberList(Console.readLine());

            validate(playerNumberList);

            correctAnswerFlag = compareAnswer(computerRandomNumberList, playerNumberList);
            gameView.printAnswerHintMessage(playerAnswer);

            if (correctAnswerFlag) {
                gameView.printSuccessGameMessage();
                playerRetry = Console.readLine();
                correctAnswerFlag = retryGame(playerRetry);
                break;
            }
        }

        return correctAnswerFlag;
    }

    private boolean compareAnswer(List<Integer> computerRandomNumberList, List<Integer> playerNumberList) {
        playerAnswer.setStrike(0);
        playerAnswer.setBall(0);

        for (int i = 0; i < 3; i++) {
            if (computerRandomNumberList.get(i) == playerNumberList.get(i)) {
                playerAnswer.setStrike(playerAnswer.getStrike() + 1);
            }
            if (computerRandomNumberList.get(i) != playerNumberList.get(i)) {
                if (computerRandomNumberList.contains(playerNumberList.get(i))) {
                    playerAnswer.setBall(playerAnswer.getBall() + 1);
                }
            }
        }
        return playerAnswer.getStrike() == 3;
    }

    private boolean retryGame(String playerOption) {
        switch (playerOption) {
            case "1" : return true;

            case "2" : return false;

            default: throw new IllegalArgumentException();
        }
    }

    private void validate(List<Integer> playerNumberList) {
        if (playerNumberList.size() != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < playerNumberList.size(); i++) {
            checkNumberRange(playerNumberList, i);
        }

        if (playerNumberList.size() != playerNumberList.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumberRange(List<Integer> playerNumberList, int index) {
        if (playerNumberList.get(index) < 1 || playerNumberList.get(index) > 9) {
            throw new IllegalArgumentException();
        }
    }
}
