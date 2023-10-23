package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Restart {
    private final String EXIT = "2"; // 게임 종료 상수

    Restart() {

    }

    public void choiceRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String number = Console.readLine(); // 게임을 이어나갈지 사용자에게 값 전달받기
        if (number.equals(EXIT)) {
            exit();
        }
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.start(); // 재시작
    }

    void exit() { // 게임을 종료하는 함수
        System.out.print("게임 종료");
        System.exit(0);
    }
}
