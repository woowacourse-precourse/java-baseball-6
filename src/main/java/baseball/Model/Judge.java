package baseball.Model;

import java.util.ArrayList;
import java.util.List;

public class Judge {
    private final Computer computer;
    private final User user;
    private final int BASEBALL_NUM_SIZE = 3;

    private Judge(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
    }

    public List<Integer> checkBallCount() {
        List<Integer> listBallStrike = new ArrayList<>();
        int totalCount = 0;
        int strikeCount = 0;
        int ballCount = 0;

        if (computer.getComputerNumber().size() != BASEBALL_NUM_SIZE) {
            throw new IllegalArgumentException("입력 자릿 수 오류");
        }

        for (int i = 0; i < BASEBALL_NUM_SIZE; i++) {
            if (computer.getComputerNumber().contains(computer.getComputerNumber().get(i))) {
                totalCount++;
            }
            if (user.getUserNumber().get(i) == computer.getComputerNumber().get(i)) {
                strikeCount++;
            }
        }
        ballCount = totalCount - strikeCount;
        listBallStrike.add(ballCount);
        listBallStrike.add(strikeCount);
        return listBallStrike;
    }

    public boolean isThreeStrike(int strikeCount) {
        if (strikeCount == BASEBALL_NUM_SIZE) {
            return true;
        }
        if (strikeCount != BASEBALL_NUM_SIZE) {
            return false;
        }
        throw new IllegalArgumentException("허가되지 않은 문자열");
    }
}
