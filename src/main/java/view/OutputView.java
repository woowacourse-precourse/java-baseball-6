package view;

import constant.Message;

public class OutputView {
    public static void startGame() {
        System.out.print(Message.GAME_START.getMessage());
    }

    public static void inputNumber() {
        System.out.print(Message.INPUT_NUMBER.getMessage());
    }

    public static void printResult(int strike, int ball) {
        StringBuilder message = new StringBuilder();
        if (ball > 0) {
            message.append(ball);
            message.append(Message.BALL.getMessage());
        }
        if (strike > 0) {
            message.append(strike);
            message.append(Message.STRIKE.getMessage());
        }
        if (ball == 0 && strike == 0) {
            message.append(Message.NOTHING.getMessage());
        }
        message.append('\n');
        System.out.print(message);
    }

    public static void gameOver() {
        System.out.print(Message.GAME_OVER.getMessage());
    }

    public static void restartGame() {
        System.out.print(Message.RESTART.getMessage());
    }
}
