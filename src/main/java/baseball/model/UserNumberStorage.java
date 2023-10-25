package baseball.model;

import java.util.List;

public class UserNumberStorage {
    // 값 정의
    private List<Integer> _numbers;

    // 생성자
    public UserNumberStorage(List<Integer> numbers) {
        _numbers = numbers;
    }

    // getter
    public List<Integer> getNumbers() {
        return _numbers;
    }

    // setter
    public void setNumbers(List<Integer> numbers) {
        _numbers = numbers;
    }

}
