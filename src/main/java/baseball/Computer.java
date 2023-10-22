package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Computer {
    private final List<Integer> answer;

    public Computer() {
        this.answer = generateAnswer();
    }

    public Computer(List<Integer> answer) {
        // TODO: 중복된, 범위 밖의 숫자가 포함된 경우, 예외처리
        this.answer = answer;
    }

    private List<Integer> generateAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    public List<Integer> compareWithAnswer(List<Integer> target) {
        // TODO: target에 대한 검증
        return List.of(countBall(target), countStrike(target));
    }

    private int countBall(List<Integer> target) {
        int ballCount = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).equals(target.get(i))) {
                continue;
            }
            if (target.contains(answer.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }


    private int countStrike(List<Integer> target) {
        return (int) IntStream.range(0, answer.size())
                .filter(i -> answer.get(i).equals(target.get(i)))
                .count();
    }

    public List<Integer> getAnswer() {
        return answer;
    }
}
