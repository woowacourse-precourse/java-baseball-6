package baseball.player;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private static final List<Integer> userInputList = new ArrayList<>();
    private static String inputStr;

    public List<Integer> inputNum() throws IllegalArgumentException {
        inputStr = Console.readLine();
        for (int i = 0; i < inputStr.length(); i++) {
            validInput(inputStr.charAt(i) - '0');
        }

        return userInputList;
    }

    /*
     * player list 초기화
     *  */
    public void initPlayer() {
        userInputList.clear();
    }

    /* 입력 검증 */
    private void validInput(int iNum) throws IllegalArgumentException {

        if (iNum < 1 || iNum > 9) {
            throw new IllegalArgumentException("잘못된 입력입니다.(숫자만 허용)");
        }

        if (userInputList.contains(iNum)) {
            throw new IllegalArgumentException("잘못된 입력입니다.(중복 불가)");
        }

        if (inputStr.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다.(3자리 숫자만 허용)");
        }

        userInputList.add(iNum);
    }
}
