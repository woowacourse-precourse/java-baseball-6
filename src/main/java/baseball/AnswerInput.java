package baseball;

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

    public List<Integer> inputNumber() {
        System.out.println(Contants.ASK_GAME_NUMBER);
        String answer = Console.readLine();
        answer.replaceAll(" ", "");
        if (isStringChars(answer)) {
            InputExceptionError.throwIllegalArgumentException();
        }
        if (isLength(answer)) {
            InputExceptionError.throwIllegalArgumentException();
        }
        if (isDuplicateChars(answer)) {
            InputExceptionError.throwIllegalArgumentException();
        }
        List<Integer> number = toIntegerArrayList(answer);

        answerNumber.setAnswerNumber(number);

        return answerNumber.getAnswerNumber();
    }

    public List<Integer> toIntegerArrayList(String getNumber) {
        String[] getNumberArray = getNumber.split("");
        List<Integer> answerNumber = new ArrayList<>();
        for (String splitNumber : getNumberArray) {
            int intSplitNumber = Integer.parseInt(splitNumber);
            answerNumber.add(intSplitNumber);
        }
        return answerNumber;
    }

    public Boolean isLength(String checkNumber) {
        if (checkNumber.length() != 3) {
            return true;
        }
        return false;
    }

    public Boolean isStringChars(String checkNumber) {
        if (!checkNumber.matches(Contants.ANSWER_NUMBER_PATTERN)) {
            return true;
        }
        return false;
    }

    public Boolean isDuplicateChars(String checkNumber) {
        Set<Character> charSet = new HashSet<>();
        for (char number : checkNumber.toCharArray()) {
            if (charSet.contains(number)) {
                return true;
            }
            charSet.add(number);
        }
        return false;
    }
}
