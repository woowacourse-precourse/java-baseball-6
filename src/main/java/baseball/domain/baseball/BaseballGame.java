package baseball.domain.baseball;

import baseball.domain.util.Output;
import baseball.domain.interfaces.baseball.Game;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static baseball.domain.baseball.BaseballConst.*;

public class BaseballGame implements Game {

    private final BaseballUser user;

    public BaseballGame() {
        this.user = new BaseballUser();
    }

    public void start() {
        Output.printMessageWithLine(GAME_START_MESSAGE);
        while (true) {

            takeTurn();
            int command = getCommand();
            boolean isGameContinue = (command == RESTART_COMMAND);

            if (!isGameContinue) {
                break;
            }
        }
    }

    private void takeTurn() {
        BaseballPick answer = new BaseballPick(createNumbers());
        while (true) {
            Output.printMessage(GAME_NUMBER_INPUT_MESSAGE);
            user.pickNumber();
            BaseballResult result = answer.match(user.getNumber());

            result.printResult();

            if (result.isEnd()) {
                break;
            }
        }
    }

    private List<Integer> createNumbers() {
        List<Integer> answer = new ArrayList<>();
        Set<Integer> numbers = new HashSet<>();
        while (answer.size() < NUMBER_SIZE) {
            int number = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if (numbers.contains(number)) continue;
            answer.add(number);
            numbers.add(number);
        }
        return answer;
    }

    private int getCommand() {
        Output.printMessageWithLine(GAME_RESTART_MESSAGE);
        String input = Console.readLine();
        BaseballValidator.validateCommand(input);

        return Integer.parseInt(input);
    }

}
