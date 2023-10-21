package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.PlayerAnswer;
import baseball.view.GameView;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GameController {

    Computer computer = new Computer();
    Player player = new Player();
    ComputerController computerController = new ComputerController();
    PlayerController playerController = new PlayerController();
    GameView gameView = new GameView();
    PlayerAnswer playerAnswer = new PlayerAnswer();

    public void playGame() {
        boolean proceedGameFlag = true;

        while (proceedGameFlag) {
            gameView.printStartGameMessage();
            computer.setComputerRandomNumber(computerController.getComputerRandomNumber());
            repeatFindAnswer();

        }
    }

    private void repeatFindAnswer() {
        boolean correctAnswerFlag = false;

        while (!correctAnswerFlag) {

            gameView.printInputNumberMessage();
            List<Integer> playerNumberList = playerController.putPlayerNumberList(Console.readLine());
            correctAnswerFlag = compareAnswer(computer.getComputerRandomNumber(), playerNumberList);
            gameView.printAnswerHintMessage(playerAnswer);

            if (correctAnswerFlag) {
                gameView.printSuccessGameMessage();
            }



        }


    }

    private boolean compareAnswer(List<Integer> computerNumberList, List<Integer> playerNumberList) {
        playerAnswer.setStrike(0);
        playerAnswer.setBall(0);

        // 같은 인덱스에 같은 값이 있다면 strike 1 증가 but, 같은 인덱스에 없지만 해당 값이 리스트에 포함되어 있으면 ball 1증가
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
        // ==================================================================================================


        return playerAnswer.getStrike() == 3;
    }





}
