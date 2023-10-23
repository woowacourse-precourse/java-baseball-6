package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {

    int ballCount;
    int strikeCount;
    int[] baseballNumber;

    //게임 초기화
    public void intiGame() {
        this.ballCount = 0;
        this.strikeCount = 0;
        this.baseballNumber = generateRandomNumber();
    }

    //카운트 초기화
    public void initCount() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }


    //스트라이크 1증가
    public void incStrikeCount() {
        this.strikeCount++;
    }

    //볼 1증가
    public void incBallCount() {
        this.ballCount++;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int[] getBaseballNumber() {
        return baseballNumber;
    }

    //랜덤 숫자 3개 생성
    public int[] generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {

            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer.stream().mapToInt(Integer::intValue).toArray();
    }
}
