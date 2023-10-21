package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputChoice extends Input {
    private Integer inputChoice;

    public Integer getInputChoice() {
        return inputChoice;
    }

    @Override
    public void readInput() {
        String readLine = Console.readLine();
        if (readLine.equals("1") || readLine.equals("2")) {
            inputChoice = Integer.parseInt(readLine);
            return;
        }
        throwIllegalArgumentException();
    }
}
