package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static void input() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
