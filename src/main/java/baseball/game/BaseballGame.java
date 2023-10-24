package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballGame {

    private static final int NUM_DIGIT = 3;

    private List<Integer> computer;
    private List<Integer> user;

    public void run() {

    }

    public void createComputerNumber() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public int countStrike() {
        int cnt = 0;
        for (int i = 0; i < NUM_DIGIT; i++) {
            if (computer.get(i).equals(user.get(i))) {
                cnt++;
            }
        }
        return cnt;
    }

    public int countBall() {
        int cnt = 0;
        for (int i = 0; i < NUM_DIGIT; i++) {
            int number = user.get(i);
            if (!computer.get(i).equals(number) && computer.contains(number)) {
                cnt++;
            }
        }
        return cnt;
    }

    protected void setComputer(String computer) {
        this.computer = Arrays.stream(computer.split(""))
                .map(Integer::valueOf)
                .toList();
    }

    protected void setUser(String user) {
        this.user = Arrays.stream(user.split(""))
                .map(Integer::valueOf)
                .toList();
    }
}
