package baseball.end;

import camp.nextstep.edu.missionutils.Console;

public class RestartChoice {
    private Integer restartChoice;

    public RestartChoice() {
        restartChoice = 0;
    }

    public Integer getRestartChoice() {
        return restartChoice;
    }

    public void readInputChoices() {
        if (restartChoice != 0) {
            restartChoice = 0;
        }
        String readLine = Console.readLine();
        if (readLine.equals("1") || readLine.equals("2")) {
            restartChoice = Integer.parseInt(readLine);
            return;
        }
        throw new IllegalArgumentException();
    }
}
