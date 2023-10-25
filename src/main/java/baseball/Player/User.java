package baseball.Player;

import baseball.Validator;
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
        changeUserInputToUserAnswer(tempAnswer, userInput);
        Validator.checkValidOfAnswerSize(tempAnswer);
        Validator.checkValidOfAnswerUnique(tempAnswer);
        return tempAnswer;
    }

    private static void changeUserInputToUserAnswer(List<Integer> tempAnswer, char[] userInput) {
        for (char character : userInput) {
            tempAnswer.add((int) character - '0');
        }
    }

}
