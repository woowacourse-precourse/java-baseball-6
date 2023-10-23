package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
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
        return ballNumbers;
    }
}