package controller;

import model.ComputerNumbers;
import model.PlayerNumbers;
import view.GameView;

public class Game {
    private final ComputerNumbers computerNumbers;
    private PlayerNumbers playerNumbers;
    private final GameView gameView;

    public Game() {
        computerNumbers = new ComputerNumbers();
        playerNumbers = new PlayerNumbers();
        gameView = new GameView();
    }

    public void run() {
        String computer = ComputerNumbers.createNumbers(); //컴퓨터 랜덤 숫자 생성
        String player = GameView.printInputNumber();
        if(!playerNumbers.validatedNumber(player)) {
            throw new IllegalArgumentException();
        }


        System.out.println(player);


    }
}
