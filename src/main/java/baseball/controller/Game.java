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

    private void guessNumber() {
        boolean correct = false;

        while (!correct) {
            int userNumber = requestNumber();
            String result = baseball.getResult(userNumber);
            showResult(result);
            correct = Baseball.isCorrect(result);
        }
    }

    private String requestRestart() {
        OutputView.printRequestRestart();
        return InputView.readRestartNum();
    }

    private void showEnding() {
        OutputView.printEnding();
        if (requestRestart().equals("1")) {
            play();
        }
    }

    private void play() {
        baseball = new Baseball();

        guessNumber();
        showEnding();
    }


}
