package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> numbers;

    public Computer() {
        numbers = new ArrayList<>();
    }

    public void generateAnswer() {
        numbers.clear();

        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public boolean isCorrect(List<Integer> answer) {
        Integer containCount = countElement(answer);
        Integer strikeCount = countStrike(answer);
        Integer ballCount = containCount - strikeCount;

        if (strikeCount == 3) {
            System.out.println(strikeCount + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        printResult(strikeCount, ballCount);

        return false;
    }

    private Integer countElement(List<Integer> answer) {
        int count = 0;

        for (int i = 0; i < answer.size(); i++) {
            if (numbers.contains(answer.get(i))) {
                count += 1;
            }
        }

        return count;
    }

    private Integer countStrike(List<Integer> answer) {
        int count = 0;

        for (int i = 0; i < answer.size(); i++) {
            if (numbers.get(i).equals(answer.get(i))) {
                count += 1;
            }
        }

        return count;
    }

    private void printResult(Integer strike, Integer ball) {
        StringBuilder stringBuilder = new StringBuilder();

        if (strike == 0 && ball == 0) {
            stringBuilder.append("낫싱");
            System.out.println(stringBuilder);
            return;
        }

        if (ball > 0) {
            stringBuilder.append(ball).append("볼 ");
        }

        if (strike > 0) {
            stringBuilder.append(strike).append("스트라이크");
        }

        System.out.println(stringBuilder);
    }
}
