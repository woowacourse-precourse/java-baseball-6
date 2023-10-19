package baseball.service;

import baseball.common.Command;
import baseball.common.Size;
import baseball.controller.InputController;
import baseball.entity.Ball;
import baseball.view.OutputView;

public class BallService {
    private Ball ball;
    private OutputView outputView;
    private InputController inputController;
    private BallGenerator ballGenerator;
    private boolean running;

    public void init() {
        ballGenerator = new BallGenerator();
        ball = new Ball(ballGenerator.createBall());
        inputController = new InputController();
        outputView = new OutputView();
        running = true;
        outputView.printStart();
    }

    public void start() {
        while (running) {
            mainSequence();
        }
    }

    private void restartSequence() {
        outputView.printRestart();
        running = inputController.getCommand().equals(Command.RESTART.getKey());
        if (running) {
            ball = new Ball(ballGenerator.createBall());
        }
    }

    private void mainSequence() {
        outputView.printGetBall();
        int[] score = ball.compareBall(inputController.getBall());
        outputView.printResult(score);
        if (score[1] == Size.NUMBER.getValue()) {
            restartSequence();
        }
    }
}
