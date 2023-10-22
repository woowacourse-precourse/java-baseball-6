package input;

import baseball.GameStatus;
import baseball.Number;
import camp.nextstep.edu.missionutils.Console;

public class Input {

    public Number askUserNumber() {
        return Number.from(Console.readLine());
    }

    public GameStatus askGameOver() {
        return GameStatus.from(Console.readLine());
    }
}
