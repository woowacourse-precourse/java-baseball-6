package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static baseball.GameStatus.*;

public class Baseball {
    private final List<Integer> computerRandomNumbers;
    private final Input input;

    Baseball() {
        computerRandomNumbers = new ArrayList<>();
        input = new Input();
        System.out.println("숫자 야구 게임을 시작합니다");
    }

    public void runGame() {
        computerRandomNumbers.clear();
        computerRandomNumbers.addAll(generateRandomNumber());

        while (true) {
            System.out.print("숫자를 입력해주세요: ");
            List<Integer> userInput = input.checkValidate().toList();
            if (isNumberMatched(computerRandomNumbers, userInput)) {
                break;
            }
        }
    }

    public Boolean restart() {
        return Console.readLine().equals("2");
    }

    private List<Integer> generateRandomNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    private Boolean isNumberMatched(List<Integer> computer, List<Integer> user) {
        HashMap<GameStatus, Integer> result = new HashMap<>();
        result.put(STRIKE, 0);
        result.put(BALL, 0);
        result.put(MISS, 0);

        for (int i = 0; i < user.size(); i++) {
            if (computer.get(i) == user.get(i)) {
                result.compute(STRIKE, (gameStatus, count) -> {
                    if(count == null) {
                        return 0;
                    }
                    return count + 1;
                });
                continue;
            }
            if (computer.contains(user.get(i))) {
                result.compute(BALL, (gameStatus, count) -> {
                    if(count == null) {
                        return 0;
                    }
                    return count + 1;
                });
                continue;
            }
            result.compute(MISS, (gameStatus, count) -> {
                if(count == null) {
                    return 0;
                }
                return count + 1;
            });
        }
        return analyzeResult(result);
    }


    private Boolean analyzeResult(HashMap<GameStatus, Integer> result) {
        if (result.get(MISS) == 3) {
            System.out.printf("낫싱");
        }
        if (result.get(BALL) > 0) {
            System.out.printf("%d볼 ", result.get(BALL));
        }
        if (result.get(STRIKE) == 0) {
            System.out.printf("\n");
            return false;
        }
        System.out.printf("%d스트라이크\n", result.get(STRIKE));
        return isCorrect(result.get(STRIKE));
    }

    private Boolean isCorrect(int strike) {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        }
        return false;
    }
}
