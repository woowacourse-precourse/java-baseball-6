package baseball.service;

import baseball.common.CustomException;
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
        restartSequence();
    }

    private void restartSequence() {

    }

    private void mainSequence() {
        outputView.printGetBall();
        inputController.getBall();
    }

    private int getBall() {
        try {
            return inputController.getBall();
        } catch (CustomException e) {
            outputView.printMessage();
        }
    }
}
