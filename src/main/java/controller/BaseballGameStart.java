package controller;

import model.PlayerNumber;
import model.RandomComputerNumber;
import view.OutputView;

public class BaseballGameStart {
    PlayerNumber playerNumber = new PlayerNumber();
    RandomComputerNumber computerNumber = new RandomComputerNumber();

    public void start() {
        OutputView.printStartMessage();
        computerNumber.setComputerPick(); //컴퓨터가 랜덤숫자를 정함

        while (true) {
            playerNumber.setPlayerPickList(); //플레이어 숫자를 입력받음
            NumberCompare referee = new NumberCompare(playerNumber.getPlayerPickList(), computerNumber.getComputerPickList());
            referee.compare();
            if (referee.isGameEnded()) {
                OutputView.printEndMessage();
                break;
            }
        }
    }

}
