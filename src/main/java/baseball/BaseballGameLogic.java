package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseballGameLogic {

    private static final int DIGIT_LENGTH = 3;
    private static final int DIGIT_MINIMUM = 1;
    private static final int DIGIT_MAXIMUM = 9;

    public List<Integer> getRandomThreeDigitNonZero(){
        List<Integer> threeDigitNonZero = new ArrayList<>();

        while (threeDigitNonZero.size() < DIGIT_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(DIGIT_MINIMUM, DIGIT_MAXIMUM);
            if (!threeDigitNonZero.contains(randomNumber)) {
                threeDigitNonZero.add(randomNumber);
            }
        }

        return threeDigitNonZero;
    }

    public BallCount checkBallCount(List<Integer> randomThreeDigits, List<Integer> playerInputNumber){
        int strike = 0;
        int ball = 0;
        BallCount ballCount = new BallCount();

        for(int i = 0; i < DIGIT_LENGTH; i++){
            if(Objects.equals(randomThreeDigits.get(i), playerInputNumber.get(i))){
                strike ++;
                continue;
            }

            if(randomThreeDigits.contains(playerInputNumber.get(i))){
                ball ++;
            }
        }

        ballCount.setStrike(strike);
        ballCount.setBall(ball);

        return ballCount;
    }
}
