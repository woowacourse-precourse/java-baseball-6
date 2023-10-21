package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import static baseball.util.MessageConst.NUMBER_INPUT_FORMAT_EXCEPTION;

public class BallNumbersDTO {

    private final List<Integer> numberList;

    public BallNumbersDTO(String ballNumbersStr) {
        this.numberList = createNumberList(ballNumbersStr);
    }

    private static List<Integer> createNumberList(String ballNumbersStr) {
        List<Integer> userNumbers = new ArrayList<>();
        validateNumber(ballNumbersStr);
        String[] splitNumberStr = ballNumbersStr.split("");
        for (String numStr : splitNumberStr) {
            userNumbers.add(Integer.parseInt(numStr));
        }
        return userNumbers;
    }


    private static void validateNumber(String ballNumbersStr) {
        for (int i = 0; i < ballNumbersStr.length(); i++) {
            if (!Character.isDigit(ballNumbersStr.charAt(i))) {
                throw new IllegalArgumentException(NUMBER_INPUT_FORMAT_EXCEPTION);
            }
        }
    }

    public List<Integer> getNumberList() {
        return numberList;
    }
}
