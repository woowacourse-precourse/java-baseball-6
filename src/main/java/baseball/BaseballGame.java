package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        GameStatus gameStatus = GameStatus.ONGOING;
        BotPlayer botPlayer = new BotPlayer(new ArrayList<>());
        List<Integer> botNumbers = botPlayer.generateBotNumbers();

        do {
            List<Integer> playerNumbers = Player.getPlayerInputNumbers();
            gameStatus = BaseballUmpire.judgeGameStatus(botNumbers, playerNumbers);
        } while (gameStatus == GameStatus.ONGOING);
        askForRestartOrExit();
    }

    private void askForRestartOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            start();
        } else if (input.equals("2")) {
            System.out.println("게임을 종료합니다.");
        }
    }
}
