package baseball.controller;

import baseball.model.Numbers;
import baseball.view.Message;

public class Baseball {
    private static final String CONTINUE_GAME = "1";
    private static final String EXIT_GAME = "2";
    private int numberLength;

    public void playGame(int numberLength) {
        this.numberLength = numberLength;

        Message.startMessage();
        do {
            playSingleRound();
        } while (continueGame());
    }

    private void playSingleRound() {
        Numbers answer = new Numbers();
        Numbers guess = new Numbers();

        answer.generateRandomNumbers(numberLength);
        do {
            Message.inputMessage();
            guess.generateInputNumbers(numberLength, inputString());
        } while (!findResult(answer, guess));
        Message.winMessage(numberLength);
    }

    private boolean findResult(Numbers answer, Numbers guess) {
        int ball;
        int strike;

        strike = guess.countStrike(answer);
        ball = guess.countFull(answer) - strike;
        printResult(ball, strike);
        return (strike == numberLength);
    }

    private boolean continueGame() {
        String choice;

        Message.continueExitMessage();
        choice = inputString();
        if (!isValidChoice(choice)) {
            throw (new IllegalArgumentException());
        }
        return (choice.equals(CONTINUE_GAME));
    }

    private boolean isValidChoice(String choice) {
        return (choice.equals(CONTINUE_GAME)
                || choice.equals(EXIT_GAME));
    }

    private void printResult(int ball, int strike) {
        if ((ball == 0) && (strike == 0)) {
            Message.nothingMessage();
            return ;
        }
        printBall(ball);
        if ((ball > 0) && (strike > 0)) {
            Message.printSpace();
        }
        printStrike(strike);
        Message.printLinebreak();
    }

    private void printBall(int ball) {
        if (ball > 0) {
            Message.ballMessage(ball);
        }
    }

    private void printStrike(int strike) {
        if (strike > 0) {
            Message.strikeMessage(strike);
        }
    }

    private String inputString() {
        return Message.readInput();
    }
}
