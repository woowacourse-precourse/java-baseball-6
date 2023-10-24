package baseball;

import camp.nextstep.edu.missionutils.Console;
import game.GameInputInterface;

public class ConsoleInput implements GameInputInterface {
    @Override
    public String getInput(){
        return Console.readLine();
    }

}
