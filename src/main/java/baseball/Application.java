package baseball;

import baseball.controller.GameController;
import baseball.utils.RandomUtil;
import java.util.List;

public class Application {
    private static final int RESTART_STATUS = 1;
    private static final int EXIT_STATUS = 2;
    public static void main(String[] args) {
        RandomUtil randomUtil = new RandomUtil();
        GameController gameController = new GameController();
        int status = RESTART_STATUS;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (status != EXIT_STATUS) {
            List<Integer> randomNumbers = randomUtil.createRandomList();

            status = gameController.startGame(randomNumbers);

        }
    }
}
