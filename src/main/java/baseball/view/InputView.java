package baseball.view;

import static baseball.model.constants.Constant.GAME_INPUT_PHRASE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String setGameInput() {
        System.out.print(GAME_INPUT_PHRASE);
        return Console.readLine();
    }
}
