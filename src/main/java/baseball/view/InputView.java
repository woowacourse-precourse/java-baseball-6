package baseball.view;

import baseball.exception.InputException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final static String GET_GAME_NUM = "숫자를 입력해 주세요 : ";

    public void getGameNum() {
        System.out.println(GET_GAME_NUM);
        String gameNum = Console.readLine();
    }

    public void validateNum(String line) {
        if (!line.matches("\\d+")) {
            throw new IllegalArgumentException(InputException.NOT_INTEGER.getExceptionMessage());
        }
    }
}
