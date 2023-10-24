package view;

import camp.nextstep.edu.missionutils.Console;

/**
 * packageName    : view
 * fileName       : InputView
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-19        qkrtn_ulqpbq2       최초 생성
 */
public class InputView {

    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ASK_RESET_GAME_MESSAGE = "게임을 시작하려면 1, 종료하려면 2를 입력해주세요";

    public String inputNumber(){
        System.out.print(INPUT_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public String enterAnswerRestartGame() {
        System.out.print(ASK_RESET_GAME_MESSAGE);
        return Console.readLine();
    }
}
