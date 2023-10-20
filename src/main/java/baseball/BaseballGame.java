package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        GameStatus gameStatus = GameStatus.CONTINUE;
        BotPlayer botPlayer = new BotPlayer(new ArrayList<>());
        List<Integer> botNumbers = botPlayer.generateNumbers();

        do {
            List<Integer> integers = Player.inputPlayerNumbers();
            GameStatus status = BaseballUmpire.judge(botNumbers, integers);
            gameStatus = status;
        } while (gameStatus == GameStatus.CONTINUE);
        restartGame();
    }

    private void restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            start();
        } else if (input.equals("2")) {
            System.out.println("게임을 종료합니다.");
        }
    }
}
