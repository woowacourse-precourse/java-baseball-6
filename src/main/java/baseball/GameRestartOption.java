package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameRestartOption {
    public String getInput() {
        return Console.readLine();
    }


    public boolean askForRestart() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        String input = getInput();

        if (input.equals("1")) {
            return true; // 게임 재시작
        } else if (input.equals("2")) {
            return false; // 게임 종료
        } else {
            System.out.println("올바른 선택이 아닙니다. 1 또는 2를 입력하세요.");
            return askForRestart(); // 잘못된 입력 시 다시 입력 요청
        }
    }
}
