package baseball.game.hitter;

import baseball.game.util.IllegalArgumentCheck;
import camp.nextstep.edu.missionutils.Console;

public class PlayerHitterImpl implements Hitter {
    IllegalArgumentCheck illegalArgumentCheck = new IllegalArgumentCheck();
    @Override
    public String swing() {
        String inputBat = "";
        int bat = 0;
        inputBat = Console.readLine();
        illegalArgumentCheck.checkArgument(inputBat);
        return inputBat;
    }
}
