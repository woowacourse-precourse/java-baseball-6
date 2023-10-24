package baseball.view;

import static baseball.model.Constant.END_NUMBER_BASEBALL;
import static baseball.model.Constant.ENTER_NUMBER;
import static baseball.model.Constant.START_NUMBER_BASEBALL;

import camp.nextstep.edu.missionutils.Console;

public class NumberBaseballView {

    public void startNumberBaseball() {
        System.out.println(START_NUMBER_BASEBALL);
    }

    public String getUserInput() {
        System.out.print(ENTER_NUMBER);
        String userInput = Console.readLine();
        return userInput;
    }

    public void showBaseballResult(String result) {
        System.out.println(result);
    }


    public int endNumberBaseball() {
        System.out.println(END_NUMBER_BASEBALL);
        String userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }
}
