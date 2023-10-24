package baseball.domain;

import java.util.List;

public class Game {

    private static Integer strike;
    private static Integer ball;

    public void reset(){
        strike = 0;
        ball = 0;
    }

    public static Integer getStrike() {
        return strike;
    }

    public static Integer getBall() {
        return ball;
    }

    public void compare(List<Integer> computerNumbers, List<Integer> userNumber) {
        reset();
        for(int i=0; i<3; i++){
            if(computerNumbers.get(i).equals(userNumber.get(i))) {
                strike++;
                continue;
            }
            if(computerNumbers.contains(userNumber.get(i))){
                ball++;
            }
        }
    }
}
