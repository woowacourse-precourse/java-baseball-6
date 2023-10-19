package baseball.view;

import static baseball.view.Messages.GAME_CLEAR_MESSAGE;
import static baseball.view.Messages.INPUT_NUMBER_MESSAGE;
import static baseball.view.Messages.INPUT_OPTION_MESSAGE;
import static baseball.view.Messages.START_GAME_MESSAGE;

public class OutputView {

    public void showStartMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void showInputNumberMessage() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public void showOptionMenu() {
        System.out.println(GAME_CLEAR_MESSAGE);
        System.out.println(INPUT_OPTION_MESSAGE);
    }
}
