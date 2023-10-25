package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> input; // 플레이어가 입력한 숫자를 저장하는 리스트

    public Player() {
        input = new ArrayList<>();
    }

    public void addNumber(int number) {
        input.add(number);
    }

    public List<Integer> getInput() {
        return input;
    }
}

