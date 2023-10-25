package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final int MAX_NUMBER = 9;
    private final int MIN_NUMBER = 1;

    private final Integer LIST_SIZE = 3;

    private Integer ball = 0;
    private Integer strike = 0;

    public List<Integer> generateNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    public String getResult(List<Integer> randomNumbers, List<Integer> numbers) {
        for (int i = 0; i < LIST_SIZE; i++) {
            for (int j = 0; j < LIST_SIZE; j++) {
                if (randomNumbers.get(i) == numbers.get(j)) {
                    if (i == j) {
                        this.strike++;
                    } else {
                        this.ball++;
                    }
                }
            }
        }

        return this.getMessage();
    }

    public String getMessage() {

        if (this.ball > 0 && this.strike > 0) {
            return this.ball + "볼 " + this.strike + "스트라이크";
        } else if (this.ball > 0) {
            return this.ball + "볼";
        } else if (this.strike == 3) {
            return this.strike + "스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        } else if (this.strike > 0) {
            return this.strike + "스트라이크";
        }
        return "낫싱";
    }
}
