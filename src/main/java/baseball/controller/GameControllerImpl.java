package baseball.controller;

import baseball.domain.Game;
import baseball.service.GameService;
import baseball.view.Console;

public class GameControllerImpl implements GameController {
    public GameControllerImpl(GameService gameService, Console console) {
        this.gameService = gameService;
        this.console = console;
    }

    private final GameService gameService;

    private final Console console;

    private final String MENU_RESTART = "1";
    private final String MENU_EXIT = "2";
    private final String THREE_STRIKE = "3스트라이크";

    @Override
    public void gameStart() {
        console.printApplicationStartMessage();

        Game game = gameService.getGame();

        while ( true ) {
            gameService.init(game);
            play(game);

            console.printSelectMenuMessage();
            String selectedMenu = console.getUserInput();
            gameService.inputMenuValidate(selectedMenu);

            if ( selectedMenu.equals(MENU_EXIT) ) {
                console.printApplicationExitMessage();
                break;
            }
        }
    }

    private void play(Game game) {
        while ( true ) {
            console.printInputNumberMessage();

            String playerNumbers = console.getUserInput();
            gameService.playerNumbersValidate(playerNumbers);

            String matchResult = gameService.numbersMatch(game.getTargetNumberList(), playerNumbers);
            console.printNumbersMatchResult(matchResult);
            if ( matchResult.equals(THREE_STRIKE) ) {
                console.printPlayerWinMessage();
                break;
            }
        }
    }
}
