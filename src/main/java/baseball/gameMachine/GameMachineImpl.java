package baseball.gameMachine;

import static baseball.user.UserImpl.*;

import baseball.game.Game;
import baseball.user.User;

public class GameMachineImpl implements GameMachine {
    private final String askingRegame = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

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
        printText(askingRegame);
        String userInput = getInput();
        HandleGameMachineException.askingReGameException(userInput);
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
