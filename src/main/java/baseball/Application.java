package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static boolean isContinue = true;

    public static void main(String[] args) {
        List<Integer> systemNumber = new ArrayList<>();
        while (systemNumber.size() < 3) {
            Integer number = Randoms.pickNumberInRange(0, 9);
            if (!systemNumber.contains(number)) {
                systemNumber.add(number);
            }
        }

        while (isContinue) {
            int ball = 0, strike = 0;

            String userInput = Console.readLine();
            if (userInput.matches("[^1-9]")) {
                throw new IllegalArgumentException("1~9 사이의 숫자만 입력해주세요.");
            }
            List<Integer> userNumber = new ArrayList<>();
            for (String s : userInput.split("")) {
                if (userNumber.contains(Integer.parseInt(s))) {
                    throw new IllegalArgumentException("중복된 숫자가 있습니다.");
                }
                userNumber.add(Integer.parseInt(s));
            }
            if (userNumber.size() != 3) {
                throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
            }

            for (int u : userNumber) {
                if (systemNumber.contains(u)) {
                    if (systemNumber.indexOf(u) == userNumber.indexOf(u)) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }
    }
}
