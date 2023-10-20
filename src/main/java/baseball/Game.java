package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static baseball.Const.*;

public class Game {

    private static final Game instance = new Game();
    private final User user;

    private Game() {
        this.user = new User();
    }

    public static Game getInstance() {
        return instance;
    }

    public void start() {
        Output.printMessageWithLine(GAME_START_MESSAGE);
        while (true) {

            GameNumber answer = new GameNumber(createNumbers());
            while (true) {
                Output.printMessage(GAME_NUMBER_INPUT_MESSAGE);
                user.pickNumber();
                Result result = answer.match(user.getNumber());
                result.printResult();
                if (result.isEnd()) break;
            }
            if (!isGameContinued()) break;
        }
    }

    private List<Integer> createNumbers() {
        List<Integer> answer = new ArrayList<>();
        Set<Integer> numbers = new HashSet<>();
        while (answer.size() < 3) {
            int number = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if (numbers.contains(number)) continue;
            answer.add(number);
            numbers.add(number);
        }
        return answer;
    }

    private boolean isGameContinued() {
        Output.printMessageWithLine(GAME_RESTART_MESSAGE);

        int command = Integer.parseInt(Console.readLine());
        Validator.validateCommand(command);

        return command == 1;
    }


}
