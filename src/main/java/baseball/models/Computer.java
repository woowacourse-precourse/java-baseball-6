package baseball.models;

import java.util.ArrayList;
import java.util.List;

import baseball.utils.InputValidator;
/*
 컴퓨터의 변수들을 기억하는 클래스
 유저는 컴퓨터의 답을 직접 알지는 못한다.
*/

public class Computer {
    private final List<Integer> numberList = new ArrayList<>();

    public void saveNumber(int randomNumber) {
        InputValidator.validateDigitRange(randomNumber);
        numberList.add(randomNumber);
    }

    public int getListSize() {
        return numberList.size();
    }

    public List<Integer> showNumberList() {
        return new ArrayList<>(numberList);
    }

    public void clearAnswerList() {
        numberList.clear();
    }

}
