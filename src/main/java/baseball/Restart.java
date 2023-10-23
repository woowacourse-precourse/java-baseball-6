package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Restart {
    public static boolean restartGame(){
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        String input =  Console.readLine();
        int restartNumber = Integer.parseInt(input);
        if (!(restartNumber == 1|| restartNumber==2)) {
            throw new IllegalArgumentException("옳지 않은 입력입니다. 다시 입력해주세요.");
        }
        if (restartNumber == 2) {
            System.out.println("게임을 종료합니다.");
            return false;
        }
        return true;
    }
}
