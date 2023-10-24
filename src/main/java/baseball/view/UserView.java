package baseball.view;

import static baseball.utility.Constants.GAME_START_MESSAGE;
import static baseball.utility.Constants.NUMBER_INPUT_PROMPT_MESSAGE;

public class UserView {
    public UserView(){};
    public void printGameStartMessage(){
        System.out.println(GAME_START_MESSAGE);
    }

    public void printNumberInputPrompt(){
        System.out.println(NUMBER_INPUT_PROMPT_MESSAGE);
    }
}
