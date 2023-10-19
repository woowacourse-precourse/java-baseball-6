package baseball.service;

import baseball.common.Command;
import baseball.common.CustomException;
import baseball.common.Size;
import baseball.controller.InputController;
import baseball.entity.Ball;

public class BallService {
    private Ball ball;
    private OutputView outputView;
    private InputController inputController;
    private boolean running;

    public void init() {
        BallGenerator ballGenerator = new BallGenerator();
        this.ball = new Ball(ballGenerator.createBall());
        this.inputController = new InputController();
        this.outputView = new OutputView();
        running = true;
        outputView.printStart();
    }

    public void start() {
        while (running) {
            mainSequence();
        }
    }

    private boolean restartSequence() {
        outputView.printRestart();
        return getCommand().equals(Command.RESTART.getKey());
    }

    private void mainSequence() {
        outputView.printGetBall();
        int[] score = ball.compareBall(getBall());
        outputView.printResult(score);
        if (score[1] == Size.NUMBER.getValue()) {
            running = restartSequence();
        }
    }

    private String getCommand() {
        try {
            return inputController.getCommand();
        } catch (CustomException e) {
            outputView.printMessage(e.getErrorMessage());
            return getCommand();
        }
    }

    private int getBall() {
        try {
            return inputController.getBall();
        } catch (CustomException e) {
            outputView.printMessage(e.getErrorMessage());
            return getBall();
        }
    }
}
