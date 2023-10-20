package baseball;

import baseball.controller.GameController;
import baseball.utils.RandomUtil;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        RandomUtil randomUtil = new RandomUtil();
        GameController gameController = new GameController();
        int status = 1;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (status != 0) {
            List<Integer> randomNumbers = randomUtil.createRandomList();

            status = gameController.startGame(randomNumbers);

        }
    }
}
