package baseball.domain;

import baseball.service.BallGeneratorService;

public class Game {

    private final Baseballs computerBaseballs;
    private boolean isGameOver;

    public Game(BallGeneratorService ballGeneratorService) {
        this.computerBaseballs = ballGeneratorService.generateRandomBalls();
        this.isGameOver = false;
    }

    public Baseballs getComputerBalls() {
        return computerBaseballs;
    }

    public void setGameOver() {
        isGameOver = true;
    }

    public boolean isGameOver() {
        return isGameOver;
    }
}