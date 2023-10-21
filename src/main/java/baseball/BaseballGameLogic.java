package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseballGameLogic {

    private static final int DIGIT_LENGTH = 3;
    private static final int DIGIT_MINIMUM = 1;
    private static final int DIGIT_MAXIMUM = 9;

    public List<Integer> getThreeDigitNonZero(){
        List<Integer> threeDigitNonZero = new ArrayList<>();

        while (threeDigitNonZero.size() < DIGIT_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(DIGIT_MINIMUM, DIGIT_MAXIMUM);
            if (!threeDigitNonZero.contains(randomNumber)) {
                threeDigitNonZero.add(randomNumber);
            }
        }

        return threeDigitNonZero;
    }

    public List<Integer> changeStringToDigit(String numberFromPlayer) {
        ArrayList<Integer> digitList = new ArrayList<>();

        for (int i = 0; i < numberFromPlayer.length(); i++) {
            char digitChar = numberFromPlayer.charAt(i); // 각 자리의 문자를 가져옴
            int digit = Character.getNumericValue(digitChar); // 문자를 정수로 변환
            digitList.add(digit); // 정수를 리스트에 추가
        }

        return digitList;
    }

    public BallCount checkBallCount(List<Integer> randomThreeDigits, List<Integer> inputDigits){
        int strike = 0;
        int ball = 0;
        BallCount ballCount = new BallCount();

        for(int i = 0; i < DIGIT_LENGTH; i++){
            if(Objects.equals(randomThreeDigits.get(i), inputDigits.get(i))){
                strike ++;
                continue;
            }

            if(randomThreeDigits.contains(inputDigits.get(i))){
                ball ++;
            }
        }

        ballCount.setStrike(strike);
        ballCount.setBall(ball);

        return ballCount;
    }
}
