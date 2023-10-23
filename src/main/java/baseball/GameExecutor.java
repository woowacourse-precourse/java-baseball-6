package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class GameExecutor {
    private BaseballGame game;
    private ConsoleInput consoleInput;
    private ConsoleLogger consoleLogger;

    public GameExecutor() {
        game = new BaseballGame(getRandomNumbers());
        consoleInput = new ConsoleInput();
        consoleLogger = new ConsoleLogger();
    }

    private int[] getRandomNumbers() {
        Set<Integer> result = new HashSet<>();

        while (result.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            result.add(number);
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public void run() {
        game.sayHello(consoleLogger);
        while (true) {
            game.run(consoleInput, consoleLogger);
            break;
        }
    }
}
