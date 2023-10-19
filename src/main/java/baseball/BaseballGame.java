package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class BaseballGame {
    private boolean running;
    private boolean found;
    private List<Integer> randomNumbers = new ArrayList<>();
    private Validator validator = new Validator();
    private Comparator comparator = new Comparator();
    private final int DIGIT = 3;

    private void init() {
        generateRandomNumbers();
        this.running = true;
        this.found = false;
    }

    public BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void run() {
        init();
        while (running) {
            System.out.println("It starts running.");
            exit();
        }
    }

    private void generateRandomNumbers() {
        if (!randomNumbers.isEmpty()) randomNumbers.clear();
        while (randomNumbers.size() < DIGIT) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
    }

    public void exit() {
        this.running = false;
    }
}
