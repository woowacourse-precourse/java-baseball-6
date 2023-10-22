package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    public List<Integer> createUserNumbers() {
        List<Integer> userNumbers = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();

        for (int i=0;i<userInput.length();i++) {
            String str = userInput.substring(i, i+1);
            userNumbers.add(Integer.parseInt(str));
        }
        validateUserNumber(userNumbers);
        return userNumbers;
    }

    private static void validateUserNumber(List<Integer> userNumbers) {
        if (userNumbers.size() != Constants.BASEBALL_NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자 3개만 입력해주세요.");
        }
        Set<Integer> userNumbersSet = new HashSet<>(userNumbers);
        if (userNumbersSet.size() != userNumbers.size()) {
            throw new IllegalArgumentException("서로 다른 숫자 3개를 입력해주세요.");
        }
    }
}
