package baseball;

import baseball.view.format.Format;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Process {

    private List<Hint> hintLog;
    private Ball ball;
    private int size;
    private Map<String, Format> formatMap;

    public Process(int size) {
        this.size = size;
        createRandomBalls(size);
    }

    private void loadFormats() {
        formatMap = new HashMap<>();
    }

    public Format getFormat(String formatName) {
        return formatMap.get(formatName);
    }

    public void createRandomBalls(int size) {
        List<Integer> randomBalls = new ArrayList<>();
        while (randomBalls.size() < size) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!randomBalls.contains(number)) {
                randomBalls.add(number);
            }
        }

        ball = new Ball(randomBalls);
    }

    public boolean isCorrectBall(String userBalls) {
        Hint currentHint = ball.makeHint(userBalls);
        hintLog.add(currentHint);

        if (currentHint.isStrike(size)) {
            return false;
        }
        return true;
    }
}
