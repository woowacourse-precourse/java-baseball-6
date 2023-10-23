package controller;

import model.ComputerNumbers;
import model.PlayerNumbers;
import view.GameView;

public class BaseballGame {
    private final ComputerNumbers computerNumbers;
    private final GameView gameView;
    private final PlayerNumbers playerNumbers;

    public BaseballGame() {
        computerNumbers = new ComputerNumbers();
        playerNumbers = new PlayerNumbers();
        gameView = new GameView();
    }

    public void run() {
        GameView.printGameStart();
        String computer = ComputerNumbers.createNumbers(); //컴퓨터 랜덤 숫자 생성
        while (true) {
            String player = GameView.printInputNumber();
            if (!playerNumbers.validatedNumber(player)) {
                throw new IllegalArgumentException();
            }
            gameSuccess();
        }


    }

    public boolean gameSuccess() {
        int inputNumber = 0;
        try {
            inputNumber = GameView.printSetGame();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        if (inputNumber == 1) {
            return true;
        } else if (inputNumber == 2) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
