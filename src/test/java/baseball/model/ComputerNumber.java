package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber extends Number{
    public ComputerNumber() {
        super(generateRandomNumberArray());
    }

    private static List<Integer> generateRandomNumberArray() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public String getResultComparedWithUserNumber(UserNumber userNumber) {
        int balls = 0;
        int strikes = 0;

        for (int i = 0; i < length; i++) {
            int userDigit = userNumber.getDigit(i);
            if (getDigit(i) == userDigit) {
                strikes++;
            } else if (getDigits().contains(userDigit)) {
                balls++;
            }
        }

        String result = "";
        if(balls > 0) result += balls + "볼 ";
        if(strikes > 0) result += strikes + "스트라이크 ";
        if(result.isEmpty()) result = "낫싱";

        return result.trim();
    }
}
