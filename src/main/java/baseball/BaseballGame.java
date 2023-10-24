package baseball;

import java.util.HashMap;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class BaseballGame {
    private boolean isThreeStrikes;

    private final Map<Integer, Integer> randomNumbers = new HashMap<>();
    private final Validator validator = new Validator();
    private final Comparator comparator = new Comparator();

    public BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void run() {
        init();
        while (!isThreeStrikes) {
            String userInput = getThreeNumbersFromUser();
            Map<Integer, Integer> guessedNumbers = validator.validateAndParseGuessedNumbers(userInput);
            isThreeStrikes = comparator.checkThreeStrikeAndPrintResult(randomNumbers, guessedNumbers);
        }
        askRerunOrExit();
    }

    private void init() {
        generateRandomNumbers();
        this.isThreeStrikes = false;
    }

    private static String getThreeNumbersFromUser() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    private void askRerunOrExit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        String userInput = getNextCommandFromUser();
        int nextCommand = validator.validateAndParseNextCommand(userInput);
        if (nextCommand == 2) {
            return;
        }
        run();
    }

    private String getNextCommandFromUser() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return readLine();
    }

    private void generateRandomNumbers() {
        int index = 0;
        int digitLimit = 3;

        if (!randomNumbers.isEmpty()) randomNumbers.clear();
        while (index < digitLimit) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!randomNumbers.containsKey(randomNumber)) {
                randomNumbers.put(randomNumber, index++);
            }
        }

    }
}
