package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameControl {
    private boolean continuing = true;

    public void changeContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하십시오.");
        int num = Integer.parseInt(Console.readLine());
        if (num == 1) {
            this.continuing = true;
        } else if (num == 2){
            this.continuing = false;
        } else {
            throw new IllegalArgumentException("1 또는 2를 입력하여 주십시오.");
        }
    }

    public boolean isContinuing() {
        return continuing;
    }
}
