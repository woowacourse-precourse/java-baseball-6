package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Game {

    private static final int SIZE = 3;

    // 컴퓨터가 3개의 랜덤한 수를 뽑는 메서드
    public List<Integer> generateComputersNumber() {
        Set<Integer> computer = new HashSet<>();
        while (computer.size() < SIZE) {
            computer.add(Randoms.pickNumberInRange(1, 9));
        }

        return new ArrayList<>(computer);
    }

    public List<Integer> calculateResult(List<Integer> userInput, List<Integer> computer) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (computer.contains(userInput.get(i))) {
                if (userInput.get(i) == computer.get(i)) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }
        List<Integer> result = new ArrayList<>();

        result.add(ball);
        result.add(strike);

        return result;
    }

    public boolean retryHandler(Scanner sc) {
        System.out.println("다시 시작하시겠습니까? (1: 재시작, 2: 종료)");
        String userInput = sc.nextLine();

        switch (userInput) {
            case "1":
                return true;
            case "2":
                return false;
            default:
                throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
        }
    }

}
