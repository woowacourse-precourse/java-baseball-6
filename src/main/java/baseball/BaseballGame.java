package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    public BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void playGame() {
        while (true) {

            if (!playNextGameOrStop()) {
                break;
            }
        }
    }

    private boolean playNextGameOrStop() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException("잘못된 입력입니다.");
    }


}
