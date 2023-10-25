package baseball.gameMachine;

import static baseball.user.UserImpl.*;

import baseball.game.Game;
import baseball.handleException.HandleException;
import baseball.user.User;
import net.bytebuddy.asm.Advice.ExceptionHandler;

public class GameMachineImpl implements GameMachine {
    private final String ASKING_REGAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

    static User user;
    Game game;
    public GameMachineImpl(User user, Game game) {
        this.user = user;
        this.game = game;
    }

    @Override
    public void runGame() {
        do {
            game.runGame();
        } while (askForReGame());
    }

    @Override
    public boolean askForReGame() {
        printText(ASKING_REGAME);
        String userInput = getInput();
        HandleException.exceptionHandlingForUserInput(userInput);
        int checkValue = Integer.parseInt(userInput);
        if (checkValue == 1) {
            return true;
        } else {
            return false;

        }

    }

    public static void printText(String text) {
        System.out.print(text);
    }

    public static String getInput() {
        String userInput = user.inputUserNumber();
        return userInput;
    }
}
