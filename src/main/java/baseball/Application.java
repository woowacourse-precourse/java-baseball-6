package baseball;

import baseball.Controller.GameManager;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    public static final int NUM_DIGITS = 3;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new GameManager().playGame();

    }
    public static void validateUserThreeNumbers(String userThreeNumbers){
        if(userThreeNumbers.length()!=NUM_DIGITS)//3개 미만, 또는 초과해서 입력된 경우에 대한 예외처리
            throw new IllegalArgumentException("3개의 수를 입력하지 않았습니다.");

        Set<Character> uniqueChars = new HashSet<>();

        for(char char_num : userThreeNumbers.toCharArray()){
            if(char_num<'1' || char_num>'9')//1~9가 아닌 값에 대한 예외처리
                throw new IllegalArgumentException("1~9사이 수가 아닌 값을 입력하였습니다.");

            if(!uniqueChars.add(char_num))//중복된 수를 넣으려고 하는 경우 예외처리
                throw new IllegalArgumentException("중복된 수를 입력하였습니다.");
        }
    }

    public static boolean validateRestartOrExitChoice(String choice){//재시작, 종료 외의 예외처리

        if(choice.equals("1"))
            return true;
        else if(choice.equals("2"))
            return false;
        throw new IllegalArgumentException("1 또는 2를 입력하지 않았습니다.");
    }

}
