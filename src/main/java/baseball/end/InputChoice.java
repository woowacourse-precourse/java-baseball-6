package baseball.end;

import camp.nextstep.edu.missionutils.Console;

public class InputChoice {
    private Integer inputChoice;

    public InputChoice() {
        inputChoice = 0;
    }

    public Integer getInputChoice() {
        return inputChoice;
    }

    public void readInputChoices() {
        if (inputChoice != 0) {
            inputChoice = 0;
        }
        String readLine = Console.readLine();
        if (readLine.equals("1") || readLine.equals("2")) {
            inputChoice = Integer.parseInt(readLine);
            return;
        }
        throw new IllegalArgumentException();
    }
}
