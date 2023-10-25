package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;

//1.숫자 랜덤 생성
public class GenerateNumber {
    private String computerNumber;

    public GenerateNumber() {
        setGameNumber();
    }

    public String getComputerNumber() {
        return computerNumber;
    }

    public void setGameNumber() {
        LinkedHashSet<String> computerNumberCheck = new LinkedHashSet<>();
        while (computerNumberCheck.size() < 3) {
            computerNumberCheck.add(getRandomNumber());
        }

        this.computerNumber = String.join("", computerNumberCheck);
    }

    public static String getRandomNumber() {
        return Integer.toString(Randoms.pickNumberInRange(1, 9));
    }
}
