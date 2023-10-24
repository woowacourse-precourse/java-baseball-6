package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    private static GameModel gameModel = new GameModel();

    private GameModel() {
    }

    public static GameModel getInstance() {
        return gameModel;
    }

    //컴퓨터 숫자 생성
    public List<Integer> generateComputerNums() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        //컴퓨터 숫자 출력
        for (Integer i : computer) {
            System.out.print(i + " ");
        }
        System.out.println();

        return computer;
    }
}
