package baseball;

import static baseball.Utils.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {

    public Controller() {}

    public void gameStart(){
        String state = START_GAME;
        Oppoent oppoent = new Oppoent();
        Game game = new Game(oppoent);
        while (state.equals(START_GAME)) {
            game.initialiser();
            game.gamePlay();
            printRequestRestartOrFinish();
            state = readLine();
            validateRange(state);
        }
    }

    private void printRequestRestartOrFinish() {
        System.out.println(RESTART_OR_FINISH);
    }

    private void validateRange(String state) {
        if (!state.equals(START_GAME) && !state.equals(END_GAME)) {
            throw new IllegalArgumentException("Invalid number is entered");
        }
    }
}
