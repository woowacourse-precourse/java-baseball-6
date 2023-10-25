package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.constant.GameConstant.NUMBER_LENGTH;

public class NumberGenerator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static List<Integer> generateRandomNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    public static List<Integer> stringToIntegerList(String userInput) {
        List<Integer> userNumbers = userInput.chars()
                .mapToObj(num -> num - '0')
                .collect(Collectors.toList());

        if (!validateNumbers(userNumbers)) {
            throw new IllegalArgumentException("0을 제외한 세 자리의 서로 다른 숫자가 입력되어야 합니다.");
        }
        return userNumbers;
    }

    private static boolean validateNumbers(List<Integer> numbers) {
        if (numbers.size() != NUMBER_LENGTH) {
            return false;
        }
        if (numbers.contains(0)) {
            return false;
        }
        if (numbers.stream().anyMatch(number -> number < 1 || number > 9)) {
            return false;
        }
        if (numbers.stream().distinct().count() != NUMBER_LENGTH) {
            return false;
        }
        return true;
    }

}
