package baseball.controller;

import baseball.model.Computer;
import baseball.model.InGame;
import baseball.model.Player;
import baseball.model.ReGameOrExit;
import baseball.view.Message;
import camp.nextstep.edu.missionutils.Console;

public class Controller {
    Computer computer;
    Player player;

    public void run() {
        startGame();
        int reGameOrExit = 1;
        while (reGameOrExit == 1) {
            getRandomNum();
            playGame();
            reGameOrExit = endGame();
        }
    }

    private void startGame() {
        Message.gameStartMessage();
    }

    private void getRandomNum() {
        computer = new Computer();
    }

    private void playGame() {
        boolean isThreeStrike = false;
        while (!isThreeStrike) {
            Message.inputNumberMessage();
            player = new Player(Console.readLine());
            isThreeStrike = InGame.comparePlayerNumWithComputerNum(computer.getRandomIntegerList(), player.getPlayerIntegerList());
        }
    }

    private int endGame() {
        Message.endGameMessage();
        ReGameOrExit reGameOrExit = new ReGameOrExit(Console.readLine());
        return reGameOrExit.getReGameOrExitNum();
    }
}
