package baseball.service;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ASK_RESTART_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ";

    //사용자가 숫자 입력하는 View
    public String enterPlayerNumber(){
        System.out.print(INPUT_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public String enterEndOrRestartGame(){
        System.out.print(ASK_RESTART_GAME_MESSAGE);
        return Console.readLine();
    }
}
