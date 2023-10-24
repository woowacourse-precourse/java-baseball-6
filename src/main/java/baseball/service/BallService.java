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
    private int[] score;

    public void init() {
        ballGenerator = new BallGenerator();
        ball = new Ball(ballGenerator.createBall());
        inputController = new InputController();
        outputView = new OutputView();
        running = true;
    }

    public void start() {
        outputView.printStart();
        while (running) {
            mainSequence();
        }
    }

    private void mainSequence() {
        outputView.printGetBall();
        checkUsersBall();
        outputView.printResult(score);
        if (scoreIs3Strike()) {
            restartSequence();
        }
    }

    private void restartSequence() {
        outputView.printRestart();
        checkUsersCommand();
        if (running) {
            ball = new Ball(ballGenerator.createBall());
        }
    }

    private boolean scoreIs3Strike() {
        return score[1] == Size.NUMBER.getValue();
    }

    private void checkUsersBall() {
        score = ball.compareBall(inputController.getBall());
    }

    private void checkUsersCommand() {
        running = inputController.getCommand().equals(Command.RESTART.getKey());
    }
}
