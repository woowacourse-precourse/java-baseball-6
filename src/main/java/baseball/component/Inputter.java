package baseball.component;

import java.util.*;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Console;

public class Inputter {

    private static Inputter inputter;

    private Inputter() {}

    public static Inputter getInputter() {
        if (inputter == null) {
            inputter = new Inputter();
        }
        return inputter;
    }

    public boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String sign = Console.readLine();
        switch (sign) {
            case "1" : return true;
            case "2" : return false;
            default  : throw new IllegalArgumentException();
        }
    }

    public List<Integer> input() {
        String input;

        System.out.print("숫자를 입력해주세요 : ");
        input = Console.readLine();
        return convertToDigit(input);
    }

    private List<Integer> convertToDigit(String s) {
        List<Integer> input;
        try {
            input = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).boxed()
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        validate(input);
        return input;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> validateSet = new HashSet<>(numbers);
        if (validateSet.size() != GeneralNumbers.NUMBER_SIZE.getCode()
                    || numbers.size() != GeneralNumbers.NUMBER_SIZE.getCode()) {
            throw new IllegalArgumentException();
        }
    }
}
