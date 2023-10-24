package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    public void run() {
        do {
            System.out.println("숫자 야구 게임을 시작합니다.");
        } while (inputRegame());
    }

    public boolean inputRegame() {
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        }
        return false;
    }
}
