package baseball.models;

import java.util.ArrayList;
import java.util.List;

import static baseball.models.Constants.*;

/*
 User의 변수들을 기억하는 클래스
 */

public class User {
    private final List<Integer> numberList = new ArrayList<>();
    private int mind;

    public void saveNumber(int digit){
        numberList.add(digit);
    }

    public void changeMind(int restartInt){
        mind = restartInt;
    }

    public List<Integer> showNumberList(){
        List<Integer> clonedList = new ArrayList<>();
        for (int i = 0; i < ANSWER_LENGTH; i++) {
            clonedList.add(numberList.get(i));
        }
        return clonedList;
    }

    public int showMind(){
        return mind;
    }

    public void clearAnswerList(){
        numberList.clear();
    }

}
