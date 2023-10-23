package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class View {
    private final static String START_COMMENT = "숫자 야구 게임을 시작합니다.";
    private final static String INPUT_COMMENT = "숫자를 입력해주세요 : ";

    public void printStart() {
        System.out.println(START_COMMENT);
    }

    public String inputNumber() {
        System.out.print(INPUT_COMMENT);
        return Console.readLine();
    }
}
