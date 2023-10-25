package baseball.service;

import static baseball.validation.InputNumberValidation.userInputNumberValidation;
import static baseball.validation.InputNumberValidation.validateParsedChar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class GameService {
    public GameService() {

    }

    public static List<Integer> parsingInputNumber(String inputNumber) {
        List<Integer> parsingNumber = new ArrayList<>();
        userInputNumberValidation(inputNumber);
        for (char parsedChar : inputNumber.toCharArray()) {
            validateParsedChar(parsedChar);
            parsingNumber.add(Character.getNumericValue(parsedChar));
        }
        return parsingNumber;
    }


    public static List<Integer> playGame(List<Integer> computerNumber, List<Integer> userNumber) {
        int strike = getStrikeCount(computerNumber, userNumber);
        int ball = getBallCount(computerNumber, userNumber);

        return List.of(strike, ball);
    }

    public static int getStrikeCount(List<Integer> computerNumber, List<Integer> userNumber) {
        return (int) IntStream.range(0, 3)
                .filter(i -> computerNumber.get(i).equals(userNumber.get(i)))
                .count();
    }

    public static int getBallCount(List<Integer> computerNumber, List<Integer> userNumber) {
        return (int) IntStream.range(0, 3)
                .filter(i -> !computerNumber.get(i).equals(userNumber.get(i)) && userNumber.contains(
                        computerNumber.get(i)))
                .count();
    }

}