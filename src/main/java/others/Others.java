package others;

import static others.ExceptionHandling.restartException;

import camp.nextstep.edu.missionutils.Console;

public class Others {
    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static boolean ifRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restart = Console.readLine().trim().replaceAll(" ", "");
        return restartException(restart);
    }
}