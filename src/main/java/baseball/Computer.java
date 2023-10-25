package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> generateRandomNumberList() {
        List<Integer> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        return randomNumberList;
    }

    public GameResult judge(List<Integer> randomNumberList, List<Integer> playerNumberList) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (playerNumberList.get(i) == randomNumberList.get(i)) {
                strike++;
            } else if (playerNumberList.contains(randomNumberList.get(i))) {
                ball++;
            }
        }

        return new GameResult(ball, strike);
    }

}
