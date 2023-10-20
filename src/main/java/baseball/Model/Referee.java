package baseball.Model;

public class Referee {
    int strike;
    int ball;

    public void judge (Numbers computer, Numbers user) {
        int sameNumberCount = countSameNumber(computer, user);
        int sameIndexAndNumberCount = countSameIndexAndNumber(computer, user);
        strike = sameIndexAndNumberCount;
        ball = sameNumberCount - strike;
    }
}
