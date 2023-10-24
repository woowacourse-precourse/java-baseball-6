package baseball.models;

import java.util.ArrayList;
import java.util.List;

import baseball.utils.InputValidator;

/*
 유저의 변수들을 기억하는 클래스
 유저와 컴퓨터는 서로의 답을 직접 알지는 못한다.
 */

public class User {
    private final List<Integer> numberList = new ArrayList<>();
    private int mind;

    public void saveNumber(int number) {
        numberList.add(number);
    }

    public void changeMind(int restartInt) {
        mind = restartInt;
    }

    public List<Integer> showNumberList() {
        return new ArrayList<>(numberList);
    }

    public int showMind() {
        return mind;
    }

    public void clearAnswerList() {
        numberList.clear();
    }

}
