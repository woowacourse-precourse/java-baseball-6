package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class BaseballGame {
    private boolean running;
    private boolean isThreeStrike;

    private final Map<Integer, Integer> randomNumbers = new HashMap<>();
    private final Validator validator = new Validator();
    private final Comparator comparator = new Comparator();

    private final int DIGIT = 3;

    private void init() {
        generateRandomNumbers();
        this.running = true;
    }

    public BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void run() {
        init();
        while (running) {
            String userInput = getUserInput();
            Map<Integer, Integer> guessedNumbers = validator.validateAndParseGuessedNumbers(userInput);
            isThreeStrike = comparator.compare(randomNumbers, guessedNumbers);
            checkThreeStrike();
        }
        askRerunOrExit();
    }

    private static String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    private void checkThreeStrike() {
        if (isThreeStrike) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            exit();
        }
    }

    private void askRerunOrExit() {
        if (isThreeStrike) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int userInput = Integer.parseInt(readLine());
            if (userInput == 2) return;
            run();
        }
    }

    private void generateRandomNumbers() {
        int index = 0;

        if (!randomNumbers.isEmpty()) randomNumbers.clear();
        while (index < DIGIT) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!randomNumbers.containsKey(randomNumber)) {
                randomNumbers.put(randomNumber, index++);
            }
        }
    }

    public void exit() {
        this.running = false;
    }
}
