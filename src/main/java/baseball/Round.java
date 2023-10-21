package baseball;

public class Round {

    public StrikeAndBall judge(MyInt myInt, ComInt comInt) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (checkStrike(myInt, comInt, i)) {
                strike++;
                continue;
            }
            if (comInt.contains(myInt.getMyIntIdx(i))) {
                ball++;
            }
        }
        return new StrikeAndBall(strike, ball);
    }

    private boolean checkStrike(MyInt myInt, ComInt comInt, int i) {
        return myInt.getMyIntIdx(i).equals(comInt.getIdx(i));
    }
}

