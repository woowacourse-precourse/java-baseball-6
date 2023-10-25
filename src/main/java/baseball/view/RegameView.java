package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class RegameView {
    private final String REGAME_MENT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private int regame;

    public int inputRegame() {
        System.out.println(REGAME_MENT);
        regame = Integer.parseInt(Console.readLine());
        return regame;
    }
}
