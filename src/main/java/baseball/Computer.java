package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer {
    private static final int START_NUM = 1;
    private static final int END_NUM = 9;
    private final Map<Integer, Integer> numbers;

    public Computer() {
        numbers = new HashMap<>();
    }

    public static Computer init() {
        return new Computer();
    }

    public void start() {
        numbers.clear();
        generateRandomNumbers();
    }

    private void generateRandomNumbers() {
        int count = 0;
        while (count < 3) {
            int randomNumber = Randoms.pickNumberInRange(START_NUM, END_NUM);
            if (numbers.containsKey(randomNumber)) {
                continue;
            }
            numbers.put(randomNumber, count);
            count++;
        }
    }

    public boolean canPlayContinue(User user) {
        List<Integer> userNumbers = user.getNumbers();
        Result result = new Result();
        for (int i = 0; i < userNumbers.size(); i++) {
            int number = userNumbers.get(i);
            addResult(number, i, result);
        }
        printResult(result);
        return result.getStrike() != 3;
    }

    private void addResult(int number, int i, Result result) {
        if (numbers.containsKey(number)) {
            int index = numbers.get(number);
            if (canAddStrike(index, i)) {
                result.addStrike();
                return;
            }
            result.addBall();
        }
    }

    private boolean canAddStrike(int index, int i) {
        return index == i;
    }

    private void printResult(Result result) {
        StringBuilder sb = new StringBuilder();
        if (result.isNoting()) {
            sb.append("낫싱");
        }
        if (result.isNotZeroBall()) {
            sb.append(result.getBall()).append("볼 ");
        }
        if (result.isNotZeroStrike()) {
            sb.append(result.getStrike()).append("스트라이크");
        }
        System.out.println(sb.toString().trim());
    }
}
