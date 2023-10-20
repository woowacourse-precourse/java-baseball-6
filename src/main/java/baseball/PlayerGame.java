package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class PlayerGame {
    public List<Integer> playerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String answer = Console.readLine();
        List<Integer> answerNumber = new ArrayList<>();
        while (answerNumber.size() < 3) {
            for (int i = 0; i < answer.length(); i++) {
                answerNumber.add(answer.charAt(i) - '0');
            }
        }

        if (answerNumber.size() != 3) {
            throw new IllegalArgumentException();
        }
        return answerNumber;
    }
}
