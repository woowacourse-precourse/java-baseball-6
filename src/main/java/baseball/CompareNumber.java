package baseball;

import java.util.Objects;

public class CompareNumber {

    private final int num;
    private final int pos;

    //컴퓨터가 생성한 번호 n 에 대하여 position, number 를 인자로 받고
    //유저가 입력한 번호 n1 n2 n3 을 모두 비교한다.
    public CompareNumber(int pos, int num) {
        this.pos = pos;
        this.num = num;
    }


    public BallScore calculateScore(CompareNumber userBall) {
        if (this.equals(userBall)) {
            return BallScore.STRIKE;
        }
        if (userBall.num == this.num) {
            return BallScore.BALL;
        }
        return BallScore.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CompareNumber that = (CompareNumber) o;
        return num == that.num && pos == that.pos;
    }

    @Override
    public int hashCode() {// 한 클래스에서 동일한 num, pos 를 갖는다면 동일한 해시코드를 반환한다.
        return Objects.hash(pos, num);
    }
}
