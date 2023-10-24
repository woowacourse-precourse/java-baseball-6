package baseball;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput implements GameInputInterface {
    @Override
    public String getInput(){
        return Console.readLine();
    }

}
