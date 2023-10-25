package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Ball {
    private static final int INPUT_MINIMUM = 1;
    private static final int INPUT_MAXIMUM = 9;
    private final int number;

    public Ball(int number){
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(int number){
        if(number < INPUT_MINIMUM || number > INPUT_MAXIMUM) {
            throw new IllegalArgumentException("공은 1에서 9까지의 자연수만 가능합니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number;
    }
}
