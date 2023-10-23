package baseball.controller;

import baseball.model.Number;
import baseball.view.inputView;
import baseball.view.outputView;
import java.util.ArrayList;

public class BaseBall {
    String RESTART_CHOICE = "1";

    public static ArrayList<Integer> getPlayerInputNumber(String input) {
        ArrayList<Integer> inputArr = new ArrayList<>();
        if (Validator.validateUserInput(input)) {
            for (char i : input.toCharArray()) {
                inputArr.add(Character.getNumericValue(i));
            }
        }
        return inputArr;
    }

    public static void oneGame() {
        Number num = new Number();
        num.getComputerRandomNumber();
        ArrayList<Integer> answer = num.getNumber();
        ArrayList<Integer> input = new ArrayList<>();
        do {
            input = getPlayerInputNumber(inputView.getInputNumberMessage());
            int strikes = num.getStrikeCount(input);
            int balls = num.getBallCount(input);
            outputView.displayGetPlayResult(strikes, balls);
        } while (!num.checkSuccess(input));
    }

    public static void playGame() {
        String restartOrExitAnswer = "";
        outputView.displayNewGameMessage();
        do {
            oneGame();
            restartOrExitAnswer = Validator.validateRestartInput(inputView.getInputRestartMessage());
            if (restartOrExitAnswer.equals("2")) {
                break;
            }
        } while (restartOrExitAnswer.equals("1"));
    }

}
