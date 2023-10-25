package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Retry {
    public boolean retry() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면1, 종료하려면2를 입력하세요.\n");
        char ans = Console.readLine().charAt(0);
        if (ans == '1') {
            return true;
        }
        return false;
    }
}