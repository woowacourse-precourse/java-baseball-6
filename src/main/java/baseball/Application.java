package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        GameStatus gameStatus = new GameStatus();
        while (!gameStatus.isEnd()) {
            Information.printStartGame();
            Computer computer = new Computer();
            GameService gameService = new GameService();
            while (!gameService.isAllNumberMatched()) {
                Player player = new Player();

                Information.printInputNumber();
                player.guessNumber(Console.readLine());

                gameService.comparePlayerAndComputer(player, computer);
                Information.printBallAndStrike(gameService.getBall(), gameService.getStrike());
            }
            Information.printGuessAll();
            Information.printEndGame();
            gameStatus.updateGameStatus(Console.readLine());
        }
    }
}
