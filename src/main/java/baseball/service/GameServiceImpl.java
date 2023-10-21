package baseball.service;

import baseball.domain.Referee;
import baseball.dto.JudgeDTO;
import java.util.List;

public class GameServiceImpl implements GameService {

    private static final String STRIKE_STATUS_MESSAGE = "스트라이크";
    private static final String BALL_STATUS_MESSAGE = "볼 ";
    private static final String NOTHING_STATUS_MESSAGE = "낫싱";

    private static final int CAPACITY = 3;

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
    public JudgeDTO process(List<Integer> numbers, int[] inputNumbers) {
        return judge(numbers, inputNumbers);
    }

    private JudgeDTO judge(List<Integer> numbers, int[] inputNumbers) {
        referee.judge(numbers, inputNumbers);
        return build();
    }

    private JudgeDTO build() {
        JudgeDTO judge = referee.getMiss() == CAPACITY ? buildNothing() : buildJudge();
        referee.clearCount();
        return judge;
    }

    private JudgeDTO buildNothing() {
        return new JudgeDTO(false, NOTHING_STATUS_MESSAGE);
    }

    private JudgeDTO buildJudge() {
        return new JudgeDTO(referee.isAllStrike(), buildBallMsg() + buildStrikeMsg());
    }

    private String buildStrikeMsg() {
        return referee.getStrike() != 0 ? referee.getStrike() + STRIKE_STATUS_MESSAGE : "";
    }

    private String buildBallMsg() {
        return referee.getBall() != 0 ? referee.getBall() + BALL_STATUS_MESSAGE : "";
    }

}
