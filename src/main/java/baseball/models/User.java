package baseball.models;

import java.util.ArrayList;
import java.util.List;

import static baseball.utils.Constants.*;
import static baseball.utils.InputValidator.validateAnswerCharacter;

/*
 유저의 변수들을 기억하는 클래스
 유저와 컴퓨터는 서로의 답을 직접 알지는 못한다.
 사실 컴퓨터는 게임 규칙상 유저의 답안을 알 수도 있으나,
 코드의 통일성 유지를 위해 유저의 답을 숨겨두고 간접적으로 알려준다.
 */

public class User {
    private final List<Integer> numberList = new ArrayList<>();
    private int mind;

    public void saveNumber(char userAnswerChar){
        int digit = validateAnswerCharacter(userAnswerChar);
        numberList.add(digit);
    }

    public void changeMind(int restartInt){
        mind = restartInt;
    }

    public List<Integer> showNumberList(){
        return new ArrayList<>(numberList);
    }

    public int showMind(){
        return mind;
    }

    public void clearAnswerList(){
        numberList.clear();
    }

}
