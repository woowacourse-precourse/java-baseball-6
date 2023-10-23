package baseball.repository;

import baseball.dto.AnswerNumber;
import baseball.services.Constants;
import baseball.services.InputExceptionError;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnswerInput {
    private final AnswerNumber answerNumber;

    public AnswerInput() {
        this.answerNumber = new AnswerNumber();
    }

    private List<Integer> toIntegerArrayList(String getNumber) {
        String[] getNumberArray = getNumber.split("");
        List<Integer> answerNumber = new ArrayList<>();
        for (String splitNumber : getNumberArray) {
            int intSplitNumber = Integer.parseInt(splitNumber);
            answerNumber.add(intSplitNumber);
        }
        return answerNumber;
    }

    private Boolean isValidInputNumberFormat(String checkNumber) {
        if (!checkNumber.matches(Constants.ANSWER_NUMBER_PATTERN)) {
            return true;
        }
        return false;
    }

    private Boolean isDuplicateChars(String checkNumber) {
        Set<Character> charSet = new HashSet<>();
        for (char number : checkNumber.toCharArray()) {
            if (charSet.contains(number)) {
                return true;
            }
            charSet.add(number);
        }
        return false;
    }

    public void inputNumber() {
        System.out.print(Constants.ASK_GAME_NUMBER);
        String answer = Console.readLine();
//        if (answer.contains(" ")) {
//            answer = answer.replaceAll(" ", "");
//        }
        if (isValidInputNumberFormat(answer)) {
            InputExceptionError.throwIllegalArgumentException();
        }
        if (isDuplicateChars(answer)) {
            InputExceptionError.throwIllegalArgumentException();
        }
        List<Integer> number = toIntegerArrayList(answer);

        answerNumber.setAnswerNumber(number);
    }

    public List<Integer> getAnswerNumber() {
        return answerNumber.getAnswerNumber();
    }
}
