package baseball;


import static baseball.GameController.LOGGERNAME;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class GameModel {

    Logger log = Logger.getLogger(LOGGERNAME);

    private static GameModel gameModel;
    List<Integer> computer;     // 정답을 저장하기 위한 변수. DB가 없으니 model 변수로 저장하는게 최선일까?

    public static GameModel getInstance() {
        if (gameModel == null) {
            gameModel = new GameModel();
        }
        return gameModel;
    }

    public void startGame() {
        computer = new ArrayList<>(3);
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        log.info("computer의 정답: " + computer);
    }
}
