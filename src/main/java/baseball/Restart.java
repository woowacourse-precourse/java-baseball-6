package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Restart {
    private final String RESTART = "1";
    private final String EXIT = "2"; // 게임 종료 상수

    Restart() {

    }

    public boolean choiceRestart() { // 게임 종료시 false 반환하는 함수
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String number = Console.readLine(); // 게임을 이어나갈지 사용자에게 값 전달받기
        Console.close();
        if (number.equals(EXIT)) {
            System.out.print("게임 종료");
            return false;
        }
        return true;
    }
}
