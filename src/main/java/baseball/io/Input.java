package baseball.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String getInputNumbers() {
        String inputNumbers = Console.readLine();
        if (inputNumbers.length() != 3 || inputNumbers.contains("0")) {
            throw new IllegalArgumentException("1부터 9까지의 숫자로 이루어진 3자리 숫자를 입력해야 합니다.");
        }
        return inputNumbers;
    }

    public int getKeepPlaying() {
        int inputNumber = Integer.parseInt(Console.readLine());
        if (inputNumber != 1 && inputNumber != 2) {
            throw new IllegalArgumentException("올바른 입력 값이 아닙니다.");
        }
        return inputNumber;
    }
}
