package baseball;

import camp.nextstep.edu.missionutils.Console;

public class ContinueNumber {

    public int getContinueNumber() {
        int stop = 0;
        return stop;
    }

    private String getReadLine() {
        return Console.readLine();
    }

    private void checkLength(String word) {
        if (word.length() != 1) {
            throw new IllegalArgumentException("입력한 수가 1자리가 아닙니다.");
        }
    }
}
