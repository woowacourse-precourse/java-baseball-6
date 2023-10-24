package baseball.gameMachine;

import static baseball.user.UserImpl.*;

import baseball.game.Game;
import baseball.user.User;

public class GameMachineImpl implements GameMachine {
    private final String askingRegame = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. 을 출력한다.";

    User user;
    Game game;
    public GameMachineImpl(User user, Game game) {
        this.user = user;
        this.game = game;
    }

    @Override
    public void runGame(Game game) {
        do {
            game.startGame();
        } while (askForReGame());
    }

    @Override
    public boolean askForReGame() {
        printText(askingRegame);
        String userInput = getInput();
        HandleGameMachineException.handleException(userInput, askingRegame);
        if (userInput == "1") {
            return true;
        } else {
            return false;

        }

    }

    @Override
    public void printText(String text) {
        System.out.println(text);
    }

    @Override
    public String getInput() {
        String userInput = user.inputUserNumber();
        return userInput;
    }
}
