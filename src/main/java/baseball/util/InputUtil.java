package baseball.util;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputUtil {
    public static String getUserInput() {
        String userInput = Console.readLine();
        if (userInput.matches("[^1-9]")) {
            throw new IllegalArgumentException("1~9 사이의 숫자만 입력해주세요.");
        }
        return userInput;
    }

    public static String[] getUserInputs() {
        return getUserInput().split("");
    }

    public static String getRandomNumber() {
        return String.valueOf(Randoms.pickNumberInRange(0, 9));
    }

    public static List<String> getRandomNumberList() {
        Set<String> systemNumber = new HashSet<>();
        while (systemNumber.size() < 3) {
            systemNumber.add(getRandomNumber());
        }
        return systemNumber.stream().toList();
    }

}
