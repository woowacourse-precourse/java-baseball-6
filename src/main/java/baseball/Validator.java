package baseball;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static baseball.Constant.*;

public class Validator {

    public static void checkEndOrRestart(String command){
        List<String> commandList;
        commandList = List.of(RESTART_GAME, STOP_GAME);
        if(!commandList.contains(command)){
            throw new IllegalArgumentException();
        }
    }

    public static void checkNumberLength(String number) {
        // 입력받은 값의 길이가 3이 아닐 경우
        if (number.length() != Constant.BALL_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkNumberType(String number) {
        // 1부터 9 사이의 "숫자"로 구성되지 않았을 경우
        if (!number.matches(Constant.NUM_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkDuplicatedNumber(String number) {
        Collection<Character> numberList = new ArrayList<>();
        // 중복된 숫자가 있을 경우
        for (Character singleNumber: number.toCharArray()) {
            if (numberList.contains(singleNumber)) {
                throw new IllegalArgumentException();
            }
            numberList.add(singleNumber);
        }
    }
}