package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberBaseballUtility {
    public static List<Integer> generateAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNum)) {
                answer.add(randomNum);
            }
        }
        return answer;
    }

    public static boolean isUniqueThreeDigitNumber(String input) {
        if (input.length() != 3) {
            return false;
        }
        Set<Character> seen = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9') {
                return false;
            }
            if (seen.contains(c)) {
                return false;
            }
            seen.add(c);
        }
        return true;
    }

    public static List<Integer> convertStringToNumberList(String input) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            list.add(Character.getNumericValue(input.charAt(i)));
        }
        return list;
    }

    public static int calculateStrike(List<Integer> answer, List<Integer> player) {
        int strike = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).equals(player.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public static int calculateBall(List<Integer> answer, List<Integer> player) {
        int ball = 0;
        for (int i : player) {
            if (answer.contains(i)) {
                ball++;
            }
        }
        return ball;
    }

    public static boolean isValidChoice(String input) {
        return (input.equals("1") || input.equals("2"));
    }
}
