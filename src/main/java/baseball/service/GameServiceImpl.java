package baseball.service;

import baseball.view.View;

import java.util.List;

public class GameServiceImpl implements GamsService {

    private static final String STRIKE_STATUS_MESSAGE = "스트라이크";
    private static final String BALL_STATUS_MESSAGE = "볼 ";
    private static final String NOTHING_STATUS_MESSAGE = "낫싱";

    private static final int CAPACITY = 3;
    private static final int STRIKE = 0;
    private static final int BALL = 1;
    private static final int NOTHING = 2;

    // idx 0 => 스트라이크, idx 1 => 볼, idx 2 => 아예 빗나감
    private int[] referee;
    private boolean flag;

    @Override
    public boolean process(List<Integer> numbers, int[] inputNumbers) {
        flag = false;
        judge(numbers, inputNumbers);
        return flag;
    }

    private void judge(List<Integer> numbers, int[] inputNumbers) {
        referee = new int[CAPACITY];
        checkStatus(numbers, inputNumbers);
        buildStatusMessage();
    }

    private void checkStatus(List<Integer> numbers, int[] inputNumbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int currentTarget = inputNumbers[i];
            if (numbers.get(i) == currentTarget) {
                referee[STRIKE]++;
            } else {
                if (numbers.contains(currentTarget)) referee[BALL]++;
                else referee[NOTHING]++;
            }
        }
    }

    private void buildStatusMessage() {
        StringBuilder builder = new StringBuilder();
        if (referee[NOTHING] == CAPACITY) View.printMessage(NOTHING_STATUS_MESSAGE);
        else {
            if (referee[BALL] != 0)
                builder.append(referee[BALL] + BALL_STATUS_MESSAGE);

            if (referee[STRIKE] != 0) {
                builder.append(referee[STRIKE] + STRIKE_STATUS_MESSAGE);
                allStrikeCheck();
            }
        }
        View.printMessage(builder.toString());
    }

    private void allStrikeCheck() {
        if (referee[STRIKE] == CAPACITY) {
            flag = true;
        }
    }

}
