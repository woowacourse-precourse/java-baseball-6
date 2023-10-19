package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {

    /**
     * 사용자에게 서로 다른 3가지 정수를 입력받는다.
     * @return 사용자가 입력한 정수를 List<Integer>에 담아 반환
     * @throws IllegalArgumentException
     */
    public List<Integer> getInput() throws IllegalArgumentException{
        return new ArrayList<>();
    }

    /**
     * 재시작 여부를 입력받는다.
     * @return  1 - 재시작, 2 - 종료
     * @throws IllegalArgumentException
     */
    public int inputMenu() throws IllegalArgumentException{
        return 0;
    }
}
