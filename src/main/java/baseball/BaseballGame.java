package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private GameStatus gameStatus;
    private BotPlayer botPlayer;
    private final BaseballUmpire umpire;

    public BaseballGame(GameStatus gameStatus, BotPlayer botPlayer, BaseballUmpire umpire) {
        this.gameStatus = gameStatus;
        this.botPlayer = botPlayer;
        this.umpire = umpire;
    }

    public void startGame() {
        List<Integer> botNumbers = generateBotNumbers();
        do {
            executePlayerTurn(botNumbers);
        } while (gameStatus == GameStatus.ONGOING);
        askForRestartOrExit();
    }

    private List<Integer> generateBotNumbers() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        botPlayer = new BotPlayer(new ArrayList<>());
        return botPlayer.generateBotNumbers();
    }

    private void executePlayerTurn(List<Integer> botNumbers) {
        List<Integer> playerNumbers = Player.getPlayerInputNumbers();
        gameStatus = umpire.getGameStatus(botNumbers, playerNumbers);
    }

    private void askForRestartOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playerInput = Console.readLine();

        switch (playerInput) {
            case "1":
                startGame();
                break;
            case "2":
                System.out.println("게임을 종료합니다.");
                break;
            default:
                throw new IllegalArgumentException("올바르지 않은 입력입니다. 게임을 종료합니다.");
        }
    }
}
