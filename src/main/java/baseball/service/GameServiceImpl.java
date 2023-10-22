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
        return build();
    }

    private HintDTO build() {
        HintDTO judge = referee.isNothing() ? buildNothing() : buildJudge();
        referee.clearCount();
        return judge;
    }

    private HintDTO buildNothing() {
        return new HintDTO(false, NOTHING_STATUS_MESSAGE);
    }

    private HintDTO buildJudge() {
        String ballMessage = buildBallMsg();
        String strikeMessage = buildStrikeMsg();
        if (strikeMessage != "") {
            ballMessage += WHITE_SPACE;
        }
        return new HintDTO(referee.isAllStrike(), ballMessage + strikeMessage);
    }

    private String buildStrikeMsg() {
        return referee.getStrike() != 0 ? referee.getStrike() + STRIKE_STATUS_MESSAGE : "";
    }

    private String buildBallMsg() {
        return referee.getBall() != 0 ? referee.getBall() + BALL_STATUS_MESSAGE : "";
    }

}
