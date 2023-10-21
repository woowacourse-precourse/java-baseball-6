package baseball.domain;

import baseball.system.SystemConstant;

public class Result {
    public int numberOfStrikes;
    public int numberOfBalls;
    //TO DO: 원시값 포장하기
    //TO DO: 테스트 코드를 변경하고 private으로 전환하기

    public Result(int newStrikes, int newBalls) {
        numberOfStrikes = newStrikes;
        numberOfBalls = newBalls;
    }

    public boolean isNothing() {
        return numberOfBalls == 0 && numberOfStrikes == 0;
        //TO DO: 포장된 vo자료형의 메서드를 사용해서 코드 복잡도 줄이기
    }

    public boolean isStrikesAllOfBalls() {
        return numberOfStrikes == SystemConstant.MAXIMUM_DIGIT;
    }
}