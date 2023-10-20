package baseball;


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
    }
}
