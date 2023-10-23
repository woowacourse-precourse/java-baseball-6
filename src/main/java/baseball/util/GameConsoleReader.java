package baseball.util;

import camp.nextstep.edu.missionutils.Console;

public class GameConsoleReader implements GameConsole {
        @Override
        public String readInput() {
                return Console.readLine();
        }
}
