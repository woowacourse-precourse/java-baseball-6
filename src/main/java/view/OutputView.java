package view;

import model.referee.GameScoreboard;

public class OutputView {

    public static void write(String message) {
        System.out.println(message);
    }

    public static void write(GameScoreboard gameScoreboard) {
        int strike = gameScoreboard.getStrike();
        int ball = gameScoreboard.getBall();
        StringBuilder builder = new StringBuilder();
        if (ball > 0 && strike > 0) {
            builder.append(ball);
            builder.append("볼 ");
            builder.append(strike);
            builder.append("스트라이크");
        } else if (ball > 0) {
            builder.append(ball);
            builder.append("볼");
        } else if (strike > 0) {
            builder.append(strike);
            builder.append("스트라이크");
        }
        if (gameScoreboard.isNothing()) {
            builder.append("낫싱");
        }
        System.out.println(builder);
    }
}
