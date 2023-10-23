package baseball;

import java.util.List;

public class Umpire {

    private Integer strike = 0;
    private Integer ball = 0;
    private boolean nothing = false;

    public Umpire(){}
    public Umpire(Integer strike, Integer ball, boolean nothing) {
        this.strike = strike;
        this.ball = ball;
        this.nothing = nothing;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }

    public boolean isNothing() {
        return nothing;
    }

    public void judge(List<Integer> answer, List<Integer> trial) {

        for (int i = 0; i < trial.size(); i++) {

            Integer num = trial.get(i);
            // 시도하는 숫자가 답에 있는지 확인
            if (answer.contains(num)) {
                int answerNumIndex = answer.indexOf(num);

                //시도하는 숫자가 답에 있고, 순서가 같다면 strike
                if (i == answerNumIndex) {
                    strike++;
                    continue;
                }
                //순서가 같지 않다면 ball
                ball++;
            }
        }

        // strike와 ball이 한 개도 없다면 nothing
        if (strike == 0 && ball == 0) {
            nothing = true;
        }
    }

}
