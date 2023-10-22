package baseball;

import java.util.List;

import static baseball.NumberBaseballGameConfig.CONTINUE_GAME;
import static baseball.NumberBaseballGameConfig.STRIKE_COUNT_REQUIRED_TO_WIN;

public class GameEngine {

    private static InputReader inputReader = new InputReader();

    public static void run() {
        Announcer.announceGameStart();
        int continueMode = CONTINUE_GAME;

        while (continueMode == CONTINUE_GAME) {
            List<Integer> answer = RandomNumberGenerator.generate();
            int strikeCount = 0;
            do {
                Announcer.askToInput();
                List<Integer> userGuessNumber = inputReader.readUserGuessNumber();
                Score score = Referee.judge(userGuessNumber, answer);
                Announcer.annouceScore(score);
                strikeCount = score.getStrikeCount();
            } while (strikeCount != STRIKE_COUNT_REQUIRED_TO_WIN);

            Announcer.announceWin();
            Announcer.askContinue();
            continueMode = inputReader.readContinueMode();

        }
    }
}
