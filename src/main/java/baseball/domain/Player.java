package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setPlayer(List<Integer> number) {
        numbers = number; // 컴퓨터의 숫자를 정한다.
    }
}
