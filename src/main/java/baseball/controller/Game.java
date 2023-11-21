package baseball.controller;

import baseball.domain.Baseball;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {
    Baseball baseball;

    public void run() {
        start();
        play();
    }

    private void start() {
        OutputView.printStart();
    }

    private int requestNumber() {
        OutputView.printRequestNumber();
        return InputView.readUserNum();
    }

    private void showResult(String result) {
        OutputView.printResult(result);
    }

    private void play() {
        baseball = new Baseball();
        boolean correct = false;

        while (!correct) {
            int userNumber = requestNumber();
            String result = baseball.getResult(userNumber);
            showResult(result);
            correct = Baseball.isCorrect(result);
        }
    }


}
