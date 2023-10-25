package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String SUCCESS_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void startGameMessage(){
        System.out.println(START_MESSAGE);
    }
    public String inputNumber(){
        System.out.print(INPUT_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public void successGameMessage(){
        System.out.println(SUCCESS_GAME_MESSAGE);
    }

    public String restartOrEndMessage(){
        System.out.println(RESTART_OR_END_MESSAGE);
        return Console.readLine();
    }

    public void printMessage(String message){
        System.out.println(message);
    }
}
