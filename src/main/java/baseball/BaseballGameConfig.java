package baseball;

import java.util.ArrayList;

public class BaseballGameConfig {
    public static BaseballGame createBaseballGame() {
        GameRule rule = new BaseballRule();
        GameStatus gameStatus = GameStatus.ONGOING;
        BotPlayer botPlayer = new BotPlayer(new ArrayList<>());
        BaseballUmpire umpire = new BaseballUmpire(rule);

        return new BaseballGame(gameStatus, botPlayer, umpire);
    }
}
