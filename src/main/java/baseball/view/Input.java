package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {

    // player가 선택한 서로 다른 3가지 숫자
    private static String userNumber;
    // 게임 상태 번호
    private static String gameMode;

    // player가 서로 다른 숫자 3가지 입력
    public static void inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        userNumber = readLine();
        System.out.println();
    }

    // player가 게임 종료 후 재시작/종료 선택
    public static void endGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        gameMode = readLine();
    }
}
