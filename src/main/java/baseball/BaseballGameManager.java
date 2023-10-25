package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BaseballGameManager {
    private static BaseballGameManager baseballGameManager;
    private List<Integer> computerNumber = new ArrayList<>();
    private List<Integer> userNumber = new ArrayList<>();
    private Integer userInput;
    private Map<String, Integer> baseballResult = new HashMap<>();
    private AtomicInteger strikeCount = new AtomicInteger(0);
    private AtomicInteger ballCount = new AtomicInteger(0);

    private BaseballGameManager() {}

    public static BaseballGameManager getInstance() {
        if(baseballGameManager == null) {
            baseballGameManager = new BaseballGameManager();
        }
        return baseballGameManager;
    }

    public void run() {
        generateRandomNumber();

        while(true) {
            getUserInput();
            getBaseBallResult();
            printResult();
            if(isCorrect()) break;
        }
    }

    private void generateRandomNumber() {
        computerNumber.clear();

        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    private void getUserInput() {
        userNumber.clear();
        System.out.print("숫자를 입력해주세요 : ");

        userInput = Integer.valueOf(Console.readLine());
    }

    private void getBaseBallResult() {
        strikeCount.set(0);
        ballCount.set(0);

        userNumber.stream()
                .filter(userInputDigit -> computerNumber.contains(userInputDigit))
                .forEach(userInputDigit -> {
                    if (computerNumber.indexOf(userInputDigit) == userNumber.indexOf(userInputDigit)) {
                        strikeCount.getAndIncrement();
                    } else {
                        ballCount.getAndIncrement();
                    }
                });

        baseballResult = Map.of(
                "볼", ballCount.get(),
                "스트라이크", strikeCount.get()
        );
    }

    private void printResult() {
        Integer ballCountResult = baseballResult.get("볼");
        Integer strikeCountResult = baseballResult.get("스트라이크");

        if (ballCountResult == 0 && strikeCountResult == 0) {
            System.out.print("낫싱");
        }
        else {
            if (ballCountResult > 0) System.out.print(ballCountResult + "볼 ");
            if (strikeCountResult > 0) System.out.print(strikeCountResult + "스트라이크");
        }
        System.out.println();
    }

    private Boolean isCorrect() {
        if (baseballResult.get("스트라이크") == 3) return true;
        return false;
    }
}