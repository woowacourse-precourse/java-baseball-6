package baseball.game.pitcher;

import static baseball.AppConfig.DIGIT_NUM;
import static baseball.AppConfig.MAX_NUMBER;
import static baseball.AppConfig.MIN_NUMBER;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class ComputerRandomPitcherImpl implements Pitcher {
    @Override
    public String pitch() {
        String ball = "";
        for(int i = 0 ; i < DIGIT_NUM ; i++){
            //랜덤숫자 생성
            int randNum = pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            ball = ball + randNum;
        }
        return ball;
    }
}
