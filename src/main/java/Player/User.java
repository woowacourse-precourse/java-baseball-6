package Player;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User extends Player {

    public List<Integer> getAnswer() {
        return this.answer;
    }

    @Override
    List<Integer> generateAnswer() {
        List<Integer> tempAnswer = new ArrayList<>();
        char[] userInput = Console.readLine().toCharArray();
        for (char character : userInput) {
            tempAnswer.add((int) character - '0');
        }
        checkValidOfAnswerSize(tempAnswer);
        checkValidOfAnswerUnique(tempAnswer);
        return tempAnswer;
    }

    private void checkValidOfAnswerUnique(List<Integer> tempAnswer) {
        for (int i = 0; i < ANSWER_SIZE - 1; i++) {
            for (int j = i + 1; j < ANSWER_SIZE; j++) {
                if (tempAnswer.get(i).equals(tempAnswer.get(j))) {
                    throw new IllegalArgumentException("숫자는 중복되지 않아야합니다.");
                }
            }
        }
    }

    private void checkValidOfAnswerSize(List<Integer> tempAnswer) {
        if (tempAnswer.size() > ANSWER_SIZE || tempAnswer.isEmpty()) {
            throw new IllegalArgumentException("숫자는 3자리 입력해야 합니다.");
        }
    }
}
