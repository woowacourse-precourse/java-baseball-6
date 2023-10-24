package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class GameExecutor {
    private BaseballGame game;
    private ConsoleInput consoleInput;
    private ConsoleLogger consoleLogger;
    private GameRandom random;

    public GameExecutor() {
        random = new MissionUtilsGameRandom();
        game = new BaseballGame(random.sampleDistinctNumbers(1, 9, 3));
        consoleInput = new ConsoleInput();
        consoleLogger = new ConsoleLogger();
    }


    public void run() {
        game.sayHello(consoleLogger);
        while (true) {
            game.run(consoleInput, consoleLogger);
            consoleLogger.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            String input = consoleInput.getInput();
            checkInput(input);
            if ("2".equals(input)) {
                break;
            }
            game = new BaseballGame(random.sampleDistinctNumbers(1, 9, 3));
        }
    }

    private void checkInput(String input) {
        if (Pattern.matches("[12]", input)) {
            return;
        }
        throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
    }
}
