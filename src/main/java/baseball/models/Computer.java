package baseball.models;

import java.util.ArrayList;
import java.util.List;

import static baseball.utils.InputValidator.*;
/*
 Computer의 변수들을 기억하는 클래스
 */

public class Computer {
    private final List<Integer> numberList = new ArrayList<>();

    public void saveNumber(int randomNumber){
        validateDigitRange(randomNumber);
        numberList.add(randomNumber);
    }

    public int getListSize(){
        return numberList.size();
    }

    public List<Integer> showNumberList() {
        return new ArrayList<>(numberList);
    }

    public void clearAnswerList(){
        numberList.clear();
    }

}
