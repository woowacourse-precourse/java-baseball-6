package baseball.view;

import static baseball.constant.SystemMessage.GAME_END;
import static baseball.constant.SystemMessage.GAME_RESTART;
import static baseball.constant.SystemMessage.TYPE_NUMBER;
import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.Hint;

public class ViewService {

    public void printReadMessage() {
        System.out.print(TYPE_NUMBER.getMessage());
    }

    public String readNumber() {
        return readLine();
    }

    public void printHintMessage(Hint hint) {
        System.out.println(hint.toString());

        if (hint.isThreeStrike()) {
            printGameEndMessage();
        }
    }

    private void printGameEndMessage() {
        System.out.println(GAME_END.getMessage());
        printRestartMessage();
    }

    public void printRestartMessage() {
        System.out.println(GAME_RESTART.getMessage());
    }
}