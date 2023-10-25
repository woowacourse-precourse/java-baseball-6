package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class RegameView {
    private final String REGAME_MENT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private boolean regame;

    public RegameView() {
        regame = false;
    }

    public boolean inputRegame() {
        System.out.println(REGAME_MENT);
        int regameInt = Integer.parseInt(Console.readLine());
        if (regameInt == 1) {
            regame = true;
        } else if (regameInt == 2) {
            regame = false;
        }
        return regame;
    }
}
