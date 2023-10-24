package baseball;

import baseball.controller.GameController;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController();

        try {
            gameController.run();
        } catch (IllegalAccessError e) {
            System.out.println(e);
        }

        // 컴퓨터가 중복없는 3개의 수를 고르는 코드
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

    }
}