package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> computerNumbers;

    private Integer ball = 0;
    private Integer strike = 0;
    private Boolean complete;

    public void generateNumber() {

        final int MAX_NUMBER = 9;
        final int MIN_NUMBER = 1;
        this.complete = false;

        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        computerNumbers = randomNumbers;
    }

    public String getResult(List<Integer> randomNumbers, List<Integer> numbers) {
        for (int i = 0; i < randomNumbers.size(); i++) {
            for (int j = 0; j < randomNumbers.size(); j++) {
                if (randomNumbers.get(i).equals(numbers.get(j))) {
                    if (i == j) {
                        this.strike++;
                    } else {
                        this.ball++;
                    }
                }
            }
        }

        String message = this.getMessage();

        this.strike = 0;
        this.ball = 0;
        return message;
    }

    public String getMessage() {

        if (this.ball > 0 && this.strike > 0) {
            return this.ball + "볼 " + this.strike + "스트라이크";
        } else if (this.ball > 0) {
            return this.ball + "볼";
        } else if (this.strike == 3) {
            this.complete = true;
            return this.strike + "스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        } else if (this.strike > 0) {
            return this.strike + "스트라이크";
        }
        return "낫싱";
    }

    public Boolean getComplete() {
        return complete;
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
