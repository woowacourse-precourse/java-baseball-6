package baseball.model;

import baseball.common.CheckResult;
import baseball.common.GameStatus;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private List<Integer> gameNumbers;
    private GameStatus status;

    public Computer() {
        this.status = GameStatus.ONPLAYING;
    }

    public void createRandomNumbers() {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            numbers.add(randomNumber);
        }

        this.gameNumbers = new ArrayList<>(numbers);
    }

    public CheckResult checkPlayerNumbers(List<Integer> playerNumbers) {
        int strike=0, ball=0;

        //TODO: 컴퓨터가 생성한 랜덤 숫자와 사용자가 입력한 숫자 비교
        for (int gameIdx = 0; gameIdx < playerNumbers.size(); gameIdx++) {
            for (int playerIdx = 0; playerIdx < playerNumbers.size(); playerIdx++) {
                if (gameNumbers.get(gameIdx).equals(playerNumbers.get(playerIdx))) {
                    if (gameIdx == playerIdx) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }

        // 3개 다 맞은 경우
        if (strike == 3) {
            this.status = GameStatus.ALL_CORRECT;
        }

        return new CheckResult(strike, ball);
    }

    public boolean isEnd() {
        return this.status.isEnd();
    }

    public boolean isAllCorrect() {
        return this.status.isAllCorrect();
    }
}
