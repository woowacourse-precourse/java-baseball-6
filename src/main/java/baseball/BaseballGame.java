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
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = readLine();
            List<Integer> userInputAsIntArray = validator.validateAndGetIntArray(userInput);
            found = comparator.compare(randomNumbers, userInputAsIntArray);

            if (found) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                exit();
            }
        }
        if (found) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int userInput = Integer.parseInt(readLine());
            if (userInput == 2) return;
            run();
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
