package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    private static final int SIZE = 3;

    // 컴퓨터가 3개의 랜덤한 수를 뽑는 메서드
    public List<Integer> generateComputersNumber() {
        Set<Integer> computer = new HashSet<>();
        while (computer.size() < SIZE) {
            computer.add(Randoms.pickNumberInRange(1, 9));
        }

        return new ArrayList<>(computer);
    }

    public List<Integer> calculateResult(List<Integer> userInput, List<Integer> computer) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (computer.contains(userInput.get(i))) {
                if (userInput.get(i) == computer.get(i)) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }
        List<Integer> result = new ArrayList<>();

        result.add(ball);
        result.add(strike);

        return result;
    }


}
