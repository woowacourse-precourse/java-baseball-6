package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;


/**
 * 1.숫자 랜덤 생성
 */
public class CalculateNumber {

    private String calculateNumber;

    public CalculateNumber() {
        setGameClearNumber();
    }

    public String getCalculateNumber() {
        return calculateNumber;
    }

    public void setGameClearNumber() {
        LinkedHashSet<String> calculateNumberCheck = new LinkedHashSet<String>();
        while (calculateNumberCheck.size() < 3) {
            calculateNumberCheck.add(getRandomNumber());
        }

        this.calculateNumber = String.join("", calculateNumberCheck);
    }



    public static String getRandomNumber() {
        return Integer.toString(Randoms.pickNumberInRange(1, 9));
    }

}
