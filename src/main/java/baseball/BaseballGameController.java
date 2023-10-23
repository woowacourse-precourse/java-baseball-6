package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameController {
    private boolean isRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String control = Console.readLine();

        // 예외 처리
        if (control.length() != 1) {
            throw new IllegalArgumentException();
        }

        int again = control.charAt(0) - '0';
        return switch (again) {
            case 1 -> true;
            case 2 -> false;
            default -> throw new IllegalArgumentException();
        };
    }

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean start = true;
        while (start) {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.play();
            start = this.isRestart();
        }
    }
}
