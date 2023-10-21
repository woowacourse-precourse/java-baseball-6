package baseball.controller;

import baseball.view.ErrorView;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    public static int[] getInputNumber(int[] answer) {
        ErrorView errorView = new ErrorView();
        int [] inputNum = new int[3];
        String input = Console.readLine();
        if (input.length()!=3) {
            errorView.inputNumberLengthError();
        }
        for(int i=0; i<answer.length; i++) {
            char c = input.charAt(i);
            if(!Character.isDigit(c)) {
                errorView.validateInputError();
            }
                inputNum[i] = Integer.parseInt(String.valueOf(c));
        }
        return inputNum;
    }
}
