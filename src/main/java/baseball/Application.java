package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        Baseball baseball = new Baseball();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            baseball.playBaseball();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String play = Console.readLine();
            if (play.equals("1")) {
                continue;
            }
            if (play.equals("2")) {
                return;
            }
        }
    }
}
