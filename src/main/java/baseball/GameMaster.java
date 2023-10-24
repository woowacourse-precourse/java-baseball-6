package baseball;

import interfaces.Game;
import static utils.ConsoleUtils.*;

public class GameMaster<T extends Game> {
    private final String RESTART_SELECT = "1";
    private final String EXIT_SELECT = "2";
    private final String END_GAME_HANDLE_PROMPT =
            String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.", RESTART_SELECT, EXIT_SELECT);

    private final Game game;

    public GameMaster(T game) {
        this.game = game;
    }

    public void play() {
        gameInit();

        while (!game.isFinished()) {
            playTurn();
        }
        gameFinish();

        handleGameEnd();
    }

    private void gameInit() {
        game.init();
        println(game.getStartPrompt());
    }

    private void playTurn() {
        print(game.getPlayTurnPrompt());

        String gameInput = input();
        String gameOutput = game.processTurn(gameInput);
        println(gameOutput);
    }

    private void gameFinish() {
        println(game.getFinishPrompt());
    }

    private void handleGameEnd() {
        println(END_GAME_HANDLE_PROMPT);

        String userInput = input();
        switch (userInput) {
            case RESTART_SELECT:
                restart();
                break;
            case EXIT_SELECT:
                exit();
                break;
            default:
                handleGameEnd();
        }
    }

    private void restart() {
        play();
    }

    private void exit() {
        // nothing to do
    }
}
