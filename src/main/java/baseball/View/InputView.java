package baseball.View;


import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_USER_NUMBER = "숫자를 입력해주세요 : ";
    private static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    public static String inputUserNumber() {
        System.out.print(INPUT_USER_NUMBER);
        return Console.readLine();
    }

    public static String inputGameOverOrRestart() {
        System.out.println(GAME_OVER);
        return Console.readLine();
    }

}
