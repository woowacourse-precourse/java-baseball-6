package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String RESET_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." ;

    public static String inputNumber(){
        System.out.print(INPUT_NUMBER);
        return Console.readLine();
    }
    public static String resetGame(){
        System.out.println(RESET_GAME_MESSAGE);
        return Console.readLine();
    }

}
