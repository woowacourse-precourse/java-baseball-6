package baseball.view;

import static baseball.message.Message.FINISH_GAME;
import static baseball.message.Message.INPUT_NUMBER_MESSAGE;
import static baseball.message.Message.RESTART_GAME;
import static baseball.message.Message.START_GAME_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public void printStart() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void printFinish() {
        System.out.println(FINISH_GAME);
    }

    public void printGuessResult(String message) {
        System.out.println(message);
    }

    public String getUserGuess() {
        String guess;
        System.out.print(INPUT_NUMBER_MESSAGE);
        guess = Console.readLine();
        return guess;
    }

    public String getContinueGameInput() {
        String continueGameInput;
        System.out.println(RESTART_GAME);
        continueGameInput = Console.readLine();
        return continueGameInput;
    }


}
