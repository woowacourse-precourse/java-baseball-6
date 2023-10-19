package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class BaseballGame {
    private static final int BASEBALL_NUMBER_SIZE = 3;
    public List<Integer> createComputerNumbers() {
        return pickUniqueNumbersInRange(1,9, BASEBALL_NUMBER_SIZE);
    }

    //사용자로부터 입력 받은 숫자를 userNumber에 저장
    public List<Integer> createUserNumbers() {
        List<Integer> userNumbers = new ArrayList<>();
        String userInput = readLine();
        for (int i=0;i<userInput.length();i++) {
            String str = userInput.substring(i, i+1);
            userNumbers.add(Integer.parseInt(str));
        }
        validateUserNumber(userNumbers);
        return userNumbers;
    }


    // userNumber 검증
    private static void validateUserNumber(List<Integer> userNumbers) {
        int randomUserNumber = pickNumberInList(userNumbers);
        System.out.println(randomUserNumber);
        if (randomUserNumber < 1) {
            throw new IllegalArgumentException("각 숫자는 1부터 9까지만 입력해주세요.");
        }
        if (userNumbers.size() != BASEBALL_NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자 3개만 입력해주세요.");
        }
        Set<Integer> userNumbersSet = new HashSet<>(userNumbers);
        if (userNumbersSet.size() != userNumbers.size()) {
            throw new IllegalArgumentException("서로 다른 숫자 3개를 입력해주세요.");
        }
    }
}
