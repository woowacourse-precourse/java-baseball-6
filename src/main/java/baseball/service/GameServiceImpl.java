package baseball.service;

import baseball.dto.JudgeDTO;
import java.util.List;

public class GameServiceImpl implements GameService {

    private static final String STRIKE_STATUS_MESSAGE = "스트라이크";
    private static final String BALL_STATUS_MESSAGE = "볼 ";
    private static final String NOTHING_STATUS_MESSAGE = "낫싱";

    private static final int CAPACITY = 3;
    private static final int STRIKE = 0;
    private static final int BALL = 1;
    private static final int NOTHING = 2;

    private static final GameService INSTANCE = new GameServiceImpl();

    private GameServiceImpl() {
    }

    public static GameService getInstance() {
        return INSTANCE;
    }

    @Override
    public JudgeDTO process(List<Integer> numbers, int[] inputNumbers) {
        boolean flag = false;
        return judge(numbers, inputNumbers, flag);
    }

    private JudgeDTO judge(List<Integer> numbers, int[] inputNumbers, boolean flag) {
        int[] referee = new int[CAPACITY];
        checkStatus(numbers, inputNumbers, referee);
        return buildStatusAndMessage(referee, flag);
    }

    private void checkStatus(List<Integer> numbers, int[] inputNumbers, int[] referee) {
        for (int i = 0; i < numbers.size(); i++) {
            int currentTarget = inputNumbers[i];
            if (numbers.get(i) == currentTarget) {
                referee[STRIKE]++;
            } else {
                if (numbers.contains(currentTarget)) {
                    referee[BALL]++;
                } else {
                    referee[NOTHING]++;
                }
            }
        }
    }

    private JudgeDTO buildStatusAndMessage(int[] referee, boolean flag) {
        StringBuilder builder = new StringBuilder();
        if (referee[NOTHING] == CAPACITY) {
            builder.append(NOTHING_STATUS_MESSAGE);
        } else {
            if (referee[BALL] != 0) {
                builder.append(referee[BALL] + BALL_STATUS_MESSAGE);
            }

            if (referee[STRIKE] != 0) {
                builder.append(referee[STRIKE] + STRIKE_STATUS_MESSAGE);
                flag = allStrikeCheck(referee);
            }
        }

        return new JudgeDTO(flag, builder.toString());
    }

    private boolean allStrikeCheck(int[] referee) {
        if (referee[STRIKE] == CAPACITY) {
            return true;
        }
        return false;
    }

}
