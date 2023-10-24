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

        boolean proceedGameFlag = true;

        gameView.printStartGameMessage();

        while (proceedGameFlag) {
            computer.setComputerRandomNumber(computerController.getComputerRandomNumber());
            proceedGameFlag = repeatFindAnswer();

        }
    }

    private boolean repeatFindAnswer() {

        boolean correctAnswerFlag = false;
        List<Integer> playerNumberList = new ArrayList<>();

        while (!correctAnswerFlag) {

            gameView.printInputNumberMessage();
            playerNumberList = player.getPlayerNumberList(Console.readLine());

            validate(playerNumberList);

            correctAnswerFlag = compareAnswer(computer.getComputerRandomNumber(), playerNumberList);
            gameView.printAnswerHintMessage(playerAnswer);

            if (correctAnswerFlag) {
                gameView.printSuccessGameMessage();
                String playerRetry = Console.readLine();
                correctAnswerFlag = retryGame(playerRetry);
                break;
            }

        }

        return correctAnswerFlag;
    }

    private boolean compareAnswer(List<Integer> computerNumberList, List<Integer> playerNumberList) {
        playerAnswer.setStrike(0);
        playerAnswer.setBall(0);

        for (int i = 0; i < 3; i++) {

            if (computerNumberList.get(i) == playerNumberList.get(i)) {
                playerAnswer.setStrike(playerAnswer.getStrike() + 1);
            }
            if (computerNumberList.get(i) != playerNumberList.get(i)) {
                if (computerNumberList.contains(playerNumberList.get(i))) {
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
            System.out.println("playerNumberList 크기 : "+playerNumberList.size());
            System.out.println("playerNumberList[] : " + playerNumberList.toString());
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < playerNumberList.size(); i++) {
            if (playerNumberList.get(i) < 1 || playerNumberList.get(i) > 9) {
                System.out.println("범위 벗어남");
                throw new IllegalArgumentException();
            }
        }

        if (playerNumberList.size() != playerNumberList.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }


    }

}
