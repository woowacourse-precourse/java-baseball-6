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

    public static boolean validateRestartOrExitChoice(String choice){//재시작, 종료 외의 예외처리

        if(choice.equals("1"))
            return true;
        else if(choice.equals("2"))
            return false;
        throw new IllegalArgumentException("1 또는 2를 입력하지 않았습니다.");
    }

}
