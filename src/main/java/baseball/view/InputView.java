package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static final String regex = "^[1-9]{3}$";
    private static final Pattern pattern = Pattern.compile(regex);

    public static List<Integer> takeInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String value = Console.readLine();
        Matcher matcher = pattern.matcher(value);
        if (!matcher.find()) {
            throw new IllegalArgumentException("올바른 입력이 아닙니다.");
        }
        List<Integer> ballNumbers = Arrays.stream(value.split("")).map(Integer::parseInt).collect(Collectors.toList());
        CheckDifferentNumbers(ballNumbers);
        return ballNumbers;
    }

    private static void CheckDifferentNumbers(List<Integer> ballNumbers) {
        Set<Integer> differentNumbers = new HashSet<>(ballNumbers);
        if (differentNumbers.size() != 3) {
            throw new IllegalArgumentException("서로 다른 3자리 수를 입력하세요.");
        }
    }
}