package baseball.model;

import java.util.List;

public class ComputerNumberStorage {
    // 값 정의
    private List<Integer> _numbers;

    // 생성자
    public ComputerNumberStorage(List<Integer> numbers) {
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
