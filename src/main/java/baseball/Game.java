package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Input input;
    private Judge judge;
    private Output output;

    private List<Integer> computer;

    public void run() {

    }

    private void init() {
        computer = getComputer();
        input = new Input();
        judge = new Judge(computer, input);
        output = new Output(judge);
    }

    private List<Integer> getComputer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
