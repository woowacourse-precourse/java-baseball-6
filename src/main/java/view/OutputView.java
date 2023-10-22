package view;

import model.referee.GameScoreboard;
import utils.BaseballMessageConvertor;

public class OutputView {

    public static void write(String message) {
        System.out.println(message);
    }

    public static void write(GameScoreboard gameScoreboard) {
        String convertMessage = BaseballMessageConvertor.generateScoreMessage(gameScoreboard);
        System.out.println(convertMessage);
    }

}
