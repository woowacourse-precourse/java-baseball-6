package baseball.controller;

import baseball.model.ComputerModel;
import baseball.model.InputModel;
import baseball.model.OutputModel;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

public class Controller {
    private static boolean done;

    public static void gameStart() {
        View.gameStartPrint();
        game();
    }

    public static void gameMiddle() {
        ComputerModel.setAnswer();
        System.out.println(ComputerModel.getAnswer()); // 제출할 때는 지우기!!!!
        do {
            View.gameNumberInputPrint();
            InputModel.inputThreeNumber();
            InputModel.isInputThreeNumber();
            InputModel.guessToIntegerList();
            OutputModel.strikeBallCalculate(ComputerModel.getAnswer(), InputModel.getGuessToList());
            OutputModel.setBaseballHint();
            View.baseballHintPrint();
        } while (!ComputerModel.getAnswer().equals(InputModel.getGuessToList()));
        View.gameEndPrint();
    }

    public static void gameEnd() {
        View.gameRestartPrint();
        String str = Console.readLine();
        if (str.length() != 1) {
            throw new IllegalArgumentException("1 혹은 2를 입력해주세요");
        }
        boolean isNum = Character.isDigit(str.charAt(0));
        if (!isNum) {
            throw new IllegalArgumentException("1 혹은 2를 입력해주세요");
        }
        int i = Integer.parseInt(str);
        if (i == 1) {
            done = true;
        }
        if (i == 2) {
            done = false;
        }
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("1 혹은 2를 입력해주세요");
        }
    }

    public static void game() {
        do {
            Controller.gameMiddle();
            Controller.gameEnd();
        } while (done);
    }
}
