package baseball.gameMachine;

import static baseball.user.UserImpl.*;

import baseball.game.Game;
import baseball.handleException.HandleException;
import baseball.user.User;
import net.bytebuddy.asm.Advice.ExceptionHandler;

public class GameMachineImpl implements GameMachine {

    static User user;
    Game game;
    public GameMachineImpl(User user, Game game) {
        this.user = user;
        this.game = game;
    }

    @Override
    public void runGame() {
        game.runGame();
    }


    public static void printText(String text) {
        System.out.print(text);
    }

    public static String getInput() {
        String userInput = user.inputUserNumber();
        return userInput;
    }
}
