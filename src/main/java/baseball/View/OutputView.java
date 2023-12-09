package baseball.View;

import static baseball.Constants.*;
import static baseball.Model.Game.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class OutputView {
    public static void printResult(String result) {
        System.out.println(result);
    }

    public static int printRetry() {
        System.out.println(ALL_CORRECT + CORRECT_MESSAGE);
        System.out.println(RETRY_MESSAGE);

        return getNewGameAnswer(readLine());
    }
}
