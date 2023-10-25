package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Referee referee = new Referee();
    private final List<Integer> computer = new ArrayList<>();

    public Game() {
        createRandomNumber();
    }

    private void createRandomNumber() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public boolean play(List<Integer> number) {
        return referee.judge(computer, number);
    }

    public List<Integer> getComputer() {
        return computer;
    }
}
