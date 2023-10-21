package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

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

    // TODO: test code 작성
    public List<Integer> compareWithAnswer(List<Integer> target) {
        // TODO: target에 대한 검증
        int strikeCount = 0, ballCount = 0;

        // TODO: Stream 문법으로 개선하기
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).equals(target.get(i))) {
                strikeCount++;
            }
        }

        // TODO: Stream 문법으로 개선하기
        for (int i = 0; i < answer.size(); i++) {
            for (int j = 0; j < answer.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (answer.get(i).equals(target.get(j))) {
                    ballCount++;
                }
            }
        }

        return List.of(strikeCount, ballCount);
    }

    public List<Integer> getAnswer() {
        return answer;
    }
}
