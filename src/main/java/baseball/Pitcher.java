package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Pitcher extends Player {
    @Override
    public void setNumbers() throws IllegalArgumentException {
        String input = inputNumbers();

        if (isOverMaxLength(input)) {
            throw new IllegalArgumentException("최대 길이 " + Constant.MAX_NUMBER_SIZE + "를 넘어가는 입력입니다.");
        }
        else if (isInValidInput(input)) {
            throw new IllegalArgumentException("올바른 입력이 아닙니다. 정수를 입력해야합니다.");
        }

        int[] split = splitNumbers(input);
        if (isDuplicate(split)) {
            throw new IllegalArgumentException("입력한 숫자가 중복됩니다.");
        }
        updateNumbers(split);
    }

    public String inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public boolean isOverMaxLength(String input) {
        return input.length() > Constant.MAX_NUMBER_SIZE;
    }

    public boolean isInValidInput(String input) {
        try {
            Integer.parseInt(input);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public int[] splitNumbers(String number) throws IllegalArgumentException {
        return number.chars()
                .map(i -> i - '0')
                .toArray();
    }

    public boolean isDuplicate(int[] split) {
        return Arrays.stream(split).distinct().count() != split.length;
    }

    public void updateNumbers(int[] split) {
        numbers.clear();
        Arrays.stream(split).forEach(num -> numbers.add(num));
    }
}
