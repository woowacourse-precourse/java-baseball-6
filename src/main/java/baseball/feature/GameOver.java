package baseball.feature;

import camp.nextstep.edu.missionutils.Console;

public class GameOver {

    public boolean isGameOver() {
        String command = Console.readLine();
        return command.equals("1");
    }

}
