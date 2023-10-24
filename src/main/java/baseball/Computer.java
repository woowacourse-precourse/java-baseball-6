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
        int strike = 0;
        int ball = 0;

        // TODO : Refactoring
        for (int i = 0; i < answer.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                if (answer.get(i).intValue() == numbers.get(j).intValue()) {
                    if (i == j) {
                        strike += 1;
                        continue;
                    }

                    ball += 1;
                }
            }
        }

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return false;
        }

        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }

        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }

        System.out.println();

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }

}
