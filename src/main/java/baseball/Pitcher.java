package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Pitcher extends Player {
    @Override
    public void setNumbers() throws IllegalArgumentException {
        String input = inputNumbers();

        Util.handleException(input);

        int[] split = Util.stringToIntArray(input);
        updateNumbers(split);
    }

    public String inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public void updateNumbers(int[] split) {
        clearNumbers();
        Arrays.stream(split).forEach(num -> numbers.add(num));
    }
}