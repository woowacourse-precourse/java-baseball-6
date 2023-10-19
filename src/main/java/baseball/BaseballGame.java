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

    public void exit() {
        this.running = false;
        System.out.println("숫자 야구 게임을 종료합니다.");
    }
}
