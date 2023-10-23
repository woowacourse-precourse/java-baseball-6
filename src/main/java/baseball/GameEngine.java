package baseball;

import static baseball.NumberBaseballGameConfig.CONTINUE_GAME;
import static baseball.NumberBaseballGameConfig.STRIKE_COUNT_REQUIRED_TO_WIN;

import java.util.List;

public class GameEngine {

    private final InputReader inputReader;
    private final Announcer announcer;
    private final Referee referee;
    private final RandomNumberGenerator randomNumberGenerator;

    public GameEngine(InputReader inputReader,
                      Announcer announcer,
                      Referee referee,
                      RandomNumberGenerator randomNumberGenerator) {
        
        this.inputReader = inputReader;
        this.announcer = announcer;
        this.referee = referee;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void run() {
        announcer.announceGameStart();
        int continueMode = CONTINUE_GAME;

        while (continueMode == CONTINUE_GAME) {
            List<Integer> answer = randomNumberGenerator.generate();
            int strikeCount = 0;
            do {
                announcer.askToInput();
                List<Integer> guessedNumber = inputReader.readGuessedNumber();
                Score score = referee.judge(guessedNumber, answer);
                announcer.announceScore(score);
                strikeCount = score.getStrikeCount();
            } while (strikeCount != STRIKE_COUNT_REQUIRED_TO_WIN);

            announcer.announceWin();
            announcer.askContinue();
            continueMode = inputReader.readContinueModeNumber();

        }
    }
}
