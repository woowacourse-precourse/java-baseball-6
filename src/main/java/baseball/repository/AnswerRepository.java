package baseball.repository;

import baseball.domain.Numbers;

public class AnswerRepository {
    private static Numbers answer = new Numbers();

    public Numbers save(Numbers numbers) {
        answer = numbers;
        return answer;
    }

    public Numbers find() {
        return answer;
    }
}
