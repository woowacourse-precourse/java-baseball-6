package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameManager {
    private static BaseballGameManager baseballGameManager;
    private List<Integer> computerNumber = new ArrayList<>();
    private List<Integer> userNumber = new ArrayList<>();
    private Integer userInput;

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
}