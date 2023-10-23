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
        boolean completeNumber = false;
        while (!completeNumber) {
            String player = GameView.printInputNumber();
            if (!playerNumbers.validatedNumber(player)) {
                throw new IllegalArgumentException();
            }
            completeNumber = compareNumber(computer,player);

        }
        if(setGame()){
            run();
        }else{
            return;
        }


    }

    private boolean compareNumber(String computer, String player) {
        int ball = ballCount(computer,player);
        int strike = strikeCount(computer,player);
        if(strike==3){
            return true;
        }else{
            System.out.print(ball);
            gameView.printBall();
            System.out.print(strike);
            gameView.printStrike();
            return false;
        }
    }

    private int strikeCount(String computer, String player) {
        int strike = 0;
        for(int i=0;i<computer.length();i++){
            if(computer.charAt(i)==player.charAt(i)){
                strike++;
            }
        }
        return strike;
    }

    private int ballCount(String computer, String player) {
        int ball =0;
        for(int i=0;i<computer.length();i++){
            for(int j=0;j<player.length();j++){
                if(i!=j&&computer.charAt(i)==player.charAt(j)){
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
