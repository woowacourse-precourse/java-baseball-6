package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

    }

    private List<Integer> chooseRandomNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }

        return computerNumbers;
    }

    private int getNumbers() {
        String userString = Console.readLine();
        int userNumbers;

        try {
            userNumbers = Integer.parseInt(userString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        if (userString.length() != 3) {
            throw new IllegalArgumentException("3자리의 수를 입력해주세요.");
        }

        if (userString.charAt(0) == userString.charAt(1)
                || userString.charAt(1) == userString.charAt(2)
                || userString.charAt(0) == userString.charAt(2)) {
            throw new IllegalArgumentException("서로 다른 3자리의 수를 입력해주세요.");
        }

        return userNumbers;
    }
}
