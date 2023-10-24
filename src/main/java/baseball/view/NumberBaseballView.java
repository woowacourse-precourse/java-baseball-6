package baseball.view;

import static baseball.model.Constant.ENTER_NUMBER;
import static baseball.model.Constant.START_GAME;

import camp.nextstep.edu.missionutils.Console;

public class NumberBaseballView {

    public void startNumberBaseball() {
        System.out.println(START_GAME);
    }

    public String getUserInput() {
        System.out.print(ENTER_NUMBER);
        String userInput = Console.readLine();
        return userInput;
    }

    public void showBaseballResult(String result) {
        System.out.println(result);
    }


}
