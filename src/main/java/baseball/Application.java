package baseball;


import static baseball.util.MessageFormatter.GAME_EXIT;
import static baseball.util.MessageFormatter.GAME_RESTART;

import baseball.domain.Computer;
import baseball.service.BaseballService;
import baseball.service.GameManager;

public class Application {
    public static void main(String[] args) {
        while (true) {
            Computer computer = new Computer();
            BaseballService bs = new BaseballService();
            GameManager gameManager = new GameManager(computer, bs);
            gameManager.startGame();
            boolean morePlay = gameManager.isContinue();
            if (morePlay) {
                System.out.println(GAME_EXIT);
                break;
            }
            System.out.println(GAME_RESTART);
        }
    }
}
