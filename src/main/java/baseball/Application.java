package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        GameStatus gameStatus = new GameStatus();

        while (!gameStatus.isEnd()) {
            Information.printStartGame();

            GameService gameService = new GameService();
            gameService.startGame();

            Information.printGuessAll();
            Information.printEndGame();
            gameStatus.updateGameStatus(Console.readLine());
        }
    }
}
