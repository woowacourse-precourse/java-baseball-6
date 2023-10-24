package game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import validation.IntegerValidation;
import validation.StringValidation;

public class User {

    private List<Integer> number;
    private int strike;
    private int ball;

    // User 를 생성하면 자동으로 값을 설정해준다.
    public User() {
        this.strike = 0;
        this.ball = 0;
    }

    public int getBall() {
        return ball;
    }

    private void setBall(int ball) {
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    private void setStrike(int strike) {
        this.strike = strike;
    }

    public int getSumOfScore() {
        return this.ball + this.strike;
    }

    public List<Integer> getNumber() {
        return number;
    }

    public void setNumber(List<Integer> number) {
        this.number = number;
    }

    // String이 들어오면 Validation Check를 하고 Integer List 형태로 바꾸어서 저장함
    public void setNumber(String input) {
        List<Integer> intArray = new ArrayList<Integer>();

        StringValidation.validateLength(input, Const.NUMBER_COUNT); // 자릿수가 맞는지 체크
        StringValidation.validateInteger(input); // 숫자가 입력되었는지 체크
        StringValidation.validateDuplication(input); // 중복된 문자가 있는지 체크
        IntegerValidation.validateRangeEachNumber(Integer.parseInt(input), Const.BEGIN_RANGE,
            Const.END_RANGE); // 각 숫자가 범위 안에 있는지 체크

        for (int i = 0; i < input.length(); i++) {
            int num = Character.getNumericValue(input.charAt(i));
            intArray.add(num);
        }

        this.number = intArray;
    }

    public void addBall() {
        ++this.ball;
    }

    public void addStrike() {
        ++this.strike;
    }

    public void resetScore() {
        this.ball = 0;
        this.strike = 0;
    }

    public void setRandomNumber() {
        List<Integer> intArray = new ArrayList<Integer>();

        // 랜덤으로 round 만큼의 값을 받아서 배열에 받는다.
        while (intArray.size() < Const.NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!intArray.contains(randomNumber)) {
                intArray.add(randomNumber);
            }
        }

        this.number = intArray;
    }
}
