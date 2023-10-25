package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private Game(){ }
    public static boolean playOrNot() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            return false;
        } else if (input.equals("2")) {
            return true;
        }
        else{ // 잘못 누른 경우에도 종료
            return true;
        }
    }
}
