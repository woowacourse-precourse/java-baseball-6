package baseball.service;

import baseball.view.Message;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballService {


    public static int countStrikes(List<Integer> computerNumber, List<Integer> guess_Num) {
        int strikes = 0;
        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.get(i) == guess_Num.get(i)) {
                strikes++;
            }
        }

        return strikes;
    }

    public static int countBalls(List<Integer> computerNumber, List<Integer> guess_Num) {
        int balls = 0;
        for (int i = 0; i < computerNumber.size(); i++) {
            int targetDigit = guess_Num.get(i);
            if (targetDigit != computerNumber.get(i) && computerNumber.contains(targetDigit)) {
                balls++;
            }
        }
        return balls;
    }

    public static List<Integer> changeStrToList(String input) {
        List<Integer> resultList = Arrays.stream(input.split("")).map(str -> {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                // 숫자로 변환 불가능 할 때, 예외 던지기
                throw new IllegalArgumentException(Message.ONLY_NUM);
            }
        }).collect(Collectors.toList());
        return resultList;
    }
}
