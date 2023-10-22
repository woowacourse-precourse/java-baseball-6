package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Input {

    public int[] readGuessNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return toIntArray(Console.readLine());
    }
    public int[] toIntArray(String input) {
        input = input.replaceAll("\\s", "");

        if (!input.matches("[1-9]+"))
            throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.");

        if (input.length() != 3)
            throw new IllegalArgumentException("3자리의 숫자가 아닙니다.");

        int[] result = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .distinct()
                .toArray();

        if (result.length != 3) {
            throw new IllegalArgumentException("서로 다른 숫자 3개를 입력해야됩니다. ");
        }

        return result;
    }

}
