package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static List<Integer> getRandomNumber(int length) {

        List<Integer> numbers = new ArrayList<>();
        while(numbers.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public static Score getScore(List<Integer> answerNumbers, List<Integer> userNumbers) {

        int strike = 0;
        int ball = 0;

        for(int i = 0; i < answerNumbers.size(); i++) {
            for(int j = 0; j < userNumbers.size(); j++) {
                if(i == j && answerNumbers.get(i) == userNumbers.get(j)) {
                    strike++;
                    continue;
                }
                if(answerNumbers.get(i) == userNumbers.get(j)) {
                    ball++;
                }
            }
        }

        Score score = new Score();
        score.setStrike(strike);
        score.setBall(ball);
        return score;
    }

    public static void validateUserString(String string) {

        validateStringOnlyNumbers(string);
        validateStringLength(string, 3);
        validateStringDuplicate(string);
    }

    private static void validateStringOnlyNumbers(String string) {

        for (char c : string.toCharArray()) {
            if(!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만 입력해야 합니다.");
            }
        }
    }

    private static void validateStringLength(String string, int length) {

        if(string.length() != length) {
            throw new IllegalArgumentException(length + "개의 수를 입력해야 합니다.");
        }
    }

    private static void validateStringDuplicate(String string) {

        for(int i = 0; i < string.length(); i++) {
            for(int j = i + 1; j < string.length(); j++) {
                if(string.charAt(i) == string.charAt(j)) {
                    throw new IllegalArgumentException("중복된 수를 입력할 수 없습니다.");
                }
            }
        }
    }

    public static List<Integer> stringToIntegerList(String string) {

        List<Integer> integerList = new ArrayList<>();
        for(String s : string.split("")) {
            integerList.add(Integer.parseInt(s));
        }

        return integerList;
    }
}
