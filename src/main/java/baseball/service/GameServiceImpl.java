package baseball.service;

import baseball.domain.Referee;
import baseball.dto.HintDTO;
import java.util.List;

public class GameServiceImpl implements GameService {

    private static final String STRIKE_STATUS_MESSAGE = "스트라이크";
    private static final String BALL_STATUS_MESSAGE = "볼";
    private static final String NOTHING_STATUS_MESSAGE = "낫싱";
    private static final String WHITE_SPACE = " ";

    private final Referee referee;

    private static GameService INSTANCE;

    private GameServiceImpl(Referee referee) {
        this.referee = referee;
    }

    public static GameService getInstance(Referee referee) {
        if (INSTANCE == null) {
            INSTANCE = new GameServiceImpl(referee);
        }
        return INSTANCE;
    }

    @Override
    public HintDTO process(List<Integer> numbers, int[] inputNumbers) {
        return judge(numbers, inputNumbers);
    }

    private HintDTO judge(List<Integer> numbers, int[] inputNumbers) {
        referee.judge(numbers, inputNumbers);
        return buildHint();
    }

    private HintDTO buildHint() {
        HintDTO judge = referee.isNothing() ? buildNothing() : buildJudge();
        referee.clearCount();
        return judge;
    }

    private HintDTO buildNothing() {
        return new HintDTO(false, NOTHING_STATUS_MESSAGE);
    }

    private HintDTO buildJudge() {
        StringBuffer buffer = new StringBuffer();
        buffer = buildBallMsg(buffer);
        buffer = buildStrikeMsg(buffer);
        return new HintDTO(referee.isAllStrike(), buffer.toString());
    }

    private StringBuffer buildStrikeMsg(StringBuffer buffer) {
        int strikeCount = referee.getStrike();

        if (strikeCount != 0) {
            if (!buffer.isEmpty()) {
                buffer.append(WHITE_SPACE);
            }

            return buffer.append(strikeCount + STRIKE_STATUS_MESSAGE);
        }

        return buffer;
    }

    private StringBuffer buildBallMsg(StringBuffer buffer) {
        int ballCount = referee.getBall();

        if (ballCount != 0) {
            return buffer.append(ballCount + BALL_STATUS_MESSAGE);
        }

        return buffer;
    }

}
