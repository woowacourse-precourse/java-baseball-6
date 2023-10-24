package baseball.numbers;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class User {

    public List<Integer> getUserNumbers() {
        Numbers numbers = new Numbers(createUserNumbers());
        return numbers.getNumbers();
    }

    private List<Integer> createUserNumbers() {
        List<Integer> userNumbers = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();
        for (int i = 0; i < userInput.length(); i++) {
            String str = userInput.substring(i, i + 1);
            userNumbers.add(Integer.parseInt(str));
        }
        return userNumbers;
    }
}
