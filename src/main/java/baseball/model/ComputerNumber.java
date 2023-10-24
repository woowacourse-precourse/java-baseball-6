package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;


/**
 * 1.숫자 랜덤 생성
 */
public class ComputerNumber {

    private String computerNumber;

    public ComputerNumber() {
        setGameClearNumber();
    }

    public String getComputerNumber() {
        return computerNumber;
    }

    public void setGameClearNumber() {
        LinkedHashSet<String> computerNumberCheck = new LinkedHashSet<String>();
        while (computerNumberCheck.size() < 3) {
            computerNumberCheck.add(getRandomNumber());
        }

        this.computerNumber = String.join("", computerNumberCheck);
    }



    public static String getRandomNumber() {
        return Integer.toString(Randoms.pickNumberInRange(1, 9));
    }

}