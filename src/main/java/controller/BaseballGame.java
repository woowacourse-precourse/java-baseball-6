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
        String computer = "";
        computer = ComputerNumbers.createNumbers(); //컴퓨터 랜덤 숫자 생성
        boolean completeNumber = false;
        while (!completeNumber) {
            String player = GameView.printInputNumber();
            playerNumbers.validatedNumber(player);
            completeNumber = compareNumber(computer, player);
        }
        if (setGame()) {
            run();
        } else {
<<<<<<< HEAD
=======
            return;
>>>>>>> a99376c (feat : 출력 문구 수정)
        }


    }

    private boolean compareNumber(String computer, String player) {
        int ball = ballCount(computer, player);
        int strike = strikeCount(computer, player);
        if (strike == 3) {
            isStrikeCount(strike);
            System.out.println();
            GameView.printCorrectNumber();
            return true;
        } else if (ball == 0 && strike == 0) {
            GameView.printNothingNumber();
            return false;
        } else {
            isBallCount(ball);
            isStrikeCount(strike);
            System.out.println();
            return false;
        }
    }

    private void isBallCount(int ball) {
        if (ball > 0) {
            System.out.print(ball);
            GameView.printBall();
        }
    }

    private void isStrikeCount(int strike) {
        if (strike > 0) {
            System.out.print(strike);
            GameView.printStrike();
        }
    }

    private int strikeCount(String computer, String player) {
        int strike = 0;
        for (int i = 0; i < computer.length(); i++) {
            if (computer.charAt(i) == player.charAt(i)) {
                strike++;
            }
        }
        return strike;
    }

    private int ballCount(String computer, String player) {
        int ball = 0;
        for (int i = 0; i < computer.length(); i++) {
            for (int j = 0; j < player.length(); j++) {
                if (i != j && computer.charAt(i) == player.charAt(j)) {
                    ball++;
                }
            }
        }
        return ball;
    }


    private boolean setGame() {
        int inputNumber = 0;
        try {
            inputNumber = GameView.printSetGame();
            if (inputNumber == 1) {
                return true;
            } else if (inputNumber == 2) {
                return false;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
