package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> numbers;


    public Computer() {
        this.numbers = new ArrayList<Integer>();
        // 1~9까지 서로 다른 임의의 수 3개를 생성하여 저장
        generateRandomNumbers();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


    public Pair<Integer, Integer> judgeUserGuess(String userGuess) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < userGuess.length(); i++) {
            int userGuessNumber = userGuess.charAt(i) - '0';
            if (numbers.get(i) == userGuessNumber) {
                strike++;
            } else if (numbers.contains(userGuessNumber)) {
                ball++;
            }
        }
        return new Pair<Integer, Integer>(strike, ball);
    }

    public void printUserGuessJudgementResult(Pair<Integer, Integer> userGuessJudgement) {
        if (userGuessJudgement.getFirst() == 0 && userGuessJudgement.getSecond() == 0) {
            System.out.printf("낫싱\n");
        } else if (userGuessJudgement.getFirst() == 0) {
            System.out.printf("%d볼\n", userGuessJudgement.getSecond());
        } else if (userGuessJudgement.getSecond() == 0) {
            System.out.printf("%d스트라이크\n", userGuessJudgement.getFirst());
        } else {
            System.out.printf("%d볼 %d스트라이크\n", userGuessJudgement.getSecond(), userGuessJudgement.getFirst());
        }
    }

    public void generateRandomNumbers() {
        // 만약 numbers가 비어있지 않다면 비워준다.
        if (!numbers.isEmpty()) {
            numbers.clear();
        }
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

}

