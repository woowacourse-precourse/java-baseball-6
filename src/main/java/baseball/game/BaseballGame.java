package baseball.game;

import static baseball.game.GameMessageType.*;
import static baseball.modules.score.BaseBallScoreType.*;

import baseball.modules.player.Computer;
import baseball.modules.player.Human;
import baseball.modules.player.Player;
import baseball.modules.score.BaseballScore;
import baseball.modules.score.Score;
import baseball.modules.score.ScoreType;
import baseball.utils.NumberUtils;
import baseball.utils.StringUtils;
import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

public class BaseballGame implements Game {

    @Override
    public void start() {
        try {
            boolean isContinue = true;
            System.out.println(START.getMessage());

            while (isContinue) {
                this.run();
                isContinue = this.askContinue();
            }

        } catch (IllegalStateException illegalStateException) {
            throw new IllegalArgumentException();
        } finally {
            Console.close();
        }
    }

    private void run() {
        final Player computer = new Computer();

        while (true) {
            System.out.print(INPUT_REQUEST.getMessage());
            final Score score = new BaseballScore().calculate(computer, new Human(getUserInput()));

            System.out.println(this.createOutputResult(score));
            if (score.getScore().get(STRIKE) == 3) {
                System.out.println(SUCCESS.getMessage() + END.getMessage());
                break;
            }
        }
    }

    private boolean askContinue() {
        System.out.println(RESTART_REQUEST.getMessage());
        final String isContinue = getUserInput();
        validateContinueInput(isContinue);

        return "1".equals(isContinue);
    }

    private void validateContinueInput(final String isContinue) {
        if (!StringUtils.isLengthEqual(isContinue, 1)) {
            throw new IllegalArgumentException();
        }

        if (!StringUtils.isNumeric(isContinue)) {
            throw new IllegalArgumentException();
        }

        if (!NumberUtils.isWithInRange(Integer.parseInt(isContinue), 1, 2)) {
            throw new IllegalArgumentException();
        }
    }

    private StringBuilder createOutputResult(final Score score) {
        final Map<? extends ScoreType, Integer> scoreInfos = score.getScore();
        StringBuilder result = new StringBuilder();

        if (scoreInfos.values().stream().mapToInt(Integer::intValue).sum() == 0) {
            return new StringBuilder("낫싱");
        }
        final Integer ball = scoreInfos.get(BALL);
        if (ball != 0) {
            result.append(ball).append(BALL.getScoreValue()).append(" ");
        }

        final Integer strike = scoreInfos.get(STRIKE);
        if (strike != 0) {
            result.append(strike).append(STRIKE.getScoreValue());
        }

        return result;
    }
    private String getUserInput() {
        return Console.readLine();
    }
}
